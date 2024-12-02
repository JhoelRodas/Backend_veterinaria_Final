package bo.com.jvargas.veterinaria.negocio.compra.impl;

import bo.com.jvargas.veterinaria.datos.model.Detalle;
import bo.com.jvargas.veterinaria.datos.model.DetalleId;
import bo.com.jvargas.veterinaria.datos.model.NotaCompra;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.dto.DetalleDto;
import bo.com.jvargas.veterinaria.datos.repository.compra.DetalleRepository;
import bo.com.jvargas.veterinaria.datos.repository.compra.NotaCompraRepository;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.negocio.compra.DetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("DetalleService")
public class DetalleServiceImpl implements DetalleService {

    private final DetalleRepository detalleRepository;
    private final ProductoRepository productoRepository;
    private final NotaCompraRepository notaCompraRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleDto> listarDetalles() {
        return detalleRepository.findAll().stream()
                .map(DetalleDto::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetalleDto> getDetalles(Long idNotaCompra) {
        return detalleRepository.findAllByIdNotaCompra_Id(idNotaCompra)
                .stream()
                .map(DetalleDto::toDto2)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Optional<DetalleDto> insertarDetalle(DetalleDto detalleDto) {
        Optional<Producto> optionalProducto =
                productoRepository.findByIdAndDeletedFalse(detalleDto.getIdProducto());
        Optional<NotaCompra> optionalNotaCompra =
                notaCompraRepository.findByIdAndDeletedFalse(detalleDto.getIdNotaCompra());

        if (optionalProducto.isEmpty())
            throw new RuntimeException("Producto no encontrado");

        Detalle detalle = getDetalle(detalleDto, optionalNotaCompra, optionalProducto);

        Detalle detalleGuardado = detalleRepository.save(detalle);

        return Optional.of(DetalleDto.toDto(detalleGuardado));
    }

    private static Detalle getDetalle(DetalleDto detalleDto,
                                      Optional<NotaCompra> optionalNotaCompra,
                                      Optional<Producto> optionalProducto) {
        if (optionalNotaCompra.isEmpty())
            throw new RuntimeException("Nota de compra no encontrada");

        Producto producto = optionalProducto.get();
        NotaCompra notaCompra = optionalNotaCompra.get();

        Detalle detalle = new Detalle();
        detalle.setId(new DetalleId(detalleDto.getIdProducto(), detalleDto.getIdNotaCompra()));
        detalle.setIdProducto(producto);
        detalle.setIdNotaCompra(notaCompra);
        detalle.setCantidad(detalleDto.getCantidad());
        detalle.setMonto(detalleDto.getMonto());
        return detalle;
    }

    @Transactional
    @Override
    public List<DetalleDto> insertarDetalles(List<DetalleDto> detallesDto) {
        if (detallesDto == null || detallesDto.isEmpty())
            throw new RuntimeException("La lista de detalles no puede estar vacia");

        List<Detalle> detalles = insertar(detallesDto);

        List<Detalle> detallesGuardados = detalleRepository.saveAll(detalles);

        return detallesGuardados.stream()
                .map(DetalleDto::toDto)
                .collect(Collectors.toList());
    }

    private List<Detalle> insertar(List<DetalleDto> detallesDeto) {
        List<Detalle> detalles = new LinkedList<>();

        for (DetalleDto detalleDto : detallesDeto) {
            Optional<Producto> optionalProducto =
                    productoRepository.findByIdAndDeletedFalse(
                            detalleDto.getIdProducto());
            Optional<NotaCompra> optionalNotaCompra =
                    notaCompraRepository.findByIdAndDeletedFalse(
                            detalleDto.getIdNotaCompra());

            if (optionalProducto.isEmpty())
                throw new RuntimeException("Producto no encontrado");

            Detalle detalle = getDetalle(detalleDto, optionalNotaCompra,
                    optionalProducto);
            detalles.add(detalle);
            actualizarCostosProducto(detalleDto);
        }

        return detalles;
    }

    private void actualizarCostosProducto(DetalleDto detalle) {
        Optional<Producto> optionalProducto = productoRepository.findByIdAndDeletedFalse(detalle.getIdProducto());

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            // Calcular nuevo costo promedio y costo de compra
            BigDecimal stockActual = new BigDecimal(producto.getStock());
            BigDecimal nuevoStock = new BigDecimal(detalle.getCantidad());
            BigDecimal costoPromedioActual = producto.getCostoPromedio();
            BigDecimal nuevoCostoCompra = detalle.getMonto().divide(nuevoStock, RoundingMode.HALF_UP);

            // Fórmula de promedio ponderado
            BigDecimal nuevoCostoPromedio = (stockActual.multiply(costoPromedioActual)
                    .add(nuevoStock.multiply(nuevoCostoCompra)))
                    .divide(stockActual.add(nuevoStock), RoundingMode.HALF_UP);

            // Actualizar valores en el producto
            producto.setCostoPromedio(nuevoCostoPromedio);
            producto.setCostoCompra(nuevoCostoCompra);

            // Guardar producto actualizado
            productoRepository.save(producto);
        }
    }

    @Transactional
    @Override
    public void eliminarDetalle(Long idProducto, Long idNotaCompra) {
        DetalleId detalleId = new DetalleId(idProducto, idNotaCompra);
        Optional<Detalle> oDetalle = detalleRepository.findById(detalleId);

        if (oDetalle.isEmpty())
            throw new RuntimeException("Detalle no encontrado");

//        detalleRepository.delete(oDetalle.get());

        // Recalcular costos del producto tras eliminar el detalle
        recalcularCostosProducto(idProducto);
    }

    private void recalcularCostosProducto(Long idProducto) {
        Optional<Producto> optionalProducto = productoRepository.findByIdAndDeletedFalse(idProducto);

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            // Obtener detalles asociados a notas de compra activas
            List<Detalle> detallesActivos = detalleRepository
                    .findAllByIdProducto_IdAndIdNotaCompra_DeletedFalse(idProducto);

            BigDecimal nuevoCostoPromedio = BigDecimal.ZERO;
            BigDecimal nuevoCostoCompra = BigDecimal.ZERO;
            BigDecimal totalStock = BigDecimal.ZERO;

            for (Detalle detalle : detallesActivos) {
                BigDecimal cantidad = new BigDecimal(detalle.getCantidad());
                BigDecimal costoUnitario = detalle.getMonto().divide(cantidad, RoundingMode.HALF_UP);

                nuevoCostoCompra = costoUnitario; // Último costo de compra
                nuevoCostoPromedio = nuevoCostoPromedio.add(cantidad.multiply(costoUnitario));
                totalStock = totalStock.add(cantidad);
            }

            // Si hay stock restante, calcular costo promedio
            if (totalStock.compareTo(BigDecimal.ZERO) > 0) {
                nuevoCostoPromedio = nuevoCostoPromedio.divide(totalStock, RoundingMode.HALF_UP);
            }

            // Actualizar el producto
            producto.setCostoPromedio(nuevoCostoPromedio);
            producto.setCostoCompra(nuevoCostoCompra);
            producto.setStock(totalStock.shortValue());

            productoRepository.save(producto);
        }
    }
}

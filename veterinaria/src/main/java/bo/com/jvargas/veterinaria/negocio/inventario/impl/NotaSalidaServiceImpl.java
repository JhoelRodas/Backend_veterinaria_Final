package bo.com.jvargas.veterinaria.negocio.inventario.impl;

import bo.com.jvargas.veterinaria.datos.model.NotaSalida;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.dto.NotaSalidaDto;
import bo.com.jvargas.veterinaria.datos.model.sistema.enums.TipoProceso;
import bo.com.jvargas.veterinaria.datos.repository.inventario.NotaSalidaRepository;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.negocio.admusuarios.BitacoraService;
import bo.com.jvargas.veterinaria.negocio.inventario.NotaSalidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("NotaSalidaService")
public class NotaSalidaServiceImpl implements NotaSalidaService {

    private final NotaSalidaRepository repository;
    private final ProductoRepository productoRepository;
    private final BitacoraService bitacoraService;

    @Override
    @Transactional(readOnly = true)
    public List<NotaSalidaDto> listar() {
        return repository.findAllByDeletedFalse().stream()
                .map(NotaSalidaDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void registrar(NotaSalidaDto nuevaNota) {
        NotaSalida notaSalida = NotaSalidaDto.toEntity(nuevaNota);

        Producto producto = getProducto(nuevaNota.getIdProducto());
        if (nuevaNota.getCantidad() > producto.getStock())
            throw new IllegalArgumentException("La cantidad excede al inventario");

        producto.setStock((short) (producto.getStock() - nuevaNota.getCantidad()));
        productoRepository.save(producto);

        notaSalida.setProducto(producto);
        NotaSalida notaSalida1 = repository.save(notaSalida);
        bitacoraService.info(TipoProceso.GESTIONAR_NOTA_SALIDA,
                "Nota de Salida Registrado: {}", notaSalida1.getId());
    }

    private Producto getProducto(Long id) {
        return productoRepository.findByIdAndDeletedFalse(id).orElseThrow(
                ()-> new IllegalArgumentException("No existe el producto con ID " + id)
        );
    }

    @Override
    @Transactional
    public void editar(Long id, NotaSalidaDto nuevaNota) {
        NotaSalida notaEditada = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "No existe la nota de salida con el ID " + id
                )
        );
        actualizarDatos(notaEditada, nuevaNota);
        repository.save(notaEditada);
        bitacoraService.info(TipoProceso.GESTIONAR_NOTA_SALIDA,
                "Nota de Salida Actualizado: {}", notaEditada.getId());
    }

    private void actualizarDatos(NotaSalida notaEditar, NotaSalidaDto nuevaNota) {
        if (!notaEditar.getProducto().getId().equals(nuevaNota.getIdProducto())) {
            Producto productoAnt = productoRepository.findById(notaEditar.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            //Devolvemos el stock
            productoAnt.setStock((short) (productoAnt.getStock() + notaEditar.getCantidad()));
            productoRepository.save(productoAnt);

            //Buscamos el Nuevo producto
            Producto nuevoProducto = productoRepository.findById(nuevaNota.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            if (nuevaNota.getCantidad() > nuevoProducto.getStock())
                throw new IllegalArgumentException("La cantidad excede al inventario");

            nuevoProducto.setStock((short) (nuevoProducto.getStock() - nuevaNota.getCantidad()));
            productoRepository.save(nuevoProducto);

            notaEditar.setProducto(nuevoProducto);
        } else {
            Producto producto = getProducto(notaEditar.getProducto().getId());
            if (nuevaNota.getCantidad() > notaEditar.getCantidad()) {
                if (nuevaNota.getCantidad() > producto.getStock() + notaEditar.getCantidad())
                    throw new IllegalArgumentException("La cantidad excede al inventario");

                producto.setStock((short) (producto.getStock() -
                        (nuevaNota.getCantidad() - notaEditar.getCantidad())));
                productoRepository.save(producto);
            } else {
                producto.setStock((short) (producto.getStock() +
                        (notaEditar.getCantidad() - nuevaNota.getCantidad())));
                productoRepository.save(producto);
            }
        }
        notaEditar.setFecha(nuevaNota.getFecha());
        notaEditar.setCantidad(nuevaNota.getCantidad());
        notaEditar.setMotivo(nuevaNota.getMotivo());
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        NotaSalida notaEditada = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "No existe la nota de salida con el ID " + id
                )
        );

        notaEditada.setDeleted(true);
        Producto productoAnt = getProducto(notaEditada.getProducto().getId());
        //Devolvemos el stock
        productoAnt.setStock((short) (productoAnt.getStock() + notaEditada.getCantidad()));
        productoRepository.save(productoAnt);
        repository.save(notaEditada);
        bitacoraService.info(TipoProceso.GESTIONAR_NOTA_SALIDA,
                "Nota de Salida Registrado: {}", id);
    }
}

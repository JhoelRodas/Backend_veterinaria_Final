package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.Cliente;
import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.DetalleProductoDto;
import bo.com.jvargas.veterinaria.datos.model.dto.DetalleServicioDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDetalleDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDto;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ClienteRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ReciboRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.ClienteService;
import bo.com.jvargas.veterinaria.negocio.ventas.DetalleProductoService;
import bo.com.jvargas.veterinaria.negocio.ventas.DetalleServicioService;
import bo.com.jvargas.veterinaria.negocio.ventas.ReciboService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("ReciboService")
public class ReciboServiceImpl implements ReciboService {

    private final ReciboRepository reciboRepository;
    private final ClienteRepository clienteRepository;
    private final DetalleProductoService detalleService;
    private final ClienteService clienteService;
    private final DetalleServicioService detalleServicioService;

    @Override
    @Transactional(readOnly = true)
    public List<ReciboDto> listarRecibos() {
        return reciboRepository.findAllByDeletedFalse().stream()
                .map(ReciboDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ReciboDetalleDto verRecibo(Long id) {
        Recibo recibo = reciboRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el recibo con el ID " + id
                ));

        Long idRecibo = recibo.getId();
        List<DetalleProductoDto> detalles = detalleService
                .listarDetalles(idRecibo);
        List<DetalleServicioDto> detalleServicio = detalleServicioService
                .listar(idRecibo);
        return ReciboDetalleDto.toDto(recibo, detalles, detalleServicio);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReciboDto> listarRecibosReporte(Date from, Date to) {
        LocalDate fromLocal = LocalDate.ofEpochDay(from.getTime());
        LocalDate toLocal = LocalDate.ofEpochDay(to.getTime());
        return reciboRepository.listaFiltrada(fromLocal,toLocal).stream()
                .map(ReciboDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void guardarRecibo(ReciboDetalleDto nuevoRecibo) {
        Recibo reciboAGuardar = ReciboDetalleDto.toEntity(nuevoRecibo);

        reciboAGuardar.setFecha(LocalDate.now());
        Cliente cliente = getCliente(nuevoRecibo);
        reciboAGuardar.setIdCliente(cliente);
        BigDecimal montoTotal = calcularMontoTotal(
                nuevoRecibo.getDetalles(), nuevoRecibo.getDetallesServicios());
        reciboAGuardar.setMontoTotal(montoTotal);

        Recibo reciboGuardado = reciboRepository.save(reciboAGuardar);
        Long idReciboGuardado = reciboGuardado.getId();
        List<DetalleProductoDto> detalles = nuevoRecibo.getDetalles();
        List<DetalleServicioDto> detalleServicio = nuevoRecibo.getDetallesServicios();
        actualizarIdReciboEnLosDetalles(idReciboGuardado, detalles, detalleServicio);
        if (detalles != null && !detalles.isEmpty())
            detalleService.insertarDetallesProductos(detalles);

        if (detalleServicio != null && !detalleServicio.isEmpty())
            detalleServicioService.insertarDetallesServicios(detalleServicio);
    }

    private BigDecimal calcularMontoTotal(List<DetalleProductoDto> productos,
                                          List<DetalleServicioDto> servicios) {
        BigDecimal montoTotal = new BigDecimal(0);
        if (productos != null && !productos.isEmpty()) {
            for (DetalleProductoDto productoDto : productos) {
                montoTotal = montoTotal.add(productoDto.getMonto());
            }
            
        }

        if (servicios != null && !servicios.isEmpty()) {
            for (DetalleServicioDto servicioDto : servicios) {
                montoTotal = montoTotal.add(servicioDto.getMonto());
            }
        }

        return montoTotal;
    }

    private Cliente getCliente(ReciboDetalleDto nuevoRecibo) {
        Optional<Cliente> o = clienteRepository.
                findByCiAndDeletedFalse(nuevoRecibo.getCi());

        if (o.isPresent())
            return o.get();

        Cliente cliente = new Cliente(nuevoRecibo.getCi(), nuevoRecibo.getExtension(),
                nuevoRecibo.getNombre());

        clienteService.registrar(cliente);
        Optional<Cliente> optional = clienteRepository.findByCiAndDeletedFalse(nuevoRecibo.getCi());


        return optional.orElseThrow();
    }

    private void actualizarIdReciboEnLosDetalles(
            Long idRecibo, List<DetalleProductoDto> detalles,
            List<DetalleServicioDto> detalleServicios) {

        if (detalles != null && !detalles.isEmpty()) {
            for (DetalleProductoDto detalle : detalles) {
                detalle.setIdRecibo(idRecibo);
            }
        }

        if (detalleServicios != null && !detalleServicios.isEmpty()) {
            for (DetalleServicioDto servicioDto : detalleServicios) {
                servicioDto.setIdRecibo(idRecibo);
            }
        }
    }

    @Override
    @Transactional
    public void anularRecibo(Long id) {
        Optional<Recibo> o = reciboRepository.findByIdAndDeletedFalse(id);
        if (o.isEmpty())
            throw new RuntimeException("No existe un recibo con el ID " + id);

        Recibo recibo = o.get();
        recibo.setDeleted(true);
        reciboRepository.save(recibo);
    }
}

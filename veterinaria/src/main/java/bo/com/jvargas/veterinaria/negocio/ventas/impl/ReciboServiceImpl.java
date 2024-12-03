package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.Cliente;
import bo.com.jvargas.veterinaria.datos.model.NotaCompra;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.*;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ClienteRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ReciboRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.ClienteService;
import bo.com.jvargas.veterinaria.negocio.ventas.DetalleProductoService;
import bo.com.jvargas.veterinaria.negocio.ventas.DetalleServicioService;
import bo.com.jvargas.veterinaria.negocio.ventas.ReciboService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.ErrorManager;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service("ReciboService")
public class ReciboServiceImpl implements ReciboService {

    private final ReciboRepository reciboRepository;
    private final ClienteRepository clienteRepository;
    private final DetalleProductoService detalleService;
    private final ClienteService clienteService;
    private final DetalleServicioService detalleServicioService;
    private final ProductoRepository productoRepository;

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

    @Override
    @Transactional(readOnly = true)
    public List<ReciboDto> listarRecibosReporte(
            LocalDate inicio, LocalDate fin, BigDecimal montoMayor,
            BigDecimal montoMenor, String metodoPago) {


        System.out.println("Parámetros recibidos:");
        System.out.println("Fecha Inicio: " + inicio);
        System.out.println("Fecha Fin: " + fin);
        System.out.println("Monto Mayor: " + montoMayor);
        System.out.println("Monto Menor: " + montoMenor);
        System.out.println("Método de Pago: " + metodoPago);

        return reciboRepository.listaFiltradaReporteVentas(
                inicio, fin,  montoMayor,
                 montoMenor,  metodoPago
        );
    }

//    LocalDate fromLocal = LocalDate.ofEpochDay(from.getTime());
//    LocalDate toLocal = LocalDate.ofEpochDay(to.getTime());
//        return reciboRepository.listaFiltrada(fromLocal,toLocal).stream()
//                .map(ReciboDto::toDto)
//                .collect(Collectors.toList());
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

        // Recuperar los detalles de productos asociados al recibo
        List<DetalleProductoDto> detallesProductos = detalleService.listarDetalles(recibo.getId());

        // Revertir el stock de los productos
        for (DetalleProductoDto detalle : detallesProductos) {
            devolverStock(detalle);
        }

        // Marcar el recibo como anulado
        recibo.setDeleted(true);
        reciboRepository.save(recibo);
    }

    @Override
    @Transactional(readOnly = true)
    public byte[] generarPdfVenta(Long id) {
        // Obtener el recibo y detalles
        Recibo recibo = getRecibo(id);
        List<DetalleProductoDto> listaDeDetallesProductos = detalleService.listarDetalles(recibo.getId());
        List<DetalleServicioDto> listaDeDetallesServicios = detalleServicioService.listar(recibo.getId());

        // Crear PDF
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Agregar datos principales del recibo
            document.add(new Paragraph("Recibo de Venta"));
            document.add(new Paragraph("ID de Recibo: " + recibo.getId()));
            document.add(new Paragraph("Fecha: " + recibo.getFecha()));
            document.add(new Paragraph("Cliente: " + (recibo.getIdCliente() != null ? recibo.getIdCliente().getNombre() : "N/A")));
            document.add(new Paragraph("CI: " + (recibo.getIdCliente() != null && recibo.getIdCliente().getCi() != null ? recibo.getIdCliente().getCi() : "N/A")));
            document.add(new Paragraph("Monto Total: " + recibo.getMontoTotal()));
            document.add(new Paragraph(" ")); // Espacio entre datos principales y la tabla

            // Tabla para productos
            if (!listaDeDetallesProductos.isEmpty()) {
                document.add(new Paragraph("Detalles de Productos"));
                PdfPTable tableProductos = new PdfPTable(4); // 4 columnas: ID Producto, Nombre, Cantidad, Monto
                tableProductos.setWidthPercentage(100);

                // Encabezados de la tabla de productos
                tableProductos.addCell("ID Producto");
                tableProductos.addCell("Nombre");
                tableProductos.addCell("Cantidad");
                tableProductos.addCell("Monto");

                for (DetalleProductoDto detalle : listaDeDetallesProductos) {
                    tableProductos.addCell(String.valueOf(detalle.getIdProducto()));
                    tableProductos.addCell(detalle.getNombreProducto() != null ? detalle.getNombreProducto() : "N/A");
                    tableProductos.addCell(String.valueOf(detalle.getCant()));
                    tableProductos.addCell(String.valueOf(detalle.getMonto()));
                }

                document.add(tableProductos);
            }

            document.add(new Paragraph(" ")); // Espacio entre tablas

            // Tabla para servicios
            if (!listaDeDetallesServicios.isEmpty()) {
                document.add(new Paragraph("Detalles de Servicios"));
                PdfPTable tableServicios = new PdfPTable(4); // 4 columnas: ID Servicio, Nombre, Cantidad, Monto
                tableServicios.setWidthPercentage(100);

                // Encabezados de la tabla de servicios
                tableServicios.addCell("ID Servicio");
                tableServicios.addCell("Nombre");
                tableServicios.addCell("Cantidad");
                tableServicios.addCell("Monto");

                for (DetalleServicioDto detalle : listaDeDetallesServicios) {
                    tableServicios.addCell(String.valueOf(detalle.getIdServicio()));
                    tableServicios.addCell(detalle.getNombreServicio() != null ? detalle.getNombreServicio() : "N/A");
                    tableServicios.addCell(String.valueOf(detalle.getCant()));
                    tableServicios.addCell(String.valueOf(detalle.getMonto()));
                }

                document.add(tableServicios);
            }

            // Cerrar el documento
            document.close();
        } catch (DocumentException e) {
            log.error("Error al generar PDF para el recibo con ID: " + id, e);
            return null;
        }
        return out.toByteArray();

    }

    private Recibo getRecibo(Long id) {
        return reciboRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el recibo con el ID " + id
                ));
    }

    private void devolverStock(DetalleProductoDto detalle) {
        Optional<Producto> optionalProducto = productoRepository.findByIdAndDeletedFalse(detalle.getIdProducto());
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            // Sumar la cantidad del detalle al stock actual
            producto.setStock((short) (producto.getStock() + detalle.getCant()));

            // Guardar el producto actualizado
            productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado para el detalle ID: " + detalle.getIdProducto());
        }
    }
}

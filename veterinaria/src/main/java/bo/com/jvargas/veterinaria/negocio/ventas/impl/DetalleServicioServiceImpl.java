package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.*;
import bo.com.jvargas.veterinaria.datos.model.dto.DetalleServicioDto;
import bo.com.jvargas.veterinaria.datos.repository.ventas.DetalleServicioRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ReciboRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ServicioRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.DetalleServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("DetalleServicioService")
public class DetalleServicioServiceImpl implements DetalleServicioService {

    private final DetalleServicioRepository detalleServicioRepository;
    private final ServicioRepository servicioRepository;
    private final ReciboRepository reciboRepository;

    @Override
    public List<DetalleServicioDto> listar(Long idRecibo) {
        return detalleServicioRepository.findAllByIdRecibo_Id(idRecibo).stream()
                .map(DetalleServicioDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insertarDetallesServicios(List<DetalleServicioDto> nuevosDetalles) {
        if (nuevosDetalles == null || nuevosDetalles.isEmpty())
            throw new RuntimeException("La lista de detalles de servicios" +
                    " no puede estar vacia");

        List<DetalleServicio> detalleServicios = ajustarDetalles(nuevosDetalles);
        detalleServicioRepository.saveAll(detalleServicios);
    }

    private List<DetalleServicio> ajustarDetalles(
            List<DetalleServicioDto> nuevosDetalles) {
        List<DetalleServicio> detalleServicios = new LinkedList<>();

        for (DetalleServicioDto detalleDto : nuevosDetalles) {
            Servicio servicio = getServicio(detalleDto);
            Recibo recibo = getRecibo(detalleDto);
            DetalleServicio detalleServicio = getDetalleServicio(detalleDto,
                    servicio, recibo);

            detalleServicios.add(detalleServicio);
        }

        return detalleServicios;
    }

    private Recibo getRecibo(DetalleServicioDto nuevoDetalle) {
        Long idRecibo = nuevoDetalle.getIdRecibo();
        Optional<Recibo> o = reciboRepository.findByIdAndDeletedFalse(idRecibo);

        if (o.isEmpty())
            throw new RuntimeException("Recibo con ID " + idRecibo +
                    " no encontrado");

        return o.get();
    }

    private Servicio getServicio(DetalleServicioDto nuevoDetalle) {
        Long idServicio = nuevoDetalle.getIdServicio();
        return servicioRepository.findByIdAndDeletedFalse(idServicio)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Servicio con ID " + idServicio + "no encontrado"
                ));
    }

    private DetalleServicio getDetalleServicio(
            DetalleServicioDto detalleDto, Servicio servicio, Recibo recibo) {
        DetalleServicio detalleServicio = new DetalleServicio();
        DetalleServicioId detalleServicioId = new DetalleServicioId(
                recibo.getId(), servicio.getId());
        detalleServicio.setId(detalleServicioId);
        detalleServicio.setIdRecibo(recibo);
        detalleServicio.setIdServicio(servicio);
        detalleServicio.setCant(detalleDto.getCant());
        detalleServicio.setMonto(detalleDto.getMonto());

        return detalleServicio;
    }
}

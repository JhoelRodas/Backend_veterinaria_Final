package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.Atencion;
import bo.com.jvargas.veterinaria.datos.model.HistorialClinico;
import bo.com.jvargas.veterinaria.datos.model.Mascota;
import bo.com.jvargas.veterinaria.datos.model.dto.AtencionDto;
import bo.com.jvargas.veterinaria.datos.model.dto.AtencionServicioDto;
import bo.com.jvargas.veterinaria.datos.repository.MascotaRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.AtencionRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.HistorialClinicoRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.AtencionService;
import bo.com.jvargas.veterinaria.negocio.ventas.AtencionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("AtencionService")
public class AtencionServiceImpl implements AtencionService {

    private final AtencionRepository atencionRepository;
    private final MascotaRepository mascotaRepository;
    private final AtencionServicioService service;

    @Override
    @Transactional(readOnly = true)
    public List<AtencionDto> listar() {
        return atencionRepository.findAllByDeletedFalse().stream()
                .map(AtencionDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AtencionDto obtenerAtencion(Long id) {
        return AtencionDto.toDto(getAtencion(id));
    }

    private Atencion getAtencion(Long id) {
        return atencionRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la Atencion con el ID " + id
                ));
    }

    @Override
    @Transactional
    public void guardarAtencion(AtencionDto atencionNueva) {
        Atencion atencionAGuardar = AtencionDto.toEntity(atencionNueva);

        atencionAGuardar.setFecha(LocalDate.now());
        atencionAGuardar.setHora(LocalTime.now());

        Mascota mascota = getMascota(atencionNueva);
        HistorialClinico historialClinico = mascota.getIdHistorial();
        atencionAGuardar.setIdMascota(mascota);
        atencionAGuardar.setIdHistorial(historialClinico);

        Atencion atencionGuardada = atencionRepository.save(atencionAGuardar);
        Long idAtencionGuardada = atencionGuardada.getId();
        List<AtencionServicioDto> servicios = atencionNueva.getServicios();
        actualizarIdEnEnAtencionServicios(servicios, idAtencionGuardada);
        service.insertarServicios(servicios);
    }

    private Mascota getMascota(AtencionDto atencionNueva) {
        Long idMascota = atencionNueva.getIdMascota();
        return mascotaRepository.findByIdAndDeletedFalse(idMascota)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la mascota con el ID " + idMascota
                ));
    }

    private void actualizarIdEnEnAtencionServicios(
            List<AtencionServicioDto> servicioDtos,
            Long idAtencionGuardada) {
        for (AtencionServicioDto servicioDto : servicioDtos) {
            servicioDto.setIdAtencion(idAtencionGuardada);
        }
    }

    @Override
    @Transactional
    public void borrarAtencion(Long id) {
        Atencion atencion = getAtencion(id);
        atencion.setDeleted(true);
        atencionRepository.save(atencion);
    }
}
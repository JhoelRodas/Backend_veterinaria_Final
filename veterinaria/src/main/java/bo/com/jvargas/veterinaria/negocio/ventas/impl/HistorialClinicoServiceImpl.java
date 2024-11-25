package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.HistorialClinico;
import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.dto.AtencionDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ControlVacunaDto;
import bo.com.jvargas.veterinaria.datos.model.dto.HistorialClinicoDto;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.AtencionRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ControlVacunaRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.HistorialClinicoRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.HistorialClinicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("HistorialClinicoService")
public class HistorialClinicoServiceImpl implements HistorialClinicoService {

    private final HistorialClinicoRepository historialClinicoRepository;
    private final ControlVacunaRepository controlVacunaRepository;
    private final ProductoRepository productoRepository;
    private final AtencionRepository atencionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<HistorialClinicoDto> listarHistoriales() {
        return historialClinicoRepository.findAllByDeletedFalse().stream()
                .map(HistorialClinicoDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public HistorialClinicoDto obtenerHistorial(Long id) {
        List<ControlVacunaDto> vacunas = getVacunas(id);
        List<AtencionDto> atenciones = atencionRepository.
                findAllByDeletedFalseAndIdHistorial_IdOrderByFechaAsc(id).stream()
                .map(AtencionDto::toDto)
                .toList();
        return HistorialClinicoDto.toDto2(getHistorialClinico(id), vacunas,
                atenciones);
    }

    private List<ControlVacunaDto> getVacunas(Long id) {
        List<ControlVacunaDto> vacunas = controlVacunaRepository
                .findAllByIdHistorial_IdOrderByFechaColocadaAsc(id).stream()
                .map(ControlVacunaDto::toDto)
                .toList();

        actalizarListaConNombre(vacunas);
        return vacunas;
    }

    private void actalizarListaConNombre(List<ControlVacunaDto> vacunas) {
        for (ControlVacunaDto vacunaDto : vacunas) {
            Optional<Producto> o = productoRepository
                    .findByIdAndDeletedFalse(vacunaDto.getIdVacuna());
            String nombreVacuna = o.orElseThrow().getNombre();
            vacunaDto.setNombre(nombreVacuna);
        }
    }

    private HistorialClinico getHistorialClinico(Long id) {
        return historialClinicoRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Historial No Disponible"
                ));
    }

    @Override
    @Transactional
    public void registrarHistorial(HistorialClinico historialNuevo) {
        HistorialClinico historialClinico = historialClinicoRepository.save(historialNuevo);
    }

    @Override
    @Transactional
    public void actualizarHistorial(Long id, HistorialClinico historialNuevo) {
        HistorialClinico historialActual = getHistorialClinico(id);

        if (!historialActual.getId().equals(historialNuevo.getId()))
            throw new IllegalArgumentException("Historiales Clinicos" +
                    " distintos");

        actualizarDatos(historialActual, historialNuevo);
        historialClinicoRepository.save(historialActual);
    }

    private void actualizarDatos(HistorialClinico historialActual,
                                 HistorialClinico historialNuevo) {
        historialActual.setPeso(historialNuevo.getPeso());
        historialActual.setFc(historialNuevo.getFc());
        historialActual.setEstadoFc(historialNuevo.getEstadoFc());
        historialActual.setFr(historialNuevo.getFr());
        historialActual.setEstadoFr(historialNuevo.getEstadoFr());
        historialActual.setMucosa(historialNuevo.getMucosa());
        historialActual.setApetito(historialNuevo.getApetito());
        historialActual.setHidratacion(historialNuevo.getHidratacion());
        historialActual.setEstadoGeneral(historialNuevo.getEstadoGeneral());
    }

    @Override
    @Transactional
    public void eliminarHistorial(Long id) {
        HistorialClinico historialClinico = getHistorialClinico(id);
        historialClinico.setDeleted(true);
        historialClinicoRepository.save(historialClinico);
    }
}

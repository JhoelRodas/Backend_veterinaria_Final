package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.*;
import bo.com.jvargas.veterinaria.datos.model.dto.ControlVacunaDto;
import bo.com.jvargas.veterinaria.datos.model.sistema.enums.TipoProceso;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ControlVacunaRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.HistorialClinicoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.VacunaRepository;
import bo.com.jvargas.veterinaria.negocio.admusuarios.BitacoraService;
import bo.com.jvargas.veterinaria.negocio.ventas.ControlVacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("ControlVacunaService")
public class ControlVacunaServiceImpl implements ControlVacunaService {

    private final ControlVacunaRepository controlVacunaRepository;
    private final ProductoRepository productoRepository;
    private final VacunaRepository vacunaRepository;
    private final HistorialClinicoRepository historialClinicoRepository;
    private final BitacoraService bitacoraService;

    @Override
    @Transactional
    public void insertarVacuna(ControlVacunaDto nuevaVacuna) {
        Vacuna vacuna = obtenerVacuna(nuevaVacuna.getIdVacuna());
        HistorialClinico historial = obtenerHistorial(nuevaVacuna.getIdHistorial());
        ControlVacuna controlVacuna = ajustarControl(vacuna, historial,
                nuevaVacuna);
        ControlVacuna control = controlVacunaRepository.save(controlVacuna);

        bitacoraService.info(TipoProceso.GESTIONAR_CONTROL_VACUNA, "Control De Vacuna Registrado: {}", control.getId());
    }

    private Vacuna obtenerVacuna(Long idVacuna) {
        Producto producto = productoRepository.findByIdAndDeletedFalse(idVacuna)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el producto con el ID " + idVacuna
                ));

        producto.setStock((short) (producto.getStock() - 1));
        productoRepository.save(producto);
        return vacunaRepository.findByIdAndDeletedFalse(idVacuna).orElseThrow(
                () -> new IllegalArgumentException(
                        "No existe el producto con el ID " + idVacuna
                )
        );
    }

    private HistorialClinico obtenerHistorial(Long idHistorial) {
        return historialClinicoRepository.findByIdAndDeletedFalse(idHistorial)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el historial con el ID " + idHistorial
                ));
    }

    private ControlVacuna ajustarControl(
            Vacuna vacuna, HistorialClinico historial,
            ControlVacunaDto nuevaVacuna) {
        ControlVacuna controlVacuna = new ControlVacuna();
        controlVacuna.setIdVacuna(vacuna);
        controlVacuna.setIdHistorial(historial);
//        controlVacuna.setFechaColocada(LocalDate.now());
        controlVacuna.setFechaColocada(nuevaVacuna.getFechaColocada());
        controlVacuna.setDescripcion(nuevaVacuna.getDescripcion());
        controlVacuna.setProximaDosis(nuevaVacuna.getProximaDosis());

        return controlVacuna;
    }

    @Override
    @Transactional
    public void actualizarVacuna(Long idControl,
                                 ControlVacunaDto nuevoControl) {
        ControlVacuna controlVacuna = getControlVacuna(idControl);
        // 1. Obtener el registro de la vacuna aplicada
        Producto vacunaAplicada = getProducto(controlVacuna.getIdVacuna().getId());

        // 2. Verificar si la vacuna nueva es la misma que la original
        if (vacunaAplicada.getId().equals(nuevoControl.getIdVacuna())) {
            // Si la vacuna es la misma, solo actualiza las fechas
//            ControlVacuna controlVacuna = controlVacunaRepository.findById(idVacuna)
//                    .orElseThrow(() -> new RuntimeException("Nueva vacuna no encontrada"));
            controlVacuna.setFechaColocada(nuevoControl.getFechaColocada());
            controlVacuna.setProximaDosis(nuevoControl.getProximaDosis());
            controlVacuna.setDescripcion(nuevoControl.getDescripcion());
            controlVacunaRepository.save(controlVacuna);

            bitacoraService.info(TipoProceso.GESTIONAR_CONTROL_VACUNA, "Control De Vacuna Actualizado: {}", controlVacuna.getId());
            return;
        }

        // 3. Restaurar el stock de la vacuna original
        Producto vacunaOriginal = getProducto(controlVacuna.getIdVacuna().getId());
        vacunaOriginal.setStock((short) (vacunaOriginal.getStock() + 1));
        productoRepository.save(vacunaOriginal);

        // 4. Obtener la nueva vacuna
        Producto nuevaVacuna = getProducto(nuevoControl.getIdVacuna());

        // 5. Reducir el stock de la nueva vacuna
        if (nuevaVacuna.getStock() > 0) {
            nuevaVacuna.setStock((short) (nuevaVacuna.getStock() - 1));
            productoRepository.save(nuevaVacuna);
        } else {
            throw new RuntimeException("No hay suficiente stock para la nueva vacuna");
        }

        // 6. Actualizar el registro en el historial clínico
        Vacuna nuevaVacuna2 = vacunaRepository.findByIdAndDeletedFalse(nuevoControl.getIdVacuna())
                        .orElseThrow(() -> new IllegalArgumentException(
                                "Registro de vacuna aplicada no encontrado"
                        ));
        controlVacuna.setIdVacuna(nuevaVacuna2);
        controlVacuna.setFechaColocada(nuevoControl.getFechaColocada());
        controlVacuna.setProximaDosis(nuevoControl.getProximaDosis());
        controlVacuna.setDescripcion(nuevoControl.getDescripcion());
        controlVacunaRepository.save(controlVacuna);

        bitacoraService.info(TipoProceso.GESTIONAR_CONTROL_VACUNA, "Control De Vacuna Actualizado: {}", controlVacuna.getId());
    }

    private ControlVacuna getControlVacuna(Long id) {
        return controlVacunaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "No existe un control de vacuna con el ID " + id
                )
        );
    }

    private Producto getProducto(Long id) {
        return productoRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "Producto con ID " + id + " no encontrado"
                )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlVacunaDto> obtenerControlVacunasPorHistorial(Long idHistorial) {
        // Obtenemos la lista de ControlVacuna asociada al idHistorial
        List<ControlVacunaDto> controlVacunas = controlVacunaRepository
                .findAllByIdHistorial_IdOrderByFechaColocadaAsc(idHistorial)
                .stream().map(ControlVacunaDto::toDto).toList();

        // Convertimos cada ControlVacuna en un ControlVacunaDto
        actalizarListaConNombre(controlVacunas);
        return controlVacunas;
    }

    private void actalizarListaConNombre(List<ControlVacunaDto> vacunas) {
        for (ControlVacunaDto vacunaDto : vacunas) {
            Optional<Producto> o = productoRepository
                    .findByIdAndDeletedFalse(vacunaDto.getIdVacuna());
            String nombreVacuna = o.orElseThrow().getNombre();
            vacunaDto.setNombre(nombreVacuna);
        }
    }
}

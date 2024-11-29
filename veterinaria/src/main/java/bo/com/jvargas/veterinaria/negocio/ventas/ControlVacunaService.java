package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.ControlVacunaDto;

import java.util.List;

/**
 * @author GERSON
 */

public interface ControlVacunaService {
    void insertarVacuna(ControlVacunaDto nuevaVacuna);
    void actualizarVacuna(Long idVacuna,
                          ControlVacunaDto nuevaVacuna);
    List<ControlVacunaDto> obtenerControlVacunasPorHistorial(Long idHistorial);
}

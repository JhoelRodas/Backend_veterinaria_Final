package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.ControlVacunaDto;

/**
 * @author GERSON
 */

public interface ControlVacunaService {
    void insertarVacuna(ControlVacunaDto nuevaVacuna);
    void actualizarVacuna(Long id, ControlVacunaDto nuevaVacuna);
    void eliminarVacuna(Long id);
}

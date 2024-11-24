package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.VacunaDto;

import java.util.List;

/**
 * @author GERSON
 */

public interface VacunaService {
    List<VacunaDto> listar();

    void actualizar(Long id, VacunaDto vacunaNueva);
}

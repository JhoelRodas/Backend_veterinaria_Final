package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.ControlVacuna;
import bo.com.jvargas.veterinaria.datos.model.ControlVacunaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

public interface ControlVacunaRepository
        extends JpaRepository<ControlVacuna, ControlVacunaId> {
    List<ControlVacuna> findAllByIdHistorial_IdOrderByFechaColocadaAsc(Long id);
}

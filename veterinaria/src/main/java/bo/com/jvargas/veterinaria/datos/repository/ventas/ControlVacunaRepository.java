package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.ControlVacuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author GERSON
 */

public interface ControlVacunaRepository
        extends JpaRepository<ControlVacuna, Long> {
    List<ControlVacuna> findAllByIdHistorial_IdOrderByFechaColocadaAsc(Long id);
}

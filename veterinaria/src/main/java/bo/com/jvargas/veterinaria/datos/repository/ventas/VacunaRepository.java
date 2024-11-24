package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

public interface VacunaRepository extends JpaRepository<Vacuna, Long> {
    List<Vacuna> findAllByDeletedFalse();

    Optional<Vacuna> findByIdAndDeletedFalse(Long id);
}

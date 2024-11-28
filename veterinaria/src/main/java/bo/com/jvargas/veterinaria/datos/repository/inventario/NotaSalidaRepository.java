package bo.com.jvargas.veterinaria.datos.repository.inventario;

import bo.com.jvargas.veterinaria.datos.model.NotaSalida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

public interface NotaSalidaRepository extends JpaRepository<NotaSalida, Long> {
    List<NotaSalida> findAllByDeletedFalse();

    Optional<NotaSalida> findByIdAndDeletedFalse(Long id);
}

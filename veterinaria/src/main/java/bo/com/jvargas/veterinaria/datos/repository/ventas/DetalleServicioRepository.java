package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.DetalleServicio;
import bo.com.jvargas.veterinaria.datos.model.DetalleServicioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author GERSON
 */

public interface DetalleServicioRepository
        extends JpaRepository<DetalleServicio, DetalleServicioId> {
    List<DetalleServicio> findAllByIdRecibo_Id(Long id);
}

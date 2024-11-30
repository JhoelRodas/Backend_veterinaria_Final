package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.DetalleServicioDto;

import java.util.List;

/**
 * @author GERSON
 */

public interface DetalleServicioService {
    List<DetalleServicioDto> listar(Long idRecibo);
    void insertarDetallesServicios(List<DetalleServicioDto> nuevosDetalles);
}

package bo.com.jvargas.veterinaria.negocio.inventario;

import bo.com.jvargas.veterinaria.datos.model.dto.NotaSalidaDto;

import java.util.List;

/**
 * @author GERSON
 */

public interface NotaSalidaService {
    List<NotaSalidaDto> listar();

    void registrar(NotaSalidaDto nuevaNota);

    void editar(Long id, NotaSalidaDto nuevaNota);

    void eliminar(Long id);
}

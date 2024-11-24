package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import bo.com.jvargas.veterinaria.datos.model.dto.VacunaDto;
import bo.com.jvargas.veterinaria.datos.repository.inventario.ProductoRepository;
import bo.com.jvargas.veterinaria.datos.repository.ventas.VacunaRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Service("VacunaService")
public class VacunaServiceImpl implements VacunaService {

    private final VacunaRepository vacunaRepository;
    private final ProductoRepository productoRepository;

    @Override
    public List<VacunaDto> listar() {
        List<Vacuna> vacunas = vacunaRepository.findAllByDeletedFalse();
        List<Producto> productos = productoRepository
                .findAllByDeletedFalseAndIdCategoria_NombreIgnoreCase("vacuna");

        return actualizarADto(vacunas, productos);
    }

    private List<VacunaDto> actualizarADto(
            List<Vacuna> vacunas, List<Producto> productos) {
        List<VacunaDto> vacunaDtos = new LinkedList<>();
        int i = 0;

        while (!vacunas.isEmpty()) {
            if (sonIdsIguales(vacunas.get(0), productos.get(i))) {
                VacunaDto vacunaDto = VacunaDto.toDto(vacunas.get(0),
                        productos.get(i));
                vacunaDtos.add(vacunaDto);

                vacunas.remove(0);
                productos.remove(i);
                i = 0;
            }
            i++;
        }

        return vacunaDtos;
    }

    private boolean sonIdsIguales(Vacuna vacuna, Producto producto) {
        Long idVacuna = vacuna.getId();
        Long idProducto = producto.getId();
        return idVacuna.equals(idProducto);
    }

    @Override
    public void actualizar(Long id, VacunaDto vacunaNueva) {
        Vacuna vacunaBuscada = getVacuna(id);

        vacunaBuscada.setDescripcion(vacunaNueva.getDescripcion());
        vacunaRepository.save(vacunaBuscada);
    }

    private Vacuna getVacuna(Long id) {
        return vacunaRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new IllegalArgumentException("No existe la vacuna con " +
                        "ID " + id)
        );
    }
}

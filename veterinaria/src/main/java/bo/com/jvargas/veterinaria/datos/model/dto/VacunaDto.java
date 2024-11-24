package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.Producto;
import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import lombok.*;

/**
 * @author GERSON
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacunaDto {
    private Long id;
    private String nombre;
    private Short stock;
    private String descripcion;

    public static VacunaDto toDto(Vacuna vacuna, Producto producto) {
        return VacunaDto.builder()
                .id(vacuna.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .descripcion(vacuna.getDescripcion())
                .build();
    }
}

package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.ControlVacuna;
import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import lombok.*;

import java.time.LocalDate;

/**
 * @author GERSON
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControlVacunaDto {
    private Long idVacuna;
    private Long idHistorial;
    private String nombre;
    private String descripcion;
    private LocalDate fechaColocada;
    private LocalDate proximaDosis;

    public static ControlVacunaDto toDto(ControlVacuna controlVacuna) {
        return ControlVacunaDto.builder()
                .idVacuna(controlVacuna.getId().getIdVacuna())
                .descripcion(controlVacuna.getDescripcion())
                .fechaColocada(controlVacuna.getFechaColocada())
                .proximaDosis(controlVacuna.getProximaDosis())
                .build();
    }
}

package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.ControlVacuna;
import bo.com.jvargas.veterinaria.datos.model.Vacuna;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    private Long idVacuna;
    private Long idHistorial;
    private String nombre;
    private String descripcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaColocada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate proximaDosis;

    public static ControlVacunaDto toDto(ControlVacuna controlVacuna) {
        return ControlVacunaDto.builder()
                .id(controlVacuna.getId())
                .idVacuna(controlVacuna.getIdVacuna().getId())
                .idHistorial(controlVacuna.getIdHistorial().getId())
                .descripcion(controlVacuna.getDescripcion())
                .fechaColocada(controlVacuna.getFechaColocada())
                .proximaDosis(controlVacuna.getProximaDosis())
                .build();
    }
}

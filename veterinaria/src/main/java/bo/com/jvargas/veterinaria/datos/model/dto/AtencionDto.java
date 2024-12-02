package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.Atencion;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author GERSON
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtencionDto {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private String anamnesis;
    private String descripcion;
    private Long idMascota;
    private Long idUsuario;
    private String cliente;
    private String mascota;
    private String usuario;


    public static AtencionDto toDto(Atencion atencion) {
        return AtencionDto.builder()
                .id(atencion.getId())
                .fecha(atencion.getFecha())
                .hora(atencion.getHora())
                .anamnesis(atencion.getAnamnesis())
                .descripcion(atencion.getDescripcion())
                .cliente(atencion.getIdMascota().getCiCliente().getNombre())
                .mascota(atencion.getIdMascota().getNombre())
                .usuario(atencion.getIdUsuario().getName())
                .idMascota(atencion.getIdMascota().getId())
                .idUsuario(atencion.getIdUsuario().getId())
                .build();
    }

    public static Atencion toEntity(AtencionDto atencionDto) {
        return Atencion.builder()
                .id(atencionDto.getId())
                .fecha(atencionDto.getFecha())
                .hora(atencionDto.getHora())
                .anamnesis(atencionDto.getAnamnesis())
                .descripcion(atencionDto.getDescripcion())
                .idMascota(null)
                .idHistorial(null)
                .idUsuario(null)
                .build();
    }
}

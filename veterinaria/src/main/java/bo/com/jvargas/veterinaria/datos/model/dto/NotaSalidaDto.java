package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.NotaSalida;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

/**
 * @author GERSON
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaSalidaDto {
    private Long id;
    private Long idProducto;
    private String nombreProducto;
    private Integer cantidad;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String motivo;

    public static NotaSalidaDto toDto(NotaSalida notaSalida) {
        return NotaSalidaDto.builder()
                .id(notaSalida.getId())
                .idProducto(notaSalida.getProducto().getId())
                .nombreProducto(notaSalida.getProducto().getNombre())
                .cantidad(notaSalida.getCantidad())
                .fecha(notaSalida.getFecha())
                .motivo(notaSalida.getMotivo())
                .build();
    }

    public static NotaSalida toEntity(NotaSalidaDto notaSalida) {
        return NotaSalida.builder()
                .id(notaSalida.getId())
                .cantidad(notaSalida.getCantidad())
                .fecha(notaSalida.getFecha())
                .motivo(notaSalida.getMotivo())
                .producto(null)
                .build();
    }
}

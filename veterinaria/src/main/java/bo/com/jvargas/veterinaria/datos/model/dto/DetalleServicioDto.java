package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.DetalleProducto;
import bo.com.jvargas.veterinaria.datos.model.DetalleServicio;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author GERSON
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleServicioDto {
    private Long idRecibo;
    private Long idServicio;
    private String nombreServicio;
    private Long cant;
    private BigDecimal monto;

    public static DetalleServicioDto toDto(DetalleServicio detalleServicio) {
        return DetalleServicioDto.builder()
                .idRecibo(detalleServicio.getIdRecibo().getId())
                .idServicio(detalleServicio.getIdServicio().getId())
                .nombreServicio(detalleServicio.getIdServicio().getNombre())
                .cant(detalleServicio.getCant())
                .monto(detalleServicio.getMonto())
                .build();

    }
}

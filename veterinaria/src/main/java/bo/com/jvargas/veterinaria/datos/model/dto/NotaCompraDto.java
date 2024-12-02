package bo.com.jvargas.veterinaria.datos.model.dto;

import bo.com.jvargas.veterinaria.datos.model.NotaCompra;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class NotaCompraDto extends ReporteDto {
    private Long id;
    private BigDecimal montoTotal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String nombreProveedor;
    private List<DetalleDto> detalle;

    public static NotaCompraDto toDto(NotaCompra notaCompra) {
        if (notaCompra == null)
            return null;

        return NotaCompraDto.builder()
                .id(notaCompra.getId())
                .montoTotal(notaCompra.getMontoTotal())
                .fecha(notaCompra.getFecha())
                .nombreProveedor(notaCompra.getIdProveedor().getNombre())
                .build();
    }

    public static NotaCompraDto toDto2(NotaCompra notaCompra, List<DetalleDto> detalle) {
        if (notaCompra == null)
            return null;

        return NotaCompraDto.builder()
                .id(notaCompra.getId())
                .montoTotal(notaCompra.getMontoTotal())
                .fecha(notaCompra.getFecha())
                .nombreProveedor(notaCompra.getIdProveedor().getNombre())
                .detalle(detalle)
                .build();
    }

    public static NotaCompra toEntity(NotaCompraDto notaCompraDto) {
        if (notaCompraDto == null)
            return null;

        return NotaCompra.builder()
                .id(notaCompraDto.getId())
                .montoTotal(notaCompraDto.getMontoTotal())
                .fecha(notaCompraDto.getFecha())
                .idProveedor(null)
                .build();
    }

    public NotaCompraDto(Long id, BigDecimal montoTotal, LocalDate fecha, String nombreProveedor) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.nombreProveedor = nombreProveedor;
    }

    @Override
    public String getValor(String property) {
        switch (property){
            case "id":
                return String.valueOf(getId());
            case "montoTotal":
                return String.valueOf(getMontoTotal());
            case "fecha":
                return String.valueOf(getFecha());
            case "nombreProveedor":
                return String.valueOf(getNombreProveedor());

            default:return "";
        }
    }
}

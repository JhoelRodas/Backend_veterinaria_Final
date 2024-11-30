package bo.com.jvargas.veterinaria.datos.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author GERSON
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "detalle_servicio")
public class DetalleServicio {
    @EmbeddedId
    private DetalleServicioId id;

    @MapsId("idRecibo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recibo", nullable = false)
    private Recibo idRecibo;

    @MapsId("idServicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio idServicio;

    @Column(name = "cant")
    private Long cant;

    @Column(name = "monto", precision = 6, scale = 2)
    private BigDecimal monto;
}

package bo.com.jvargas.veterinaria.datos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * @author GERSON
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DetalleServicioId implements java.io.Serializable{
    private static final long serialVersionUID = -7891166526364725972L;
    @Column(name = "id_recibo", nullable = false)
    private Long idRecibo;

    @Column(name = "id_servicio", nullable = false)
    private Long idServicio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleServicioId that = (DetalleServicioId) o;
        return Objects.equals(idRecibo, that.idRecibo) && Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecibo, idServicio);
    }
}

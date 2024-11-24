package bo.com.jvargas.veterinaria.datos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacuna")
public class Vacuna extends AuditableEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "idVacuna", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ControlVacuna> controlVacunas = new HashSet<>();
}
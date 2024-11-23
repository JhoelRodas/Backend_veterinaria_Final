package bo.com.jvargas.veterinaria.datos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vacuna")
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @OneToMany(mappedBy = "idVacuna", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ControlVacuna> controlVacunas = new HashSet<>();

}
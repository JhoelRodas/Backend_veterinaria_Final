package bo.com.jvargas.veterinaria.datos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "control_vacuna")
public class ControlVacuna {
    @EmbeddedId
    private ControlVacunaId id;

    @MapsId("idVacuna")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vacuna", nullable = false)
    private Vacuna idVacuna;

    @MapsId("idHistorial")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialClinico idHistorial;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "fecha_colocada", nullable = false)
    private LocalDate fechaColocada;

    @Column(name = "proxima_dosis", nullable = false)
    private LocalDate proximaDosis;
}
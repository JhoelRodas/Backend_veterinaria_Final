package bo.com.jvargas.veterinaria.datos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha_colocada", nullable = false)
    private LocalDate fechaColocada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "proxima_dosis")
    private LocalDate proximaDosis;
}
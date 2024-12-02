package bo.com.jvargas.veterinaria.datos.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltroReporteDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate inicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fin;

    private BigDecimal montoMayor;
    private BigDecimal montoMenor;
    private String metodoPago;
    private String nombreProveedor;

    private List<Integer> cityList;
    private List<Long> departamentosList;
    private Date from;
    private Date to;
    private String q;
    private Long idCanalOnboarding;
    private Integer idMunicipio;
    private String nombre;
    private Long gerency;
    private Long directoraId;
    private Integer departamento;
    private Long onboardingChannel;
    private Integer city;
    private String filter;
    private Integer idMunicipios;
    private Integer gerenciaNacionalId;
    private Integer gerenciaZonalId;
    private Integer departamentoId;
    private Integer municipio;
    private String code;
    private String description;
    private String stringValue;
    private Long group;

}

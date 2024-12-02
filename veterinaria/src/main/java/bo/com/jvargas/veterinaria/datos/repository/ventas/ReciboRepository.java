package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReciboRepository extends JpaRepository<Recibo,Long> {
    Optional<Recibo> findByIdAndDeletedFalse(Long id);

    List<Recibo> findAllByDeletedFalse();

    @Query("select r " +
            "from Recibo r  " +
            "where r.fecha between :from and :to ")
    List<Recibo> listaFiltrada(@Param("from") LocalDate from,
                               @Param("to") LocalDate to);


    @Query("""
         SELECT new bo.com.jvargas.veterinaria.datos.model.dto.ReciboDto(
                r.id,
                r.fecha,
                r.montoTotal,
                r.metodoPago,
                r.idCliente.nombre,
                r.idCliente.ci
                )
        FROM Recibo r 
        WHERE
               (
                   (COALESCE(:inicio, r.fecha) <= r.fecha AND COALESCE(:fin, r.fecha) >= r.fecha)
               )
               AND
               (
                   (COALESCE(:montoMayor, r.montoTotal) <= r.montoTotal AND COALESCE(:montoMenor, r.montoTotal) >= r.montoTotal)
               )
               AND
               (
                   :metodoPago IS NULL 
                   OR :metodoPago = 'todos'
                   OR r.metodoPago = :metodoPago
               )
    """)
    List<ReciboDto> listaFiltradaReporteVentas(
            @Param("inicio")        LocalDate inicio,
            @Param("fin")           LocalDate fin,
            @Param("montoMayor")    BigDecimal montoMayor,
            @Param("montoMenor")    BigDecimal montoMenor,
            @Param("metodoPago")    String metodoPago
    );

}

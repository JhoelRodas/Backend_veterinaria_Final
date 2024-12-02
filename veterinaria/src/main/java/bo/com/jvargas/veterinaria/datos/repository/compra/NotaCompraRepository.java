package bo.com.jvargas.veterinaria.datos.repository.compra;

import bo.com.jvargas.veterinaria.datos.model.NotaCompra;
import bo.com.jvargas.veterinaria.datos.model.dto.NotaCompraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long> {
    Optional<NotaCompra> findByIdAndDeletedFalse(Long id);

    List<NotaCompra> findAllByDeletedFalse();

    @Query("""
       SELECT new bo.com.jvargas.veterinaria.datos.model.dto.NotaCompraDto(
            n.id,
            n.montoTotal,
            n.fecha,
            n.idProveedor.nombre
            )
       FROM NotaCompra n
       WHERE
           (
               (COALESCE(:inicio, n.fecha) <= n.fecha AND COALESCE(:fin, n.fecha) >= n.fecha)
           )
           AND
           (
               (COALESCE(:montoMayor, n.montoTotal) <= n.montoTotal AND COALESCE(:montoMenor, n.montoTotal) >= n.montoTotal)
           )
           AND
           (
               :nombreProveedor IS NULL
               OR :nombreProveedor = 'todos'
               OR n.idProveedor.nombre = :nombreProveedor
           )
    """)
    List<NotaCompraDto> listaFiltradaReporteCompras(
            @Param("inicio")        LocalDate inicio,
            @Param("fin")           LocalDate fin,
            @Param("montoMayor")    BigDecimal montoMayor,
            @Param("montoMenor")    BigDecimal montoMenor,
            @Param("nombreProveedor")     String nombreProveedor
    );

}

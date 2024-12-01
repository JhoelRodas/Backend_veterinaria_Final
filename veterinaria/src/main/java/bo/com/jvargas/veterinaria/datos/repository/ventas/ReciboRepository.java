package bo.com.jvargas.veterinaria.datos.repository.ventas;

import bo.com.jvargas.veterinaria.datos.model.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    List<Recibo> listaFiltrada(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query(value = """
        SELECT nombre, tipo, SUM(cantidad) AS cantidad, SUM(total) AS total
        FROM (
            SELECT p.nombre AS nombre, 'Producto' AS tipo, dp.cant AS cantidad, dp.monto AS total
            FROM detalle_producto dp
            JOIN producto p ON dp.id_producto = p.id
            JOIN recibo r ON dp.id_recibo = r.id
            WHERE r.fecha BETWEEN :from AND :to
        
            UNION ALL
        
            SELECT s.nombre AS nombre, 'Servicio' AS tipo, ds.cant AS cantidad, ds.monto AS total
            FROM detalle_servicio ds
            JOIN servicio s ON ds.id_servicio = s.id
            JOIN recibo r ON ds.id_recibo = r.id
            WHERE r.fecha BETWEEN :from AND :to
        ) reporte
        GROUP BY nombre, tipo
        """, nativeQuery = true)
    List<Object[]> generarReporte(@Param("from") LocalDate from, @Param("to") LocalDate to);
}

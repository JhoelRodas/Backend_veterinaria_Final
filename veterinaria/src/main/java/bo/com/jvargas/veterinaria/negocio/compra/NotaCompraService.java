package bo.com.jvargas.veterinaria.negocio.compra;

import bo.com.jvargas.veterinaria.datos.model.dto.NotaCompraDetalleDto;
import bo.com.jvargas.veterinaria.datos.model.dto.NotaCompraDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDto;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author GERSON
 */

public interface NotaCompraService {
    List<NotaCompraDto> listar();

    byte[] generarPdfNotaCompra(Long id);

    NotaCompraDto verNotaDeCompra(Long id);

    NotaCompraDto guardar(NotaCompraDetalleDto nuevaNotaCompra);

    Optional<NotaCompraDto> actualizar(Long id,
                                       NotaCompraDto notaCompraAActualizar);

    void eliminar(Long id);

    @Transactional(readOnly = true)
    List<NotaCompraDto> listarNotasCompraReporte(LocalDate inicio, LocalDate fin, BigDecimal montoMayor,
                                         BigDecimal montoMenor, String nombreProveedor);
}

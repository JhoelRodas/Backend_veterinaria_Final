package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDetalleDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDto;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReciboService {
    List<ReciboDto> listarRecibos();

    ReciboDetalleDto verRecibo(Long id);

    @Transactional(readOnly = true)
    List<ReciboDto> listarRecibosReporte(LocalDate inicio, LocalDate fin, BigDecimal montoMayor,
                                      BigDecimal montoMenor, String metodoPago);


    void guardarRecibo(ReciboDetalleDto nuevoRecibo);

    void anularRecibo(Long id);
}

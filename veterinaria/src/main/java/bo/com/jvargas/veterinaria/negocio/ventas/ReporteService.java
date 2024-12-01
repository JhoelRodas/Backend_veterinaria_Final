package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.BodyReporteDto;
import bo.com.jvargas.veterinaria.datos.model.dto.DocumentoDto;

import javax.management.OperationsException;
import java.io.IOException;
import java.time.LocalDate;

public interface ReporteService {
    DocumentoDto descargarReporte(BodyReporteDto bodyReporteDto) throws OperationsException;

    byte[] generarReporteVentasExcel(LocalDate from, LocalDate to) throws IOException;
}

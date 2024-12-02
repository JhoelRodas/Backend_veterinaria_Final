package bo.com.jvargas.veterinaria.negocio.ventas;

import bo.com.jvargas.veterinaria.datos.model.dto.BodyReporteDto;
import bo.com.jvargas.veterinaria.datos.model.dto.DocumentoDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReportesDto;

import javax.management.OperationsException;
import java.io.IOException;

public interface ReporteService {
    DocumentoDto descargarReporte(BodyReporteDto bodyReporteDto) throws OperationsException;
  //  byte[] generarReporte(ReportesDto reporteDto) throws IOException;

    //byte[] generarReporteVentas() throws IOException;
}

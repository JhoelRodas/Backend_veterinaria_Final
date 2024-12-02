package bo.com.jvargas.veterinaria.negocio.ventas.impl;

import bo.com.jvargas.veterinaria.datos.model.NotaCompra;
import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.*;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ReciboRepository;
import bo.com.jvargas.veterinaria.negocio.compra.NotaCompraService;
import bo.com.jvargas.veterinaria.negocio.ventas.ReciboService;
import bo.com.jvargas.veterinaria.negocio.ventas.ReporteService;
import bo.com.jvargas.veterinaria.utils.OperationException;
import bo.com.jvargas.veterinaria.utils.ReporteUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.management.OperationsException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service("reporteService")
public class ReporteServiceImpl implements ReporteService {
    private final ReciboService reciboService;
    private final NotaCompraService notaCompraService;
    private final ReciboRepository reciboRepository;

    @Override
    public DocumentoDto descargarReporte(BodyReporteDto bodyReporteDto) throws OperationsException {
        FiltroReporteDto filters = bodyReporteDto.getFiltros();
        int charWith = 255;
        List<Integer> widthList = ReporteUtil.buildColumsWidth(charWith, bodyReporteDto.getHeaders());
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(bodyReporteDto.getTipoReporte());

            int rowIndex = 0;
            ReporteUtil.crearTitulo(workbook, sheet, bodyReporteDto.getTipoReporte(), rowIndex);
            rowIndex ++;

            CellStyle tituloStyle = workbook.createCellStyle();
            XSSFFont fontTitulo = ReporteUtil.crearFuente(workbook, "Arial", (short)15, true, IndexedColors.BLACK.getIndex());
            tituloStyle.setFont(fontTitulo);

            CellStyle valorStyle = workbook.createCellStyle();
            XSSFFont fontValor = ReporteUtil.crearFuente(workbook, "Arial", (short)12, false, IndexedColors.BLACK.getIndex());
            valorStyle.setFont(fontValor);

            rowIndex ++;

            List<String> headers = ReporteUtil.buildDataHeaders(bodyReporteDto.getHeaders());

            ReporteUtil.crearCabeceras(workbook, sheet, rowIndex, "Arial", (short)10, IndexedColors.WHITE.getIndex(), IndexedColors.GREY_50_PERCENT.getIndex(), true, headers, widthList);

            XSSFFont cellFont = ReporteUtil.crearFuente(workbook, "Arial", (short)10, false, IndexedColors.BLACK.getIndex());
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(cellFont);
            cellStyle.setLocked(true);

            rowIndex ++;
            insertarData(workbook,sheet,bodyReporteDto.getHeaders(),rowIndex,filters, bodyReporteDto.getTipoReporte());

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);

            return DocumentoDto.builder()
                    .nombre("Excel.xls")
                    .tipoRespaldo("application/vnd.ms-excel")
                    .base64Archivo(new String(Base64.encodeBase64(out.toByteArray()))).build();
        } catch (IOException e) {
            log.error("Error al generar reporte Excel", e);
            throw new OperationsException("Ocurrió un error inesperado al generar reporte.");
        }
    }

    private void insertarData(XSSFWorkbook workbook, Sheet sheet, List<CabeceraReporteDto> cabeceras, int rowIndex, FiltroReporteDto filters, String tipoReporte) {
        switch (tipoReporte){
            case "Ventas":
                insertarDataReporteVentas(sheet,cabeceras,filters,rowIndex);
                break;
            case "Compras":
                insertarDataReporteCompras(sheet,cabeceras,filters,rowIndex);
                break;

            default:
                throw new OperationException(String.format("Formato de reporte: '%s' no válido.", tipoReporte));
        }

    }

    private void insertarDataReporteVentas(Sheet sheet, List<CabeceraReporteDto> cabeceras, FiltroReporteDto filters, int rowIndex){
        // Extraer los filtros del objeto FiltroReporteDto
        LocalDate inicio = filters.getInicio();
        LocalDate fin = filters.getFin();
        BigDecimal montoMayor = filters.getMontoMayor();
        BigDecimal montoMenor = filters.getMontoMenor();
        String metodoPago = filters.getMetodoPago();

        List<? extends ReporteDto> dataPage = reciboService.listarRecibosReporte(
                inicio,fin,montoMayor,montoMenor,metodoPago);

        ReporteUtil.setDataCellReporte(sheet,dataPage,cabeceras,rowIndex);
    }

    private void insertarDataReporteCompras(Sheet sheet, List<CabeceraReporteDto> cabeceras, FiltroReporteDto filters, int rowIndex){
        LocalDate inicio = filters.getInicio();
        LocalDate fin = filters.getFin();
        BigDecimal montoMayor = filters.getMontoMayor();
        BigDecimal montoMenor = filters.getMontoMenor();
        String nombreProveedor = filters.getNombreProveedor();

        List<? extends ReporteDto> dataPage = notaCompraService.listarNotasCompraReporte(
                inicio,fin,montoMayor,montoMenor,nombreProveedor);

        ReporteUtil.setDataCellReporte(sheet,dataPage,cabeceras,rowIndex);
    }





}

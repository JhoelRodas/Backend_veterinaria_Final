package bo.com.jvargas.veterinaria.api.venta;


import bo.com.jvargas.veterinaria.datos.model.Recibo;
import bo.com.jvargas.veterinaria.datos.model.dto.*;
import bo.com.jvargas.veterinaria.datos.model.dto.ResponseBody;
import bo.com.jvargas.veterinaria.datos.repository.ventas.ReciboRepository;
import bo.com.jvargas.veterinaria.negocio.ventas.ReporteService;
import bo.com.jvargas.veterinaria.utils.ApiResponseException;
import bo.com.jvargas.veterinaria.utils.ApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.OperationsException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
    private final ReciboRepository reciboRepository;
     private final ReporteService reporteService;

    @PostMapping(value = "generar-excel")
    @Operation(summary = "",
            description = "",
            tags = {"reportes"},
            responses = {
                    @ApiResponse(description = "Operación satisfactorio", responseCode = "200", content = @Content(mediaType = "application/json")),
                    @ApiResponse(description = "Registro creado", responseCode = "201", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Fallo de autentificación", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "403", description = "Acceso Denegado", content = @Content(schema = @Schema(hidden = true))),
            }, security = @SecurityRequirement(name = "bearerToken"))
    public ResponseEntity<DocumentoDto> generarReporteEcel(@RequestBody BodyReporteDto bodyReporteDto) {
        try {
            FiltroReporteDto filtros = bodyReporteDto.getFiltros();
            System.out.println("Fechas recibidas en el controlador:");
            System.out.println("Fecha Inicio: " + filtros.getInicio());
            System.out.println("Fecha Fin: " + filtros.getFin());

            return ok((reporteService.descargarReporte(bodyReporteDto)));
        } catch (OperationsException e) {
            log.error("Error: Se produjo un error controlado al ejecutar el servicio, Mensaje: {}", e.getMessage());
            throw ApiResponseException.badRequest(e.getMessage());
        } catch (Exception e) {
            log.error("Error: Se produjo un error genérico al ejecutar el servicio: ", e);
            throw ApiResponseException.serverError("Error");
        }
    }


//    // Endpoint para generar el reporte
//    @PostMapping("/generar")
//    public ResponseEntity<byte[]> generarReporte(@RequestBody ReportesDto dtoReporte) {
//        // Lógica para llenar la lista de datos que se quiere exportar
//        List<Recibo> recibos = reciboRepository.findAll();
//
//        // Generar el archivo Excel usando EasyExcel
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        EasyExcel.write(outputStream, Recibo.class)
//                .sheet("Recibos")
//                .doWrite(recibos);
//
//        // Crear el archivo de respuesta como un arreglo de bytes
//        byte[] excelFile = outputStream.toByteArray();
//
//        // Establecer los headers para forzar la descarga del archivo
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_vacio.xlsx");
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
//
//        // Enviar el archivo como respuesta
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(excelFile);
//    }

}

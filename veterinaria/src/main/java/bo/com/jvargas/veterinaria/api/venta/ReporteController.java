package bo.com.jvargas.veterinaria.api.venta;


import bo.com.jvargas.veterinaria.datos.model.dto.BodyReporteDto;
import bo.com.jvargas.veterinaria.datos.model.dto.DocumentoDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ResponseBody;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.OperationsException;

import java.io.IOException;
import java.time.LocalDate;

import static org.springframework.http.ResponseEntity.ok;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
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
            return ok((reporteService.descargarReporte(bodyReporteDto)));
        } catch (OperationsException e) {
            log.error("Error: Se produjo un error controlado al ejecutar el servicio, Mensaje: {}", e.getMessage());
            throw ApiResponseException.badRequest(e.getMessage());
        } catch (Exception e) {
            log.error("Error: Se produjo un error genérico al ejecutar el servicio: ", e);
            throw ApiResponseException.serverError("Error");
        }
    }


    @GetMapping("/reportes/ventas/excel")
    public ResponseEntity<byte[]> descargarReporteVentas(
            @RequestParam("from") String from,
            @RequestParam("to") String to) throws IOException {

        LocalDate fechaInicio = LocalDate.parse(from);
        LocalDate fechaFin = LocalDate.parse(to);

        byte[] excel = reporteService.generarReporteVentasExcel(fechaInicio, fechaFin);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte-ventas.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excel);
    }
}

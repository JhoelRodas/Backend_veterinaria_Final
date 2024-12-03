package bo.com.jvargas.veterinaria.api.venta;

import bo.com.jvargas.veterinaria.datos.model.dto.HistorialClinicoDto;
import bo.com.jvargas.veterinaria.datos.model.dto.ReciboDetalleDto;
import bo.com.jvargas.veterinaria.negocio.ventas.ReciboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/recibo")
public class ReciboController {

    private final ReciboService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.listarRecibos());
    }

    @GetMapping("/getRecibo")
    public ResponseEntity<?> obtenerRecibo(@RequestParam("id") Long id) {
        try {
            ReciboDetalleDto recibo = service.verRecibo(id);
            return ResponseEntity.ok(recibo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody ReciboDetalleDto nuevoRecibo) {
        try {
            service.guardarRecibo(nuevoRecibo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> anular(@PathVariable Long id) {
        try {
            service.anularRecibo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/download-pdf")
    public ResponseEntity<Map<String, String>> downloadPDF(@RequestParam("id") Long id) {
        try {
            byte[] pdfBytes = service.generarPdfVenta(id);
            if (pdfBytes == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Collections.singletonMap("error", "Error al generar el PDF"));
            }

            // Convierte el PDF en Base64
            String pdfBase64 = Base64.getEncoder().encodeToString(pdfBytes);

            // Devuelve el PDF en una respuesta JSON
            Map<String, String> response = new HashMap<>();
            response.put("pdf", pdfBase64);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error al generar el PDF"));
        }
    }
}

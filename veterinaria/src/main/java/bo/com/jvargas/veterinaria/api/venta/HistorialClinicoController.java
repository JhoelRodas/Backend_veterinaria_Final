package bo.com.jvargas.veterinaria.api.venta;

import bo.com.jvargas.veterinaria.datos.model.HistorialClinico;
import bo.com.jvargas.veterinaria.datos.model.dto.ControlVacunaDto;
import bo.com.jvargas.veterinaria.datos.model.dto.HistorialClinicoDto;
import bo.com.jvargas.veterinaria.negocio.ventas.ControlVacunaService;
import bo.com.jvargas.veterinaria.negocio.ventas.HistorialClinicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/historial")
public class HistorialClinicoController {

    private final HistorialClinicoService service;
    private final ControlVacunaService controlVacunaService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarHistoriales());
    }

    @GetMapping("/get")
    public ResponseEntity<?> obtenerHistorial(@RequestParam("id") Long id) {
        try {
            HistorialClinicoDto hitorial = service.obtenerHistorial(id);
            return ResponseEntity.ok(hitorial);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarHistorial(
            @RequestBody HistorialClinico historialNuevo) {
        service.registrarHistorial(historialNuevo);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/control")
    public ResponseEntity<?> guardarControl(
            @RequestBody ControlVacunaDto nuevoControl) {
        try {
            controlVacunaService.insertarVacuna(nuevoControl);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarHistorial(
            @RequestParam("id") Long id,
            @RequestBody HistorialClinico historialNuevo) {
        try {
            service.actualizarHistorial(id, historialNuevo);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/control")
    public ResponseEntity<?> actualizarControl(
            @RequestParam("id") Long id,
            @RequestBody ControlVacunaDto nuevoControl) {
        try {
            controlVacunaService.actualizarVacuna(id, nuevoControl);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> elimiarHistorial(@PathVariable Long id) {
        try {
            service.eliminarHistorial(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/control/vacunas")
    public ResponseEntity<?> obtenerControlVacunasPorHistorial(
                @RequestParam("id") Long id) {
        try {
            List<ControlVacunaDto> controlVacunas =
                    controlVacunaService.obtenerControlVacunasPorHistorial(
                            id);
            return ResponseEntity.ok(controlVacunas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}

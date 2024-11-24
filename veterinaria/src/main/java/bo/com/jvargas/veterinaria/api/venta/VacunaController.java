package bo.com.jvargas.veterinaria.api.venta;

import bo.com.jvargas.veterinaria.datos.model.dto.VacunaDto;
import bo.com.jvargas.veterinaria.negocio.ventas.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/vacuna")
public class VacunaController {
    private final VacunaService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestParam("id") Long id,
                           @RequestBody VacunaDto nuevaVacuna) {
        try {
            service.actualizar(id, nuevaVacuna);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

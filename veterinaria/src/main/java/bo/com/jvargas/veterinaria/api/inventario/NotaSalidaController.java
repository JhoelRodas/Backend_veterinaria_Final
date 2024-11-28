package bo.com.jvargas.veterinaria.api.inventario;

import bo.com.jvargas.veterinaria.datos.model.dto.NotaSalidaDto;
import bo.com.jvargas.veterinaria.negocio.inventario.NotaSalidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author GERSON
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notasalida")
public class NotaSalidaController {
    private final NotaSalidaService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> registrarNota(@RequestBody NotaSalidaDto nuevaNota) {
        try {
            service.registrar(nuevaNota);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarNota(
            @RequestParam("id") Long id,
            @RequestBody NotaSalidaDto nuevo) {
        try {
            service.editar(id, nuevo);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarNota(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

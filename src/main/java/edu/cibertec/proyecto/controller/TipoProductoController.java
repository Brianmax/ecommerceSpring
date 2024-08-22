package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.entity.TipoProductoEntity;
import edu.cibertec.proyecto.service.TipoproductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoproducto")
@AllArgsConstructor
public class TipoProductoController {
    private TipoproductoService tipoproductoService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody TipoProductoEntity tipoProductoEntity) {
        TipoProductoEntity ans = tipoproductoService.crear(tipoProductoEntity);
        if (ans == null) {
            return ResponseEntity.badRequest().body("El tipo ya existe");
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(tipoproductoService.listar());
    }
}

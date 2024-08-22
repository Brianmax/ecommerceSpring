package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.entity.ProveedorEntity;
import edu.cibertec.proyecto.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@AllArgsConstructor
public class ProveedorController {
    private ProveedorService proveedorService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorEntity proveedor) {
        ProveedorEntity ans = proveedorService.crearProveedor(proveedor);
        if (ans == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProveedores(@RequestParam int page, @RequestParam int size) {
        List<ProveedorEntity> proveedores = proveedorService.listar(page, size);
        if (proveedores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProveedor(@PathVariable int id) {
        ProveedorEntity proveedor = proveedorService.buscarProveedor(id);
        if (proveedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(proveedor);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarProveedor(@RequestBody ProveedorEntity proveedor) {
        ProveedorEntity ans = proveedorService.modificarProveedor(proveedor, proveedor.getIdproveedor());
        if (ans == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable int id) {
        if (!proveedorService.eliminarProveedor(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}

package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.entity.ProductoEntity;
import edu.cibertec.proyecto.service.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
@AllArgsConstructor
public class ProductoController {
    private ProductosService productosService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoEntity producto) {
        ProductoEntity ans = productosService.crearProducto(producto);
        if (ans == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos(@RequestParam int page, @RequestParam int size) {
        List<ProductoEntity> productos = productosService.listar(page, size);
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productos);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProducto(@PathVariable int id) {
        ProductoEntity producto = productosService.buscarProducto(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        if (!productosService.eliminarProducto(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}

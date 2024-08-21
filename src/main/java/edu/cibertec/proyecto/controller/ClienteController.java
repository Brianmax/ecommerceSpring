package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.entity.ClienteEntity;
import edu.cibertec.proyecto.service.ClientesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping("/crear")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity obj) {
        ClienteEntity cliente = clientesService.crearCliente(obj);
        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes(@RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(clientesService.listar(page, size));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable("id") int id) {
        ClienteEntity cliente = clientesService.buscarCliente(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable("id") int id) {
        if (!clientesService.eliminarCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteEntity obj) {
        if (!clientesService.modificarCliente(obj)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}

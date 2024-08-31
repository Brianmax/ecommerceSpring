package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.aggregate.request.ClienteRequest;
import edu.cibertec.proyecto.entity.ClienteEntity;
import edu.cibertec.proyecto.service.ClientesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping("/crear")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteRequest obj) {
        ClienteEntity cliente = clientesService.crearCliente(obj);
        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes() {
        return ResponseEntity.ok(clientesService.listar());
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

    @PutMapping("/modificar/{idCliente}")
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteRequest obj, @PathVariable int idCliente) {
        if (!clientesService.modificarCliente(obj, idCliente)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}

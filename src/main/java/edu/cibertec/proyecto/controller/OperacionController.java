package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.aggregate.request.OperacionRequest;
import edu.cibertec.proyecto.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operacion")
public class OperacionController {
    @Autowired
    private OperacionesService operacionesService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody OperacionRequest operacionRequest) {
        return ResponseEntity.ok(operacionesService.crearOperaciones(operacionRequest));
    }
}

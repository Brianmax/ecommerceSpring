package edu.cibertec.proyecto.controller;

import edu.cibertec.proyecto.entity.VentaEntity;
import edu.cibertec.proyecto.service.VentasService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/venta")
@AllArgsConstructor
public class VentaController {
	private VentasService ventasService;

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody VentaEntity ventaEntity) {
		VentaEntity ans = ventasService.crearVenta(ventaEntity);
		if (ans == null) {
			return ResponseEntity.badRequest().body("La venta ya existe");
		}
		return ResponseEntity.ok(ans);
	}
}

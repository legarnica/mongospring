package cl.lherrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.dto.CanastaDto;
import cl.lherrera.model.Canasta;
import cl.lherrera.service.CanastaService;

@RestController
@RequestMapping("/api/v1/canasta")
public class CanastaController {

	@Autowired
	private CanastaService canastaService;

	@PutMapping
	public CanastaDto actualizar(@RequestBody Canasta canasta) {
		return canastaService.registrarActualizar(canasta);
	}

	@GetMapping
	public CanastaDto canastas() {
		return canastaService.canastas();
	}

	@PostMapping
	public CanastaDto registrar(@RequestBody Canasta canasta) {
		return canastaService.registrarActualizar(canasta);
	}

	@DeleteMapping
	public CanastaDto eliminar(@RequestBody Canasta canasta) {
		return canastaService.eliminar(canasta);
	}
}

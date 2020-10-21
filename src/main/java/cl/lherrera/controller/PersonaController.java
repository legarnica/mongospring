package cl.lherrera.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.model.Persona;
import cl.lherrera.service.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
	private Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	PersonaService service;
	
	@GetMapping("{nombre}")
	public List<Persona> filtrar(@PathVariable String nombre) {
		logger.info("nombre: {}", nombre);
		return service.encontrarPorNombre(nombre);
	}

	@GetMapping
	public List<Persona> listar() {
		return service.listarPersonas();
	}

	@PostMapping
	public Persona ingresar(@RequestBody Persona persona) {
		return service.ingresarPersona(persona);
	}
	
	@PutMapping
	public Persona actualizar(@RequestBody Persona persona) {
		return service.actualizarPersona(persona);
	}

	@DeleteMapping
	public Persona eliminar(@RequestParam String id) {
		Persona persona = service.encontrarPorId(id);

		return service.eliminarPersona(persona);
	}

}

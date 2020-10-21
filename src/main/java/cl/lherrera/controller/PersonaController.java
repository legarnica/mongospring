package cl.lherrera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.model.Persona;
import cl.lherrera.service.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

	@Autowired
	PersonaService service;
	
	@GetMapping
	public List<Persona> listar() {
		return service.listarPersonas(); 
	}
	
	@PostMapping
	public Persona ingresar(@RequestBody Persona persona) {
		service.ingresarPersona(persona);

		return service.completarPersona(persona);
	}
	
	@DeleteMapping
	public Persona eliminar(@RequestParam String id) {
		Persona persona = service.encontrarPorId(id);
		
		return service.eliminarPersona(persona);
	}
}

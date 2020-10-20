package cl.lherrera.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.model.Persona;
import cl.lherrera.service.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

	@Autowired
	PersonaService service;
	
	@GetMapping
	public List<Persona> init() {
		return service.ListarPersonas(); 
	}
	
	@PostMapping
	public Map<String, Object> ingresarPersona(@RequestBody Persona persona) {
		service.ingresarPersona(persona);
		
		
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("mensaje", "ingresado correctamente");
		mapa.put("persona", persona);

		return mapa;

	}
}

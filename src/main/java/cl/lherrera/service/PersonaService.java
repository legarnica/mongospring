package cl.lherrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lherrera.model.Persona;
import cl.lherrera.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository repo;
	
	public List<Persona> listarPersonas() {
		return repo.findAll();
	}
	
	public void ingresarPersona(Persona persona) {
		repo.save(persona);
	}
	
	public Persona completarPersona(Persona persona) {
		return repo.findByNombreAndCorreo(persona.getNombre(), persona.getCorreo());
		
	}
	
	public Persona encontrarPorId(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public Persona eliminarPersona(Persona persona) {
		repo.delete(persona);

		return persona;
	}
}


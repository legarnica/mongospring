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
	
	public List<Persona> ListarPersonas() {
		return repo.findAll();
	}
	
	public void ingresarPersona(Persona persona) {
		repo.save(persona);
	}
}

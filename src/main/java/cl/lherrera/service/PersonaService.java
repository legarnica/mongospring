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

	public Persona ingresarPersona(Persona persona) {
		return repo.save(persona);
	}

	public List<Persona> encontrarPorNombre(String nombre) {
		return repo.findByNombre(nombre);
	}
	
	public Persona encontrarPorId(String id) {
		return repo.findById(id).orElse(null);
	}

	public Persona eliminarPersona(Persona persona) {
		repo.delete(persona);

		return persona;
	}

	public Persona actualizarPersona(Persona persona) {
		return repo.save(persona);
	}

}


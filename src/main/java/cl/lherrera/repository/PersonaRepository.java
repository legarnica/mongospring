package cl.lherrera.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.lherrera.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String> {
	List<Persona> findByNombre(String nombre);
	List<Persona> findByCorreo(String correo);
	
}


package cl.lherrera.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.lherrera.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String> {

}

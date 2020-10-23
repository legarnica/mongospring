package cl.lherrera.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.lherrera.model.Canasta;

public interface CanastaRepository extends MongoRepository<Canasta, String> {
}

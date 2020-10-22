package cl.lherrera.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.lherrera.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{}

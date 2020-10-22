package cl.lherrera.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.lherrera.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String>{}

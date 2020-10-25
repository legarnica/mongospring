package cl.lherrera.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lherrera.dto.ProductoDto;
import static cl.lherrera.dto.AbstractDto.*;
import cl.lherrera.model.Producto;
import cl.lherrera.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public ProductoDto productos() {
		return new ProductoDto(OK_CODE, productoRepository.findAll(), null, null);
	}

	public ProductoDto registrarActualizar(Producto producto) {
		return new ProductoDto(SAVE_CODE, new ArrayList<>(), productoRepository.save(producto), SAVE_MSJ);
	}

	public ProductoDto eliminar(Producto producto) {
		productoRepository.delete(producto);
		return new ProductoDto(DELETE_CODE, new ArrayList<>(), producto, DELETE_MSJ);
	}

	public Producto obtener(String id) {
		return productoRepository.findById(id).orElse(null);
	}

}

package cl.lherrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.dto.ProductoDto;
import cl.lherrera.model.Producto;
import cl.lherrera.service.ProductoService;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PutMapping
	public ProductoDto actualizar(@RequestBody Producto producto) {
		return productoService.registrarActualizar(producto);
	}

	@GetMapping
	public ProductoDto canastas() {
		return productoService.productos();
	}

	@PostMapping
	public ProductoDto registrar(@RequestBody Producto producto) {
		return productoService.registrarActualizar(producto);
	}

	@DeleteMapping
	public ProductoDto eliminar(@RequestBody Producto producto) {
		return productoService.eliminar(producto);
	}
}

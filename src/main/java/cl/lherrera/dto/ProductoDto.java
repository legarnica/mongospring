package cl.lherrera.dto;

import java.util.List;

import cl.lherrera.model.Producto;

public class ProductoDto extends AbstractDto<List<Producto>, Producto>{

	private static final long serialVersionUID = 2447165275215260356L;

	public ProductoDto() {
		super();
	}

	public ProductoDto(Integer statusCode, List<Producto> data, Producto auxData, String menssaje) {
		super(statusCode, data, auxData, menssaje);
	}

}

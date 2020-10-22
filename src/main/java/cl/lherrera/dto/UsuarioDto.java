package cl.lherrera.dto;

import java.util.List;

import cl.lherrera.model.Usuario;

public class UsuarioDto extends AbstractDto<List<Usuario>, Usuario> {

	private static final long serialVersionUID = -7233909528866890611L;

	public UsuarioDto() {
		super();
	}

	public UsuarioDto(Integer statusCode, List<Usuario> data, Usuario auxData, String menssaje) {
		super(statusCode, data, auxData, menssaje);
	}
	
}

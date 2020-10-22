package cl.lherrera.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.lherrera.model.Canasta;

@Component
public class CanastaDto extends AbstractDto<List<Canasta>, Canasta>{
	private static final long serialVersionUID = -5938636735122491656L;

	public CanastaDto() {
		super();
	}

	public CanastaDto(Integer statusCode, List<Canasta> data, Canasta auxData, String menssaje) {
		super(statusCode, data, auxData, menssaje);
	}

}

package cl.lherrera.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import cl.lherrera.dto.CanastaDto;
import cl.lherrera.model.Canasta;
import cl.lherrera.repository.CanastaRepository;

import static cl.lherrera.dto.AbstractDto.*;

public class CanastaService {

	@Autowired
	private CanastaRepository canastaRepository;

	public CanastaDto canastas() {
		return new CanastaDto(OK_CODE, canastaRepository.findAll(), null, "");
	}

	public CanastaDto registrarActualizar(Canasta canasta) {
		return new CanastaDto(SAVE_CODE, new ArrayList<>(), canastaRepository.save(canasta), SAVE_MSJ);
	}

	public CanastaDto eliminar(Canasta canasta) {
		canastaRepository.delete(canasta);
		return new CanastaDto(DELETE_CODE, new ArrayList<>(), canasta, DELETE_MSJ);
	}

	public Canasta obtener(String id) {
		return canastaRepository.findById(id).orElse(null);
	}

}

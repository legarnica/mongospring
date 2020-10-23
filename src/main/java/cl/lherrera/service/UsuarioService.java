package cl.lherrera.service;

import static cl.lherrera.dto.AbstractDto.DELETE_CODE;
import static cl.lherrera.dto.AbstractDto.DELETE_MSJ;
import static cl.lherrera.dto.AbstractDto.OK_CODE;
import static cl.lherrera.dto.AbstractDto.SAVE_CODE;
import static cl.lherrera.dto.AbstractDto.SAVE_MSJ;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lherrera.dto.UsuarioDto;
import cl.lherrera.model.Usuario;
import cl.lherrera.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDto usuarios() {
		return new UsuarioDto(OK_CODE, usuarioRepository.findAll(), null, "");
	}

	public UsuarioDto registrarActualizar(Usuario usuario) {
		return new UsuarioDto(SAVE_CODE, new ArrayList<>(), usuarioRepository.save(usuario), SAVE_MSJ);
	}

	public UsuarioDto eliminar(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return new UsuarioDto(DELETE_CODE, new ArrayList<>(), usuario, DELETE_MSJ);
	}

	public Usuario obtener(String id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}

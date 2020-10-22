package cl.lherrera.service;

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
		return new UsuarioDto(200, usuarioRepository.findAll(), null, "");
	}

	public UsuarioDto registrarActualizar(Usuario usuario) {
		return new UsuarioDto(201, new ArrayList<>(), usuarioRepository.save(usuario), "");
	}

	public UsuarioDto eliminar(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return new UsuarioDto(202, new ArrayList<>(), usuario, "");
	}

	public Usuario obtener(String id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}

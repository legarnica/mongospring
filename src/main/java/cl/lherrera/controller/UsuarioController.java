package cl.lherrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.lherrera.dto.UsuarioDto;
import cl.lherrera.model.Usuario;
import cl.lherrera.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PutMapping
	public UsuarioDto actualizar(@RequestBody Usuario usuario) {
		return usuarioService.registrarActualizar(usuario);
	}

	@GetMapping
	public UsuarioDto usuarios() {
		return usuarioService.usuarios();
	}

	@PostMapping
	public UsuarioDto registrar(@RequestBody Usuario usuario) {
		return usuarioService.registrarActualizar(usuario);
	}

	@DeleteMapping
	public UsuarioDto eliminar(@RequestBody Usuario usuario) {
		return usuarioService.eliminar(usuario);
	}
}

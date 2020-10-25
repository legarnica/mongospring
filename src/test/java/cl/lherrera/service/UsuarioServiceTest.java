package cl.lherrera.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import cl.lherrera.model.Usuario;
import cl.lherrera.repository.UsuarioRepository;

@SpringBootTest
class UsuarioServiceTest {
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Usuario usuario;
	
	@Mock UsuarioRepository repository;
	@InjectMocks UsuarioService servicio;
	
	@Test
	@DisplayName("Listar usuarios")
	void listar() {
		when(repository.findAll()).thenReturn(usuarios);
		List<Usuario> laListaDelServicio = servicio.usuarios().getData();
		verify(repository, times(1)).findAll();
		
		assertThat(laListaDelServicio, is(usuarios));
	}
	
	@Test
	@DisplayName("Ingresa o actualiza usuario")
	void ingresarOActualizar() {
		when(repository.save(usuario)).thenReturn(usuario);
		Usuario laEntidad = servicio.registrarActualizar(usuario).getAuxData(); 
		verify(repository, times(1)).save(usuario);
		
		assertThat(laEntidad, is(usuario));
	}
	
	@Test
	@DisplayName("Elimina un usuario")
	void eliminar() {
		servicio.eliminar(usuario);
		// verifica que repo.delete se ha ejecutado 1 vez.
		verify(repository, times(1)).delete(usuario);
	}
	
	@BeforeAll
	static void inicia() {
		Faker faker = new Faker(new Locale("es-ES"));
		
		for (int i = 0; i < 3; i++)
			usuarios.add(
				new Usuario(
					Integer.toString(i),
					faker.name().fullName(),
					faker.name().username(),
					faker.internet().password()
				)
			);
		
		usuario = usuarios.get(0);
	}
	
	
	
	
}

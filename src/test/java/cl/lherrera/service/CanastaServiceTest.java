package cl.lherrera.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import cl.lherrera.dto.CanastaDto;
import cl.lherrera.model.Canasta;

import static cl.lherrera.dto.AbstractDto.OK_CODE;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootTest
class CanastaServiceTest {

	private static CanastaService service;
	private static CanastaDto canastaDto;
	private static Canasta canasta;
	private static Faker faker = new Faker(new Locale("es-ES"));
	
	private static CanastaDto creaUnDtoCanasta() {
		List<Canasta> canastas = new ArrayList<>();
		canastas.add(new Canasta(
			faker.idNumber().ssnValid(), 
			faker.hipster().word(), 
			faker.number().digits(3), 
			faker.lorem().paragraph(),
			faker.avatar().image(), 
			null)
		);
		return new CanastaDto(OK_CODE, canastas, null, "");
	}
	
	private static Canasta canastaFactory() {
		return canastaDto.getData().get(0);
	}

	@BeforeAll
	static void inicio() {
		service = mock(CanastaService.class);
		canastaDto = creaUnDtoCanasta();
		canasta = canastaFactory();
		
	}
	
	@Test
	@DisplayName("registra una canasta")
	void eliminar() {
		when(service.registrarActualizar(canasta)).thenReturn(canastaDto);
		assertThat(service.registrarActualizar(canasta), is(canastaDto));
	}

	@Test
	@DisplayName("elimina una canastas")
	void registrar() {
		when(service.eliminar(canasta)).thenReturn(canastaDto);
		assertThat(service.eliminar(canasta), is(canastaDto));
	}

	@Test
	@DisplayName("obtener las canastas")
	void canastas() {
		when(service.canastas()).thenReturn(canastaDto);
		assertThat(service.canastas().getData().size(), is(1));

	}
}

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
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import cl.lherrera.model.Producto;
import cl.lherrera.repository.ProductoRepository;

@SpringBootTest
class ProductoServiceTest {

	private static Faker faker = new Faker(new Locale("es-ES"));
	private static Producto producto;
	private static List<Producto> productos = new ArrayList<>();
	
	@Mock
	private static ProductoRepository repository;
	
	@InjectMocks
	private static ProductoService servicio;

	@BeforeAll
	public static void inicio() {
		
		for (int i = 0; i < 3; i++)
			productos.add(
				new Producto(
					faker.idNumber().invalid(), 
					faker.name().name(), 
					faker.food().ingredient(),
					faker.number().digits(4), 
					faker.avatar().image(), 
					null));
			
		System.out.println(productos);

		producto = productos.get(0);
	}
	
	
	@Test
	@DisplayName("Obtener productos")
	void productos() {
		when(repository.findAll()).thenReturn(productos);
		assertThat(servicio.productos().getData(), is(productos));
	}
	
	/**
	 * como no puedo realmente eliminar un producto de la cadena
	 * a menos que aplique la lógica con mock() lo que
	 * no tiene sentido ya que estaríamos replicando
	 * la lógica, se consulta por las veces que
	 * accedimos al método que usa el servicio.
	 */
	@Test
	@DisplayName("Eliminar un producto")
	void eliminar() {
	    servicio.eliminar(producto);
	    verify(repository, times(1)).delete(producto);
	}
	
	/**
	 * Indicamos que el repositorio retorna el producto de prueba
	 * luego verificamos que el servicio llena el  atributo 
	 * getAuxData del objeto productoDto, finalmente
	 * comprobamos que el save, se haya llamado
	 * solamente una vez.
	 */
	@Test
	@DisplayName("Ingresa o actualiza un producto")
	void ingresar() {
	    when(repository.save(producto)).thenReturn(producto);
	    assertThat(servicio.registrarActualizar(producto).getAuxData(), is(producto));
	    Mockito.verify(repository, times(1)).save(producto);
	}
	
}

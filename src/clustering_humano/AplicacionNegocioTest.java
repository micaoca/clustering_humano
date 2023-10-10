package clustering_humano;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AplicacionNegocioTest {
	
	private static AplicacionNegocio app;
	private static Grafo grafo;
	
	@BeforeClass
	public static void setup() {
		app = new AplicacionNegocio();
		grafo = new Grafo(3);
		app.agregarPersona("Pepe", 1, 2, 3, 4);
		app.agregarPersona("Pipo", 5, 4, 3, 2);
		app.agregarPersona("Juan", 4, 2, 1, 5);
		app.agregarPersona("Miguel", 2, 4, 5, 3);

		app.setGrafo(grafo);
	}
	
	@Test
	public void indiceSimilaridadCorrectoTest() {
		assertTrue(app.indiceSimilaridad(3, 1) == 6);
	}
	
	@Test
	public void indiceSimilaridadIncorrectoTest() {
		assertFalse(app.indiceSimilaridad(2, 1) == 7);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void indiceSimilaridadInvalidoTest() {
		app.indiceSimilaridad(4, 1);
	}
	
}

package clustering_humano;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {

	@Test
	public void pesoAristaFilaColumna() {
		
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 2, 4);
		assertEquals(4,grafo.consultarPesoArista(1, 2));		
	}
	@Test
	public void pesoAristaColumnaFila() {
		
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 1, 4);
		assertEquals(4,grafo.consultarPesoArista(2, 1));		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void f() {
		
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 1, 4);
		assertEquals(4,grafo.consultarPesoArista(-2, 1));		
	}

}

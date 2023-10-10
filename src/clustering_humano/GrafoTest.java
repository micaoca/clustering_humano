package clustering_humano;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5); // Crear un grafo con 5 vértices
    }

    @Test
    public void agregarArcoValidoTest() {
    	Arco arcoEsperado = new Arco(0, 1, 5);
    	int[][] matrizAdyacencia = grafo.getMatrizAdyacencia();
    	
        grafo.agregarArco(0, 1, 5);
        
        assertEquals(5, matrizAdyacencia[0][1]);
        assertEquals(5, matrizAdyacencia[1][0]);
        assertTrue(grafo.getArcos().get(0).equals(arcoEsperado));
        assertEquals(grafo.getArcos().get(0), arcoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarArcoInvalidoTest() {
    	grafo.agregarArco(-1, 2, 5);
    }

    @Test
    public void mayorPesoTest() throws Exception {
        grafo.agregarArco(0, 1, 5);
        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(2, 3, 8);

        Arco arcoMayorPeso = Grafo.mayorPeso(grafo.getArcos());
        
        assertEquals(10, arcoMayorPeso.getPeso());
    }

    @Test(expected = NullPointerException.class)
    public void mayorPesoNullTest() throws Exception {
        Grafo.mayorPeso(grafo.getArcos());
    }
}
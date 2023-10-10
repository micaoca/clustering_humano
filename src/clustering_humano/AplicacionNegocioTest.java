package clustering_humano;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AplicacionNegocioTest {

	private static AplicacionNegocio app;
	private static Grafo grafo;

	@Before
	public void setup() throws Exception{
		app = new AplicacionNegocio();
		grafo = new Grafo(4);
		app.agregarPersona("Pepe", 1, 2, 3, 4);
		app.agregarPersona("Pipo", 5, 4, 3, 2);
		app.agregarPersona("Juan", 4, 2, 1, 5);
		app.agregarPersona("Miguel", 2, 4, 5, 3);

		app.setGrafo(grafo);
	}

	@Test
	public void agregarPersonaValidaTest() throws Exception {
		app.agregarPersona("Roberto", 1, 5, 3, 4);

		Persona personaAgg = app.getPersonas().get(4);
		assertTrue(personaAgg.getNombre() == "Roberto");
		assertTrue(personaAgg.getD() == 1);
		assertTrue(personaAgg.getM() == 5);
		assertTrue(personaAgg.getE() == 3);
		assertTrue(personaAgg.getC() == 4);
	}

	@Test(expected = Exception.class)
	public void agregarPersonaInvalidaTest() throws Exception {
		app.agregarPersona("Martin", 6, 5, 3, 4);

		app.getPersonas().get(4);
	}

	@Test
	public void armarGruposTest() {
		Set<String> grupo1Esperado = new HashSet<>();
		Set<String> grupo2Esperado = new HashSet<>();
		List<Arco> aristasAGM = new ArrayList<>();
		aristasAGM.add(new Arco(0, 3, 6));
		aristasAGM.add(new Arco(1, 3, 6));
		Arco arcoMayorPesoEsperada = new Arco(0, 2, 6);
		grupo1Esperado.add("Pepe");
		grupo1Esperado.add("Pipo");
		grupo1Esperado.add("Miguel");
		grupo2Esperado.add("Juan");
		
		app.armarGrupos(aristasAGM, arcoMayorPesoEsperada);
		
		assertTrue(Arrays.asList(app.nombresGrupo1()).containsAll(grupo1Esperado));
		assertTrue(Arrays.asList(app.nombresGrupo2()).containsAll(grupo2Esperado));
	}
	
	@Test
	public void eliminarArcoMayorPesoTest() throws Exception {
		Arco aristaEliminadaEsperada = new Arco(0, 2, 6);
		List<Arco> aristasAGM = cargarArcosAGM(aristaEliminadaEsperada);
		
		app.eliminarArcoMayorPeso(aristasAGM);
		
		assertFalse(aristasAGM.contains(aristaEliminadaEsperada));
	}

	@Test
	public void agregarArcosTest() {
		List<Arco> arcosEsperados = cargarArcos();
		int[][] matrizAdyacenciaEsperada = cargarMatrizEsperada();

		app.agregarArcos();

		int[][] matrizReal = app.getGrafo().getMatrizAdyacencia();

		assertTrue(sonMatricesIguales(matrizReal, matrizAdyacenciaEsperada));
		assertTrue(app.getGrafo().getArcos().equals(arcosEsperados));
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

	public static boolean sonMatricesIguales(int[][] matriz1, int[][] matriz2) {
		if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
			return false;
		}

		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				if (matriz1[i][j] != matriz2[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	private static int[][] cargarMatrizEsperada() {
		return new int[][] { { 0, 8, 6, 6 }, { 8, 0, 8, 6 }, { 6, 8, 0, 10 }, { 6, 6, 10, 0 } };
	}

	private static ArrayList<Arco> cargarArcos() {
		ArrayList<Arco> arcos = new ArrayList<>();
		arcos.add(new Arco(0, 1, 8));
		arcos.add(new Arco(0, 2, 6));
		arcos.add(new Arco(0, 3, 6));
		arcos.add(new Arco(1, 2, 8));
		arcos.add(new Arco(1, 3, 6));
		arcos.add(new Arco(2, 3, 10));
		return arcos;
	}
	
	private static ArrayList<Arco> cargarArcosAGM(Arco aristaEliminadaEsperada) {
		ArrayList<Arco> arcosAGM = new ArrayList<>();
		arcosAGM.add(aristaEliminadaEsperada);
		arcosAGM.add(new Arco(0, 3, 6));
		arcosAGM.add(new Arco(1, 3, 6));
		return arcosAGM;
	}

}

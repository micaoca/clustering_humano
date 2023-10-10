package clustering_humano;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArbolGeneradorMinimoTest {
	
	private static ArbolGeneradorMinimo agm;
	private static int[][] matrizAdyacencia;
	
	
	@Before
	public void setUp() {
		
		matrizAdyacencia = new int [][] { { 0, 8, 6, 6 }, { 8, 0, 8, 6 }, { 6, 8, 0, 10 }, { 6, 6, 10, 0 } };		
		agm = new ArbolGeneradorMinimo(matrizAdyacencia);


		}
	
	@Test
	public void iniciarPadresTest() {
		
		List<Integer> padresEsperados = new ArrayList<>();
		padresEsperados.add(0);
		padresEsperados.add(1);
		padresEsperados.add(2);
		padresEsperados.add(3);
		
		agm.iniciarPadres();
		
		
		
		assertTrue(Arrays.stream(agm.getPadres()).boxed().toList().equals(padresEsperados));

	}
	
	@Test
	public void armarArcosTest() {

		agm.armarArcos(matrizAdyacencia);
		int arcosEsperados = 12;
		
		assertEquals(arcosEsperados, agm.getArcos().size());
	}
	
	@Test
	public void ordenarArcosTest() {
		agm.armarArcos(matrizAdyacencia);
		agm.ordenarArcos();
		
		ArrayList<Arco> arcos = agm.getArcos();
		
		for (int i = 0; i < arcos.size()-1; i++) {
			assertTrue(arcos.get(i).getPeso() <= arcos.get(i).getPeso());	
		}
				
	}
	
	
}

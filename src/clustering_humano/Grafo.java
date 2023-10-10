package clustering_humano;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private int[][] matrizAdyacencia;
	private List<Arco> arcos;
	
	public Grafo(int vertices) {
		
		matrizAdyacencia = new int[vertices][vertices];
		arcos = new ArrayList<>();
				
	}

	public void agregarArista(int fila, int columna, int peso) { //throws exception
		
		if(!validar(fila, columna)) {
			throw new IllegalArgumentException("Alguno de los datos es incorrecto.");
		}
		
		matrizAdyacencia[fila][columna] = peso;
		matrizAdyacencia[columna][fila] = peso;
		arcos.add(new Arco(fila, columna, peso));
	}
	
	private boolean validar(int fila, int columna) { //throws exception
		return ( fila > 0 || columna > 0 ) && ( fila < matrizAdyacencia.length || columna < matrizAdyacencia.length); 
	}
	
	public static Arco mayorPeso(List<Arco> aristasAGM) {
	    Arco arcoMayorPeso = aristasAGM.get(0);

	    for (Arco arco : aristasAGM) {
	        if (arco.getPeso() > arcoMayorPeso.getPeso()) {
	        	arcoMayorPeso = arco;
	        }
	    }
	    
	    return arcoMayorPeso;
	}
    
    public int[][] getMatrizAdyacencia() { //throws exception
		return matrizAdyacencia;
	}
    
    public void setMatrizAdyacencia(int[][] matrizAdyacencia) { //throws exception
		this.matrizAdyacencia = matrizAdyacencia;
	}
		
}
package clustering_humano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Grafo {

	private int[][] matrizAdyacencia;
	private List<Arco> arcos;
	
	public Grafo(int vertices) {
		
		matrizAdyacencia = new int[vertices][vertices];
		arcos = new ArrayList<>();
				
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public void agregarArista(int fila, int columna, int peso) {
		
		if(fila < 0 || columna < 0 ) {
			throw new IllegalArgumentException("El vertice no puede ser negativo");
		}
		if(fila >= matrizAdyacencia.length || columna >= matrizAdyacencia.length) {
			throw new IllegalArgumentException("Alguno de los parametros supera el maximo permitido");
		}

		matrizAdyacencia[fila][columna] = peso;
		matrizAdyacencia[columna][fila] = peso;
		agregarArco(fila, columna, peso);
	}
	
	private void agregarArco(int o, int d, int peso) {
        arcos.add(new Arco(o, d, peso));
    }
	
	List<Arco> darAGM() {
        List<Arco> agm = new ArrayList<>();
        
        Collections.sort(arcos, Comparator.comparingInt(arco -> arco.getPeso()));

        boolean[] visitados = new boolean[matrizAdyacencia.length];

        for (Arco arco : arcos) {
            if (!visitados[arco.getO()] || !visitados[arco.getD()]) {
            	agm.add(arco);
                visitados[arco.getO()] = true;
                visitados[arco.getD()] = true;
            }
        }

        return agm;
    }

	public int consultarPesoArista(int fila, int columna) {
		
		if(fila < 0 || columna < 0 ) {
			throw new IllegalArgumentException("No existe un vertice negativo");
		}
		if(fila >= matrizAdyacencia.length || columna >= matrizAdyacencia.length) {
			throw new IllegalArgumentException("Alguno de los parametros supera el maximo permitido");
		}
			
		return matrizAdyacencia[fila][columna];	
	
	}
	
	public int obtenerCantidadAristas() {
		return matrizAdyacencia.length;
	}
	
	
	public int obtenerAristaMenorPeso() {
		
		int aristaMinima = matrizAdyacencia[0][0];
		
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                if (i != j && matrizAdyacencia[i][j] < aristaMinima) {
                	aristaMinima = matrizAdyacencia[i][j];
                }
            }
        }
		
        System.out.println("Arista de menor peso: " + aristaMinima);
		return aristaMinima;
	}
	
	public int obtenerAristaMayorPeso() {
		
		int aristaMayor = matrizAdyacencia[0][0];
		
		for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                if (i != j && matrizAdyacencia[i][j] < aristaMayor) {
                	aristaMayor = matrizAdyacencia[i][j];
                }
            }
        }
		
        System.out.println("Arista de mayor peso: " + aristaMayor);
		return aristaMayor;
	}
	
	// Funciones de prueba 
    public void imprimirMatriz() {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
    
    public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
		
}
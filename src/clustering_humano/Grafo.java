package clustering_humano;

public class Grafo {

	private int[][] A;
	
	
	public Grafo(int vertices) {
		
		A = new int[vertices][vertices];
				
	}
	
	public void agregarArista(int fila, int columna, int peso) {
		
		if(fila < 0 || columna < 0 ) {
			throw new IllegalArgumentException("El vertice no puede ser negativo");
		}
		if(fila >= A.length || columna >= A.length) {
			throw new IllegalArgumentException("Alguno de los parametros supera el maximo permitido");
		}

		A[fila][columna] = peso;
		A[columna][fila] = peso;
	}
	
	

	public int consultarPesoArista(int fila, int columna) {
		
		if(fila < 0 || columna < 0 ) {
			throw new IllegalArgumentException("No existe un vertice negativo");
		}
		if(fila >= A.length || columna >= A.length) {
			throw new IllegalArgumentException("Alguno de los parametros supera el maximo permitido");
		}
			
		return A[fila][columna];	
	
	}
	
	public int obtenerCantidadAristas() {
		return A.length;
	}
	
	
	public int obtenerAristaMenorPeso() {
		
		int aristaMinima = A[0][0];
		
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] < aristaMinima) {
                	aristaMinima = A[i][j];
                }
            }
        }
		
        System.out.println("Arista de menor peso: " + aristaMinima);
		return aristaMinima;
	}
	
	// Funciones de prueba 
    public void imprimirMatriz() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

		
}

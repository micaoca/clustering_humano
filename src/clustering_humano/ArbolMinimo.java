package clustering_humano;

import java.util.HashMap;

public class ArbolMinimo {
	
	
	private int[] verticesPintados;
	
	
	public void generarArbolMinimo(Grafo grafo) {
		
		int aristas[];
		int i = 0;
		
		while(i< grafo.obtenerCantidadAristas()) {
			

			//Busco la arista de menor peso 
			int arista = grafo.obtenerAristaMenorPeso();
			
			//Valido si uno de los vertices o ambos ya fueron agregados a verticesPintados[]
			
			//Valido que no forme un ciclo
			
			//Si cumple con estas validaciones agrego la arista
			
			//Si no cumple sigo recorriendo 
			
			
		}
		
		
	}
	
	

	

}

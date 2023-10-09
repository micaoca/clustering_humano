package clustering_humano;

import java.util.List;

public class Solver {
	
	public static List<Arco> eliminarArcoMayorPeso(List<Arco> aristasAGM) {
		
        for (Arco arco : aristasAGM) {
            if (arco.getPeso() == mayorPeso(aristasAGM)) {
            	aristasAGM.remove(arco);
                break; 
            }
        }
        
        return aristasAGM;
	}
	
	
	private static int mayorPeso(List<Arco> aristasAGM) {
	    int pesoMaximo = 0;

	    for (Arco arco : aristasAGM) {
	        if (arco.getPeso() > pesoMaximo) {
	            pesoMaximo = arco.getPeso();
	        }
	    }
	    
	    return pesoMaximo;
	    
	}

	

}

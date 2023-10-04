package clustering_humano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArbolGeneradorMinimo {
	
	
	ArbolGeneradorMinimo(){}
	
	public static List<int[]> getAGM(int[][] matrizAdyacencia, int nVertices) {
		
        List<int[]> agm = new ArrayList<>();
        List<int[]> aristas = new ArrayList<>();

        for (int i = 0; i < nVertices; i++) {
            for (int j = i + 1; j < nVertices; j++) {
                int peso = matrizAdyacencia[i][j];
                if (peso > 0) {
                    aristas.add(new int[] { i, j, peso });
                    System.out.println(i +" " + j + " "+peso);
                }
            }
        }

        aristas.sort((a, b) -> Integer.compare(a[2], b[2]));

        Set<Integer> visitados = new HashSet<>();

        for (int[] arista : aristas) {
            int origen = arista[0];
            int destino = arista[1];

            if (!visitados.contains(origen) || !visitados.contains(destino)) {
            	agm.add(arista);
                visitados.add(origen);
                visitados.add(destino);
            }
        }

        return agm;
    }

}

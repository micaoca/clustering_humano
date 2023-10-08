package clustering_humano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArbolGeneradorMinimo {
	
	private int[][] matrizAdyacencia;
  	private int[] padres;
  	private int vertices;
  	private int aristas;
  	private ArrayList<Arco> arcos;
  
  	public ArbolGeneradorMinimo (int[][] matrizAdyacencia) {
  		this.matrizAdyacencia = matrizAdyacencia;
  		this.padres = new int[matrizAdyacencia.length];
  		this.vertices = matrizAdyacencia.length;
  		this.aristas = matrizAdyacencia.length;
  		this.arcos = new ArrayList<Arco>();
  	}
  	
  	public List<Arco> getAGM() {
		iniciarPadres();
		armarArcos(matrizAdyacencia);
		ordenarArcos();
		
		int[] padres = darPadres();
		List<Arco> aristasAGM = new ArrayList<Arco>();
		
		for(int i = 0; i < padres.length; i++) {
			if(i != padres[i])
				aristasAGM.add(new Arco(i, padres[i], matrizAdyacencia[i][padres[i]]));
		}
		
		return aristasAGM;
	}
  	
  	private void iniciarPadres(){
		for(int i = 0; i<padres.length; i++) {
			padres[i] = i;
		}
	}
  	
  	private void armarArcos(int[][] matrizAdyacencia) {
		for(int i = 0; i < matrizAdyacencia.length; i++) {
			for(int j = 0; j < matrizAdyacencia.length; j++) {
				if(i != j) {
					arcos.add(new Arco(i, j, matrizAdyacencia[i][j]));
				}
			}
		}
	}
  	
  	private void ordenarArcos() {
		Collections.sort(arcos, new Comparator<Arco>() {
			@Override
			public int compare(Arco arco1, Arco arco2){
				return arco1.getPeso() - arco2.getPeso();
			}
		});
	}
  	
  	private void unir(int origen, int destino) {
		 int unionO = getPadre(origen);
		 int unionD = getPadre(destino);
		 padres[unionO] = unionD;
	}
  	
  	private int[] darPadres() {
  		int cant_arcos = 0;
		int i = 0;
		
  		while(cant_arcos < this.vertices - 1 && i < aristas) {
			int origen = arcos.get(i).getO();
			int destino = arcos.get(i).getD();
			
			if(getPadre(origen) != getPadre(destino)){
				unir(origen, destino);
				cant_arcos++;
			}
			
			i++;
		}
  		return padres;
  	}
	  
  	private int getPadre(int vertice) { 
  		if (padres[vertice] == vertice) {
  			return vertice; 
		}
  		return getPadre(padres[vertice]);
	}

	public ArrayList<Arco> getArcos() {
		return this.arcos;
	}
}

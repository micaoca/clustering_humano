package clustering_humano;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
	
	public ArrayList<Persona> personas = new ArrayList<>();
	private Grafo grafo;

	public Aplicacion() {}

	public void agregarPersona(String nombre, int d, int m, int e, int c) {
		personas.add(new Persona(nombre, d, m, e, c));
	}
	 
	public void armarGrupoPersonas() throws Exception {
		try {
			iniciarGrafo();
			agregarAristas();
			/*List<int[]> agm = ArbolGeneradorMinimo.getAGM(grafo.getMatrizAdyacencia(), personas.size());
			for(int i = 0; i < agm.size(); i++) {
				System.out.print(agm.get(i)[0] + " " + agm.get(i)[1]);
			}*/
			List<Arco> agm = grafo.darAGM();
			for(Arco arco : agm) {
				System.out.println(arco.toString());
			}
		} catch(Exception e) { 
			throw new Exception("Error interno.");
		}
	}
	
	private void iniciarGrafo() {
		this.grafo = new Grafo(personas.size());
	}
	
	private void agregarAristas() {
		  
		for(int fila = 0; fila < personas.size() ; fila++) {
			for(int columna = (fila + 1); columna < personas.size() ; columna++) {
				grafo.agregarArista(fila, columna, indiceSimilaridad(fila, columna));
			}	
		}

		this.grafo.imprimirMatriz();
		//this.grafo.obtenerAristaMenorPeso();
		//this.grafo.obtenerAristaMayorPeso();
	 }
	
	private int indiceSimilaridad(int fila, int columna) {
		 
		 int d1 = personas.get(fila).getD();
		 int m1 = personas.get(fila).getM();
		 int e1 = personas.get(fila).getE();
		 int c1 = personas.get(fila).getC();
		 
		 int d2 = personas.get(columna).getD();
		 int m2 = personas.get(columna).getM();
		 int e2 = personas.get(columna).getE();
		 int c2 = personas.get(columna).getC();

		 return (Math.abs(d1 - d2)) + Math.abs((m1 - m2)) + Math.abs((e1 - e2)) + Math.abs((c1 - c2));
		 
	 }
}

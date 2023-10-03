package clustering_humano;

import java.util.HashMap;

public class Aplicacion {
	
	public HashMap<Integer, Persona> personas = new HashMap<>();
	private Grafo grafo;
	private int contador;

	public Aplicacion() {
		contador = 0;
	}

	 public void agregarPersona(String nombre, int d, int m, int e, int c) {
		 	Persona persona = new Persona(nombre,d,m,e,c);
	        personas.put(contador, persona);
	        contador += 1;
	 }
	 
	 
	 public void armarGrupoPersonas() {
		 armarGrafo();
		 agregarAristas();
	 }
	 
	 private void armarGrafo() {
		 
		 if(personas.size() < 0 || personas == null) {
			 throw new NullPointerException("La lista es nula");
		 }
		 
		 this.grafo = new Grafo(personas.size());
		
	 }
	 
	 private void agregarAristas() {
		  
		for(int fila = 0; fila < personas.size() ; fila++) {
			for(int columna = (fila + 1); columna < personas.size() ; columna++) {
				grafo.agregarArista(fila, columna, indiceSimiliridad(fila, columna));
			}	
		}

		this.grafo.imprimirMatriz();
		this.grafo.obtenerAristaMenorPeso();
		
	 }
	
	 private int indiceSimiliridad(int fila, int columna) {
		 
		 //intereses persona 1
		 int d1 = personas.get(fila).getD();
		 int m1 = personas.get(fila).getM();
		 int e1 = personas.get(fila).getE();
		 int c1 = personas.get(fila).getC();
		 
		 //intereses persona 2
		 int d2 = personas.get(columna).getD();
		 int m2 = personas.get(columna).getM();
		 int e2 = personas.get(columna).getE();
		 int c2 = personas.get(columna).getC();
		 
		 int indiceSimilaridad = (d1 - d2) + (m1 -  m2) + (e1 - e2) + (c1 - c2);

		 return indiceSimilaridad;
		 
	 }
	
	
}

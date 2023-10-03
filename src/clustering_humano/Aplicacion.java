package clustering_humano;

import java.util.ArrayList;

public class Aplicacion {
	
	public ArrayList<Persona> personas = new ArrayList<>();
	private GrafoPersonas grafo;

	public Aplicacion() {}

	public void agregarPersona(String nombre, int d, int m, int e, int c) {
		personas.add(new Persona(nombre,d,m,e,c));
	}
	 
	public void armarGrupoPersonas() throws Exception {
		try {
			armarGrafo();
			grafo.armarAristas();
		} catch(Exception e) { 
			throw new Exception("Error interno.");
		}
	}
	 
	private void armarGrafo() {
		this.grafo = new GrafoPersonas(personas);
	}
	
	
}

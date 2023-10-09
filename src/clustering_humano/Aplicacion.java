package clustering_humano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Aplicacion {
	
	public Map<Integer, Persona> personas = new HashMap<>();
	private Grafo grafo;
	private int contador;
	Set<Integer> grupo1 = new HashSet<>();
	Set<Integer> grupo2 = new HashSet<>();

	public Aplicacion() {
		contador = 0;
	}

	public void agregarPersona(String nombre, int d, int m, int e, int c) {
		personas.put(contador, new Persona(nombre, d, m, e, c));
		contador++;
	}
	 
	public void armarGrupoPersonas() throws Exception {
		try {
			iniciarGrafo();
			agregarAristas();
			
			ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(grafo.getMatrizAdyacencia());
			List<Arco> aristasAGM = agm.getAGM();
			Solver.eliminarArcoMayorPeso(aristasAGM);
			
	        for (Arco arco : aristasAGM) {
	            if (grupo1.isEmpty() || (grupo1.contains(arco.getD()) || grupo1.contains(arco.getO()))) {
	            	grupo1.add(arco.getD());
	            	grupo1.add(arco.getO());
	            }
	            else {
	            	grupo2.add(arco.getD());
	            	grupo2.add(arco.getO());
	            }
	        }

		} catch(Exception e) { 
			throw new Exception("Error interno.");
		}
	}
	
	public String[] nombresGrupo1() {
		String[] nombresGrupo1 = new String[grupo1.size()];
		int i = 0;
		
        for (Integer elemento : grupo1) {
        	nombresGrupo1[i] = personas.get(elemento).getNombre();
        	i++;
        }
		
        return nombresGrupo1;
	}
	
	public String[] nombresGrupo2() {
		String[] nombresGrupo2 = new String[grupo2.size()];
		int i = 0;
		
        for (Integer elemento : grupo2) {
        	nombresGrupo2[i] = personas.get(elemento).getNombre();
        	i++;
        }
		
        return nombresGrupo2;
		
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

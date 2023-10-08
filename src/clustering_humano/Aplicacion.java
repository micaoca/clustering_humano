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

			
			Collections.sort(aristasAGM, Comparator.comparingInt(arco -> arco.getPeso()));
			
			for(int i = 0; i < aristasAGM.size(); i++) {
				System.out.println(aristasAGM.get(i) + " ");
			}
			
			//-------------------------------------------------------------------------------//
			
			Set<Persona> grupo1 = new HashSet<>();
			Set<Persona> grupo2 = new HashSet<>();
			
			Arco arcoMayorPeso = aristasAGM.get(aristasAGM.size() - 1);
			for(Arco arco : aristasAGM) {
				if(!arco.equals(arcoMayorPeso)) {
					
				}
			}

			/*
			//int destinoGuardado = agm.get(0).getD();
			Arco arcoMayorPeso = agm.get(0);
			for(Arco arco : agm) {
				if(arco.getPeso() > arcoMayorPeso.getPeso()) {
					//destinoGuardado = arcoMayorPeso.getD();
					arcoMayorPeso = arco;
				}
			}
			
						grupo2.add(personas.get(arcoMayorPeso.getD()));
			
			for(Persona persona : grupo1) {
				System.out.print("GRUPO 1: ");
				System.out.println(persona.getNombre());
			}
			
			for(Persona persona : grupo2) {
				System.out.print("GRUPO 2: ");
				System.out.println(persona.getNombre());
			}*/
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

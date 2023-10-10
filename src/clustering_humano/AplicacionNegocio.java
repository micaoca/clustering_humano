package clustering_humano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AplicacionNegocio {
	
	private Grafo grafo;
	private Map<Integer, Persona> personas = new HashMap<>();
	private int contador_ids;
	Set<Integer> grupo1 = new HashSet<>();
	Set<Integer> grupo2 = new HashSet<>();

	public AplicacionNegocio() {
		contador_ids = 0;
	}

	public void agregarPersona(String nombre, int d, int m, int e, int c) throws IllegalArgumentException {
		if(!validarValores(nombre, d, m, e, c)) {
			throw new IllegalArgumentException("Error en los campos. Verifique que respeten el dato de entrada.");
		}

		personas.put(contador_ids, new Persona(nombre, d, m, e, c));
		contador_ids++;
	}

	

	public void ejecutar() throws Exception {
		try {
			iniciarGrafo();
			agregarArcos();
			ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(grafo.getMatrizAdyacencia());
			List<Arco> arcosAGM = agm.getAGM();
			
			Arco arcoMayorPeso = eliminarArcoMayorPeso(arcosAGM);
	        armarGrupos(arcosAGM, arcoMayorPeso);
		} catch(Exception e) { 
			throw new Exception("Error interno.");
		}
	}

	public void armarGrupos(List<Arco> arcosAGM, Arco arcoMayorPeso) {
		grupo1.add(arcoMayorPeso.getO());
		grupo2.add(arcoMayorPeso.getD());
		for (Arco arco : arcosAGM) {
			boolean verticesEnG1 = estaEnGrupo1(arco.getD()) || estaEnGrupo1(arco.getO());
			
		    if(grupo1.isEmpty() || verticesEnG1) {
		    	if(!estaEnGrupo2(arco.getD())) {
			    	grupo1.add(arco.getD());
		    	}
		    	if(!estaEnGrupo2(arco.getO())) {
			    	grupo1.add(arco.getO());
		    	}
		    }
		    else {
		    	if(!estaEnGrupo1(arco.getD())) {
		    		grupo2.add(arco.getD());
		    	}
		    	if(!estaEnGrupo1(arco.getO())) {
		    		grupo2.add(arco.getO());
		    	}
		    }
		}
	}
	
	private boolean estaEnGrupo2(int vertice) {
		return grupo2.contains(vertice);
	}
	
	private boolean estaEnGrupo1(int vertice) {
		return grupo1.contains(vertice);
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
	
	public Arco eliminarArcoMayorPeso(List<Arco> arcos) throws Exception {
		Arco arcoMayorPeso = Grafo.mayorPeso(arcos);
		arcos.remove(arcoMayorPeso);
		return arcoMayorPeso;
	}
	
	private void iniciarGrafo() {
		this.grafo = new Grafo(personas.size());
	}
	
	public void agregarArcos() {
		for(int fila = 0; fila < personas.size() ; fila++) {
			for(int columna = (fila + 1); columna < personas.size(); columna++) {
				grafo.agregarArco(fila, columna, indiceSimilaridad(fila, columna));
			}	
		}
	 }
	
	public int indiceSimilaridad(int fila, int columna) throws IndexOutOfBoundsException {
		
		if(fila < 0 || fila >= personas.size()||
			columna < 0 || columna >= personas.size()) {
			throw new IndexOutOfBoundsException("El índice es invalido.");
		} 
		
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
	
	private boolean validarValores(String inputNombre, int inputDeportes, int inputMusica,
			int inputEspectaculos, int inputCiencia) {
		return validarCadena(inputNombre) && validarEntero(inputDeportes) && validarEntero(inputMusica) && validarEntero(inputEspectaculos) && validarEntero(inputCiencia);
	}
	
	private boolean validarCadena(String inputNombre) {
		return inputNombre.length() > 0;
	}
	
	private boolean validarEntero(int inputEntero) {
		List<Integer> numerosValidos = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		return numerosValidos.contains(inputEntero);
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public Map<Integer, Persona> getPersonas() {
		return personas;
	}
	
}

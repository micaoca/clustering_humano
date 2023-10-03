package clustering_humano;

import java.util.ArrayList;

public class GrafoPersonas {

	private ArrayList<Persona> personas;
	private ArrayList<AristaPersonas> aristas;
	
	public GrafoPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
		this.aristas = new ArrayList<AristaPersonas>();
	}
	
	public void armarAristas() throws Exception {
		try {
			for(int i = 0; i < personas.size(); i++) {
				for(int j = 0; j < personas.size(); j++) {
					if(i != j) {
						aristas.add(new AristaPersonas(personas.get(i), personas.get(j)));
					}
				}
			}
			imprimirAristas();
		} catch(NullPointerException e) {
			throw new Exception("La lista de personas está vacia.");
		}
		
	}
	
	

	public int consultarPesoArista(Persona persona1, Persona persona2) throws Exception {
		
		for(AristaPersonas arista : aristas) {
			if(arista.getPersona1().equals(persona1) && arista.getPersona2().equals(persona2)) {
				return arista.getPeso();
			}
		}
		
		throw new Exception("no existe la arista, tarado.");
	
	}
	
	public int obtenerCantidadAristas() {
		return aristas.size();
	}
	
	
	public int obtenerAristaMenorPeso() {
		
		int aristaMinima = aristas.get(0).getPeso();
		
		for(AristaPersonas arista : aristas) {
			if(arista.getPeso() < aristaMinima) {
				aristaMinima = arista.getPeso();
			}
		}
		
        System.out.println("Arista de menor peso: " + aristaMinima);
		return aristaMinima;
	}
	
	public int obtenerAristaMayorPeso() {
		
		int aristaMayor = aristas.get(0).getPeso();
		
		for(AristaPersonas arista : aristas) {
			if(arista.getPeso() > aristaMayor) {
				aristaMayor = arista.getPeso();
			}
		}
		
        System.out.println("Arista de mayor peso: " + aristaMayor);
		return aristaMayor;
	}
	
	public void imprimirAristas() {
		for(AristaPersonas arista : aristas) {
			System.out.println(arista.getPersona1().getNombre() + " está conectado con " + arista.getPersona2().getNombre() + ", y la similaridad entre ambos tiene un promedio de " + arista.getPeso());
		}
	}

		
}

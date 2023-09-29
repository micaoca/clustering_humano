package clustering_humano;

public class test {

	public static void main(String[] args) {
		 
		 juego partida = new juego();
		 partida.agregarPersona("Mica",1,2,1,4);
		 partida.agregarPersona("Maca",2,5,1,3);
		 partida.agregarPersona("gonzalo",3,2,1,4);
		 partida.agregarPersona("susana",3,2,1,4);
		
		 
		 partida.armarGrupoPersonas();
		 
		 
	}
	
}

package clustering_humano;

public class AristaPersonas {
    private Persona persona1;
    private Persona persona2;
    private int peso;

    public AristaPersonas(Persona persona1, Persona persona2) {
        this.persona1 = persona1;
        this.persona2 = persona2;
        this.peso = similaridadEntre(persona1, persona2);
    }
    
    private int similaridadEntre(Persona p1, Persona p2) {
        return (Math.abs(p1.getD() - p2.getD())) + Math.abs((p1.getM() -  p2.getM())) + Math.abs((p1.getE() - p2.getE())) + Math.abs((p1.getC() - p2.getC()));
    }

    public Persona getPersona1() {
        return persona1;
    }

    public Persona getPersona2() {
        return persona2;
    }

    public int getPeso() {
        return peso;
    }
    
}

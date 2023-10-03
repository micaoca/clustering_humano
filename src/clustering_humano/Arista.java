package clustering_humano;

public class Arista {
    private Persona vertice1;
    private Persona vertice2;
    private int peso;

    public Arista(Persona vertice1, Persona vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.peso = similaridadEntre(vertice1, vertice2);
    }
    
    private int similaridadEntre(Persona p1, Persona p2) {
        return (p1.getD() - p2.getD()) + (p1.getM() -  p2.getM()) + (p1.getE() - p2.getE()) + (p1.getC() - p2.getC());
    }

    public Persona getVertice1() {
        return vertice1;
    }

    public Persona getVertice2() {
        return vertice2;
    }

    public int getPeso() {
        return peso;
    }
    
}

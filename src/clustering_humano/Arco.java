package clustering_humano;

public class Arco {

	
	private int o;
	private int d;
	private int peso;


    public Arco(int o, int d, int peso) {
    	
        this.o = o;
        this.d = d;
        this.peso = peso;
        
    }
    
    public int compareTo(Arco arco2) {
        return this.peso - arco2.peso;
    }

	public int getO() {
		return o;
	}

	public void setO(int o) {
		this.o = o;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
    
	@Override
	public String toString() {
		return "Soy un arco. Mi origen es: " + o + " y mi destino es " + d +". Mi peso es de " + peso;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Arco otroArco = (Arco) o;
        return this.o == otroArco.o && this.d == otroArco.d && this.peso == otroArco.peso;
    }
	
}

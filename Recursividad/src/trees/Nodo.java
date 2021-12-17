package trees;

public abstract class Nodo {
	
	
	private Nodo izq, dcha;

	public Nodo() {
		super();
		this.izq = null;
		this.dcha = null;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public Nodo getDcha() {
		return dcha;
	}

	public void setDcha(Nodo dcha) {
		this.dcha = dcha;
	}
	
	public abstract String getValor();
	

}

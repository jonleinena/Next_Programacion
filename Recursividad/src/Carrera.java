
public class Carrera {
	
	
	public static void metodoRecursivo(Oso o, Caracol c) {
		if(o.getPosicion() == c.getPosicion()) {
			System.out.println("se han juntado en la posición: " + o.getPosicion());
		} else {
			o.vamos();
			c.vamos();
			metodoRecursivo(o, c);
		}
	}
	
	public static void main(String[] args) {
		Oso o = new Oso(0);
		Caracol c = new Caracol(100);
		
		metodoRecursivo(o, c);
	}

}

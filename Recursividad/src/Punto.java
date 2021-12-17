
public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public int calcularPendiente(Punto p) {
		return (p.getY()-this.y)/(p.getX()-this.x);
	}

	public void moverPunto(int d) {
		this.x += d;
		this.y += d;
	}
	
	public Punto puntoCentral(Punto p) {
		return new Punto(this.x, p.getY());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public static void main(String args[]) {
		
		
		
		
		//Person b = new Sister();
		//b.hello();		
		
		//Dady c = new Sister();
		//c.hello();
		

		//Mom d = new Sister();
		//d.hello();


		Brother e = new Sister();
		e.hello();
		
		

		
		
		
	}
	
	
	
}




interface Dady {
	public void hello();
}

abstract class Brother extends Person implements Dady {

	
	public void hello() {
		System.out.println("Soy el hermano");
	}
	
}

abstract class Person implements Mom{
	public void hello() {
		System.out.println("persona");
	}
	
}

interface Mom extends Dady{
	public default void hello() {
		System.out.println("Soy la madre");
	}
}


 class Sister extends Person implements Dady{
	Sister(){
		super();
	}
	public void hello() {
		System.out.println("Soy la hermana");
	}
	
	
}



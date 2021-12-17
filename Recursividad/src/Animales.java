
abstract class Animal {
	
	int posicion;

	public Animal(int posicion) {
		super();
		this.posicion = posicion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public abstract void vamos();

}

class Oso extends Animal{
	
	private static int velocidad = 5;

	public Oso(int posicion) {
		super(posicion);
	}

	@Override
	public void vamos() {
		setPosicion(getPosicion()+velocidad);
		
	}	
}

class Caracol extends Animal{
	private static int velocidad = 1;

	public Caracol(int posicion) {
		super(posicion);
	}
	@Override
	public void vamos() {
		setPosicion(getPosicion()+velocidad);
		
	}	
	
}
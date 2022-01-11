package clases;

public class Maquina {
	
	private String nombre;

	public Maquina(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}

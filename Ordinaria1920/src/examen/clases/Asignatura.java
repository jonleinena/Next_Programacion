package examen.clases;

public class Asignatura {

	public String nombre;
	
	public Asignatura(String nombre) {

		this.nombre=nombre;
		
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

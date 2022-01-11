package clases;

public class Empleado {
	
	private String nombre;
	private Maquina[] maquinas;
	
	

	public Empleado() {
		super();
	}



	public Empleado(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}
	
	

	public Empleado(String nombre, Maquina[] maquinas) {
		super();
		this.nombre = nombre;
		this.maquinas = maquinas;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina[] getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(Maquina[] maquinas) {
		this.maquinas = maquinas;
	}



	@Override
	public String toString() {
		return nombre;
	}
	
	

}

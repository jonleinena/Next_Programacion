package examen.backend.datos;

public abstract class Empleado extends Persona
{
	public Empleado() 
	{
		super();
	}

	public Empleado(String dNI, String nombre, String apellido, String direccion, String procedencia) 
	{
		super(dNI, nombre, apellido, direccion, procedencia);
	}

	public abstract void registrar();

}

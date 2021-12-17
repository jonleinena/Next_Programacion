package examen.backend.datos;

public class Persona 
{
	private String dNI;
	private String nombre;
	private String apellido;
	private String direccion;
	private String procedencia;
	
	public Persona() 
	{
		super();
	}

	public Persona(String dNI, String nombre, String apellido, String direccion, String procedencia) 
	{
		super();
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.procedencia = procedencia;
	}

	public String getdNI() 
	{
		return dNI;
	}

	public void setdNI(String dNI) 
	{
		this.dNI = dNI;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	public String getProcedencia() 
	{
		return procedencia;
	}

	public void setProcedencia(String procedencia) 
	{
		this.procedencia = procedencia;
	}
	
}

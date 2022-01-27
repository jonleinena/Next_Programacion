
public class PersonaConDNI extends Persona
{
	public String dni;
	
	public PersonaConDNI()
	{
		super();
	}
	
	public PersonaConDNI(String dni, String nombre, int edad)
	{
		super(nombre, edad);
		this.dni = dni;
	}

	public String getDni() 
	{
		return dni;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}
}

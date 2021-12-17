
public class PersonaConDni extends Persona {

	private String dni;

	public PersonaConDni() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PersonaConDni(String nombre, int edad, String dni) {
		super(nombre, edad);
		this.dni = dni;
	}



	public PersonaConDni(String dni) {
		super();
		this.dni = dni;
	}



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}



	@Override
	public String toString() {
		return "PersonaConDni [dni=" + dni +"nombre" + getNombre() + "edad" + getEdad() +"]";
	}
	
	
	
	
	
	
	
}


public class PersonaSinDni extends Persona {

	public PersonaSinDni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonaSinDni(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PersonaSinDni "+getNombre() + " edad" + getEdad();
	}

	
	
	
}

package examen.backend.datos;

public class Paciente extends Persona
{
	private int historiaClinica;
	private String medicamentos[];
	
	public Paciente() 
	{
		super();
	}

	public Paciente(String dNI, String nombre, String apellido, String direccion, String procedencia, int historiaClinica, String[] medicamentos) 
	{
		super(dNI, nombre, apellido, direccion, procedencia);
		this.historiaClinica = historiaClinica;
		this.medicamentos = medicamentos;
	}

	public int getHistoriaClinica() 
	{
		return historiaClinica;
	}

	public void setHistoriaClinica(int historiaClinica) 
	{
		this.historiaClinica = historiaClinica;
	}

	public String[] getMedicamentos() 
	{
		return medicamentos;
	}

	public void setMedicamentos(String[] medicamentos) 
	{
		this.medicamentos = medicamentos;
	}
	
}

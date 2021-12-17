package examen.backend.datos;

import examen.interfaces.ISalario;

public class EmpleadoPlantilla extends Empleado implements ISalario
{
	private float salarioMensual;

	public EmpleadoPlantilla() 
	{
		super();
	}

	public EmpleadoPlantilla(String dNI, String nombre, String apellido, String direccion, String procedencia, float salarioMensual) 
	{
		super(dNI, nombre, apellido, direccion, procedencia);
		this.salarioMensual = salarioMensual;
	}

	public float getSalarioMensual() 
	{
		return salarioMensual;
	}

	public void setSalarioMensual(float salarioMensual) 
	{
		this.salarioMensual = salarioMensual;
	}

	

	@Override
	public float getSalario() 
	{
		return this.salarioMensual;
	}

	@Override
	public float calcularSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registrar() {
		// TODO Auto-generated method stub
		
	}

	

}

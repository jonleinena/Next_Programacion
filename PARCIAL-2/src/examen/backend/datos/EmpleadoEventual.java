package examen.backend.datos;

import examen.frontend.UtilidadesLP;
import examen.interfaces.ISalarioEventual;

public class EmpleadoEventual extends Empleado implements ISalarioEventual
{
	private float pagoHora;
	private int horasTotales;
	private int horasNormales;
	private float salarioTotal;
	
	public EmpleadoEventual() 
	{
		super();
	}
	
	public EmpleadoEventual(String dNI, String nombre, String apellido, String direccion, String procedencia, float pagoHora, int horasTotales, int horasNormales, float salarioTotal) 
	{
		super(dNI, nombre, apellido, direccion, procedencia);
		this.pagoHora = pagoHora;
		this.horasTotales = horasTotales;
		this.horasNormales = horasNormales;
		this.salarioTotal = salarioTotal;
	}

	public float getPagoHora() 
	{
		return pagoHora;
	}

	public void setPagoHora(float pagoHora) 
	{
		this.pagoHora = pagoHora;
	}

	public int getHorasTotales() 
	{
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) 
	{
		this.horasTotales = horasTotales;
	}

	public int getHorasNormales() 
	{
		return horasNormales;
	}

	public void setHorasNormales(int horasNormales) 
	{
		this.horasNormales = horasNormales;
	}

	public float getSalarioTotal() 
	{
		return salarioTotal;
	}

	public void setSalarioTotal(float salarioTotal) 
	{
		this.salarioTotal = salarioTotal;
	}

	@Override
	public float calcularSalario() {
		// TODO Auto-generated method stub
		return this.salarioTotal/this.horasNormales;
	}

	@Override
	public float getSalario() {
		// TODO Auto-generated method stub
		return salarioTotal;
	}

	@Override
	public int calcularHorasTotales() {
		// TODO Auto-generated method stub
		return (int) (this.salarioTotal/this.pagoHora);
	}

	@Override
	public void registrar() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el salario total");
		salarioTotal = UtilidadesLP.leerEntero();
	}

	
}

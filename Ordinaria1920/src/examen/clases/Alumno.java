package examen.clases;

import java.util.ArrayList;

public class Alumno {

	
	private ArrayList<Asignatura> asignaturas;
	private String nombre;
	
	public Alumno(String nombre) {
		this.nombre=nombre;
		this.asignaturas= new ArrayList<Asignatura>();
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void anyadirAsig(Asignatura asig) {
		this.asignaturas.add(asig);
	}
	
	public void eliminarAsignatura(int index) {
		this.asignaturas.remove(index);
	}

	@Override
	public String toString() {
		return nombre;
	}



}

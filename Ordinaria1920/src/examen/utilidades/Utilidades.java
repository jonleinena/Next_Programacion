package examen.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import examen.clases.Alumno;
import examen.clases.Asignatura;

public class Utilidades {

	public static void escribir(ArrayList<Object> array, String nombreFichero) {
		String ruta="."+File.separator+nombreFichero;
		File aFile = new File(ruta);
		try {
			FileWriter fw = new FileWriter(aFile);
			for(int i =0; i<array.size();i++) {
				fw.write(array.get(i).toString());
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Alumno> leerAlumno(String nombreFichero) {
		String ruta="."+File.separator+"src"+File.separator+nombreFichero;
		File aFile = new File(ruta);
		ArrayList<Alumno> a=new ArrayList<Alumno>();
		try {
			
			FileReader fw = new FileReader(aFile);
			BufferedReader bf = new BufferedReader(fw);
			String texto = bf.readLine();
			while(texto!=null) {
				Alumno al = new Alumno(texto);
				ArrayList<Asignatura> arr = leerAsignatura(al.getNombre()+".txt");
				al.setAsignaturas(arr);
				a.add(al);
				texto=bf.readLine();
			}
			bf.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static ArrayList<Asignatura> leerAsignatura(String nombreFichero) {
		String ruta="."+File.separator+"src"+File.separator+nombreFichero;
		File aFile = new File(ruta);
		ArrayList<Asignatura> a=new ArrayList<Asignatura>();
		try {
			
			FileReader fw = new FileReader(aFile);
			BufferedReader bf = new BufferedReader(fw);
			String texto = bf.readLine();
			while(texto!=null) {
				Asignatura al = new Asignatura(texto);
				a.add(al);
				texto=bf.readLine();
			}
			bf.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public static void guardarFicheroAlumno(Alumno alumno) {
		String ruta="."+File.separator+"src"+File.separator+alumno.getNombre()+".txt";
		File aFile = new File(ruta);
		try {
			FileWriter fw = new FileWriter(aFile);
			for(int i =0; i<alumno.getAsignaturas().size();i++) {
				fw.write(alumno.getAsignaturas().get(i).toString()+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void guardarFicheroAsignaturas(ArrayList<Asignatura> asigs) {
		String ruta="."+File.separator+"src"+File.separator+"asignaturas.txt";
		File aFile = new File(ruta);
		try {
			FileWriter fw = new FileWriter(aFile);
			for(int i =0; i<asigs.size();i++) {
				fw.write(asigs.get(i).toString()+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

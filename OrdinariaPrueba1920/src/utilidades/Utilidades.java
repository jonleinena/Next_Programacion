package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import clases.Empleado;
import clases.Maquina;

public class Utilidades {
	
	public static ArrayList<Empleado> leerEmpleados() 
	{
		String ruta="."+File.separator+"src"+File.separator+"empleados.txt";
		File aFile = new File(ruta);
		ArrayList<Empleado> a=new ArrayList<Empleado>();
		try {
			FileReader fw = new FileReader(aFile);
			BufferedReader bf = new BufferedReader(fw);
			String texto = bf.readLine();
			while(texto!=null) {
				Empleado al = new Empleado(texto);
				ArrayList<Maquina> arr = leerMaquinas(al.getNombre()+".txt");
				Maquina maq[] = new Maquina[2];
				if(arr.size()>0)
				{
					maq[0]=arr.get(0);
					if(arr.size()>1)
					{	
						maq[1]=arr.get(1);
					}
				}
				al.setMaquinas(maq);
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
	public static ArrayList<Maquina> leerMaquinas(String nombreFichero) 
	{
		String ruta="."+File.separator+"src"+File.separator+nombreFichero;
		File aFile = new File(ruta);
		ArrayList<Maquina> a=new ArrayList<Maquina>();
		try {
			
			FileReader fw = new FileReader(aFile);
			BufferedReader bf = new BufferedReader(fw);
			String texto = bf.readLine();
			while(texto!=null) {
				Maquina al = new Maquina(texto);
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
	
	public static void guardarEmpleados(Empleado emp) 
	{
		String ruta="."+File.separator+"src"+File.separator+emp.getNombre()+".txt";
		File aFile = new File(ruta);
		try {
			FileWriter fw = new FileWriter(aFile);
			for(int i =0; i<emp.getMaquinas().length;i++) {
				fw.write(emp.getMaquinas()[i].toString()+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void guardarMaquinas(ArrayList<Maquina> maq) 
	{
		String ruta="."+File.separator+"src"+File.separator+"maquinas.txt";
		File aFile = new File(ruta);
		try {
			FileWriter fw = new FileWriter(aFile);
			for(int i =0; i<maq.size();i++) {
				fw.write(maq.get(i).toString()+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

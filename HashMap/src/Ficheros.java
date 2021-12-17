import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ficheros {

	
	public static ArrayList<String> leerFichero(){
		ArrayList<String> nombres = new ArrayList<String>();
		File aFile = new File("nombres.txt");
		FileReader fr;
		try {
			fr = new FileReader(aFile);
			BufferedReader brr = new BufferedReader(fr);
			String nombre = brr.readLine();
			while(nombre!= null) {
				nombres.add(nombre);
				nombre = brr.readLine();
			}
			brr.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nombres;
	}
	
	
	public static void escribirFichero(ArrayList<String> nombres) {
		File aFile = new File("nombres.txt");
		FileWriter fw;
		try {
			 fw = new FileWriter(aFile);
				for (int i = 0; i < nombres.size(); i++) {
					fw.write(nombres.get(i));
					fw.flush();
					
				}
				fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static ArrayList<Persona> leerObjetos(String ruta){
		ArrayList<Persona> personas = new ArrayList<Persona>();
		File f = new File(ruta+".txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				String[] lineaSeparada = linea.split("-"); //["72724823Y", "Joxe", "25"]
				if(lineaSeparada.length == 3) {
					String nombre = lineaSeparada[1];
					String dni = lineaSeparada[0];
					int edad = Integer.parseInt(lineaSeparada[2]); //pasar de string a int					
					personas.add(new PersonaConDni(nombre, edad, dni));
				} else if(lineaSeparada.length == 2) {
					String nombre = lineaSeparada[0];
					int edad = Integer.parseInt(lineaSeparada[1]);
					personas.add(new PersonaSinDni(nombre, edad));
				}
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}
	
	
	
	public static int leerSueldo(String dni) throws  IOException {
		int sueldo= 0;
		File f = new File("sueldo-"+dni+".txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		sueldo += Integer.parseInt(br.readLine());
		br.close();
		fr.close();
		
		return sueldo;
	}
	
	
	
	
	public static void verSueldos(ArrayList<Persona> personas) {		
		for (Persona persona : personas) {
			if(persona instanceof PersonaConDni) {
				try {
					int sueldo = leerSueldo(((PersonaConDni) persona).getDni());
					System.out.println(persona.getNombre() + " tiene un sueldo de " + sueldo);
				}  catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	public static void escribirEnRuta(String ruta) {
		
		if(ruta.endsWith(File.separator)) { //C:\Users\JONLE\OneDrive\Escritorio\DEUSTO\2. maila\1. kuatri\PROGRAM\WorkspaceCINE\Ficheros\src\ficheros\A_B.txt				
			ruta+="A_B.txt";
		}
		else {
			ruta+=File.separator+"A_B.txt";
		}
		File aFile = new File(ruta);
		if(aFile.exists()) {
			System.out.println("Ya existe");
		} else {
			FileReader fr = new FileReader(aFile);
		}
	}
	
	
	
}

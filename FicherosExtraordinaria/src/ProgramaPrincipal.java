import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProgramaPrincipal {
	
	
	
	
	
	
	public static void main(String[] args) {
		// ArrayList<Persona> lista = leerObjetos();
		// verSueldos(lista);

		try {
			ArrayList<Amigo> amigos = leerAmigos("miscolegis.txt");
			mostrarAmigos(amigos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Persona> leerObjetos() {
		ArrayList<Persona> lista = new ArrayList<Persona>();

		File f = new File("objetos.txt");

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			while (linea != null) {
				//Persona nuevaPersona = null;

				String[] datos = linea.split("-");
				if (datos.length == 2) {
					int edad = Integer.parseInt(datos[1]);
					lista.add(new PersonaSinDNI(datos[0], edad));
				} else if (datos.length == 3) {
					int edad = Integer.parseInt(datos[2]);
					lista.add(new PersonaConDNI(datos[0], datos[1], edad));
				}

				linea = br.readLine();
			}

			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static void verSueldos(ArrayList<Persona> lista) {
		
		
		for (Persona a : lista) {
			if (a instanceof PersonaConDNI) {
				File f = new File("sueldo-" + ((PersonaConDNI) a).getDni() + ".txt");

				try {
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);

					String linea = br.readLine();
					System.out.println(a.getNombre() + " tiene un sueldo de " + linea + " €");
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static ArrayList<Amigo> leerAmigos(String nombreF) throws IOException {

		ArrayList<Amigo> amigos = new ArrayList<Amigo>();
		File aFile = new File(nombreF);
		FileReader fr = new FileReader(aFile);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			String[] lineaSeparada = linea.split(";");

			String nombre = lineaSeparada[0];
			String apellido = lineaSeparada[1];

			Amigo a = new Amigo(nombre, apellido);
			amigos.add(a);
			linea = br.readLine();
		}

		return amigos;

	}

	public static void mostrarAmigos(ArrayList<Amigo> amigos) {

		for (int i = 0; i < amigos.size(); i++) {
			System.out.println(amigos.get(i));
		}

		/*
		 * for (Amigo amigo : amigos) { System.out.println(amigo); }
		 */
	}
}

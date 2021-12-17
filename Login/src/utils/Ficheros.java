package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Ficheros {
	
	

	public static HashMap<String, String> leerUsuarios(){
		HashMap<String, String> map = new HashMap<String, String>();
		File aFile = new File("usuarios.txt");
		FileReader fr;
		try {
			fr = new FileReader(aFile);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				String[] lineaSeparada = linea.split(";");
				map.put(lineaSeparada[0], lineaSeparada[1]);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return map;
	}
	
	
	
	
	
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		/**
		HashMap<Integer, String> hashPrueba = new HashMap<Integer, String>(); //no puede tener tipos primitivos (int, char, boolean)
		hashPrueba.put(2, "Jon");
		hashPrueba.put(3, "next"); //añadir entradas en la tabla
		hashPrueba.put(1, "hola");
		hashPrueba.put(17, "xabi");
		hashPrueba.put(16, "deusto");
		
		
		System.out.println(hashPrueba.get(16)); //printear el valor asociado a una clave
		hashPrueba.remove(2); //eliminar la entrada con clave 2
		
		System.out.println(hashPrueba.containsKey(15)); //booleano a ver si ya existe una clave en la tabla
		
		String[] arrayStrings = {"a", "b", "c"}; //crear un array con valores ya inicializados (no estrictamente relacionado, pero interesante)
		
		for (int i = 0; i < arrayStrings.length; i++) {
			if(hashPrueba.containsKey((Integer)i)){
				hashPrueba.put((Integer)(i+17), arrayStrings[i]); //Ir añadiendo entradas al hashMap con lo que contiene el array 
			} else hashPrueba.put((Integer)i, arrayStrings[i]); //  comprobando que la clave que voy a meter no está ya
		}
		
		
		Iterator<Integer> it = hashPrueba.keySet().iterator(); //necesario para recorrer el hashMap
		while(it.hasNext()) {									//El hashMap NO ESTÁ ordenado, no lo puedo recorrer por posicion con un for
			Integer clave = it.next();							
			System.out.println(hashPrueba.get(clave));		//printear los valores asociados a las claves
			
		}
		
		
		
		ArrayList<String> lista = new ArrayList<String>(); //creo un arrayList de strings
		
		lista.add("hola");
		lista.add("jon"); //añadir entradas en el arrayList. se añaden al FINAL
		lista.add("deusto");
		lista.add("next");
		
		for (int i = 0; i < lista.size(); i++) {	//recorrer el arrayList. se puede hacer con un for simple
			System.out.println(lista.get(i));
		}
		
		lista.remove(2); //eliminar una entrada del arrayList
		
		lista.contains("jon"); //ver si contiene un valor concreto (devuelve un booleano)
		
		*/
		
		ArrayList<Persona> personas = Ficheros.leerObjetos("objetos");
		
				
		Ficheros.verSueldos(personas);
		
		

	}
	
	
	
	public static String invertir(String s, int num) {
		if (num == 0) {
			return "";
		}else {
			return ""+s.charAt(num-1) + invertir(s, num-1);
		}
	}
	
	
	
	
	
	
	

}

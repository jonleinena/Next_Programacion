package utilidades;

import java.util.HashMap;

public class Utilidades {

	public static boolean comprobarLogin(HashMap<String, String> users, String username, String password) {
		boolean loginCorrecto = false;

		if (users.containsKey(username)) {
			if (users.get(username).equals(password)) {
				loginCorrecto = true;
			}
		}

		return loginCorrecto;
	}

}

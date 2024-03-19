import java.util.HashMap;

import Utils.KeyScan;

public class ConsoleApp {

	
	
	public static void main(String[] args) {
		HashMap<String,String> llavero = new HashMap<String,String>();
		KeyScan ks = new KeyScan();
		int intentos = 0;
		String _usr="";
		String _pwd="";
		
		llavero.put("user1","a11a");
		llavero.put("user2","b22b");
		llavero.put("user3","c33c");
		llavero.put("user4","a11a");
		
		System.out.println("Acceso a área de clientes:");
		while (intentos<3) {
		_usr= (String) ks.readValue("Introduzca Usuario", 's');
		_pwd= (String) ks.readValue("Introduzca Contraseña", 's');
		if (llavero.containsKey(_usr) && llavero.containsValue(_pwd)) {
			intentos = -1;
			break;
		}
		else {
			System.out.println("Usuario o contraseña incorrectos\n");
			intentos++;
			}
		} // comprueba credenciales
	 if (intentos== -1) {
		 System.out.println("Acceso concedido,entrando al sistema...");
		 }
	 else {
		 System.out.println("Ha agotado el número de intentos.");
	 } // if-else

	}
}

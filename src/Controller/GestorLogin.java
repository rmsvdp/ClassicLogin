package Controller;

import Model.Claves;

public class GestorLogin {

	private Integer intentos = 3;
	private Claves acc;
	
	
	public GestorLogin(Claves _acc) {
		acc = _acc;
	}
	
	/**
	 *  Comprueba el usuario / contraseña
	 * @param u usuario
	 * @param p contraseña
	 * @return resultado -1 OK, 1 KO pero tiene intentos , 0 KO intentos agotados
	 */
	public Integer CheckAccess(String u, String p) {
		
		Integer result = 0; // Error
		
		if (acc.foundUser(u) && acc.foundPass(p)) {
			intentos = -1;
		}
		else {
			intentos++;
			}
		result =  (intentos<3)? 1:0;
		return result;
	}
	
}

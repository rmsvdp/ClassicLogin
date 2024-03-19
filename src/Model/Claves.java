package Model;

import java.util.HashMap;

public class Claves {
	
	private HashMap<String,String> llavero = new HashMap<String,String>();
	
	public Claves() {
		
		llavero.put("user1","a11a");
		llavero.put("user2","b22b");
		llavero.put("user3","c33c");
		llavero.put("user4","a11a");		
	}
	
	
	public HashMap<String,String> getLlavero() {
		
		return llavero;
	}
	
	public void addClave(String u, String p) {
		
		llavero.put(u,p);
		
	}
	
	public String getPass(String u) {
		
		return llavero.get(u);
	}
	
	public Boolean foundUser(String u) {
		
		return llavero.containsKey(u);
		
	}
	public Boolean foundPass(String p) {
		
		return llavero.containsValue(p);
	}
	
	public Integer getTam() {
		
		return llavero.size();
	}
	
}

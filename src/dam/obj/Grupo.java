package dam.obj;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Grupo {

	private String nombre;
	private String pais;
	private Map<LocalDate, Cd> discografia = new TreeMap<>();
	
	Grupo(){
		
	}
	
	Grupo(String nombre, String pais, Map discografia){
		this.nombre = nombre;
		this.pais = pais;
		this.discografia = discografia;
	}

}

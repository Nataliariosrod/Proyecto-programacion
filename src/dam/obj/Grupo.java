package dam.obj;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Grupo {

	String nombre;
	String pais;
	Map<LocalDate, Cd> discografia = new TreeMap<>();

}

package dam.obj;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;



public class Grupo {

	private String nombre;
	private String pais;
	private Map<LocalDate, String> discografia = new TreeMap<>();
	private ControlExcepciones ex = new ControlExcepciones();
	
	Grupo(){
		
	}
	
	Grupo(String nombre, String pais, Map discografia){
		this.nombre = nombre;
		this.pais = pais;
		this.discografia = discografia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String DatosGrup() {
		return ""+nombre+" ("+pais+")";
		
	}
	
	public void introducirCD(Cd cd) {
		LocalDate fecha = cd.getFecha();
		String nombre = cd.getNombre();
		LocalDate temkey = null;
		for(LocalDate i : discografia.keySet()) {
			if (i.equals(fecha)) {
				temkey = i;
			}
		}
		if (temkey != null) {	
			int key = 0;
			System.out.println("Ya existe un CD con esa misma fecha de lanzamiento /n¿Desea Sobreescribirlo?");
			while (key == 0) {
				System.out.println("¿Que deseea hacer?/n1.Sobreescribirlo/n2.Cancelar");
				key = ex.controlInt();
				switch (key) {
				case 1:
					discografia.remove(temkey);
					discografia.put(fecha ,nombre);
					System.out.println("El CD se ha sobreescrito con éxito");
					break;
					
				case 2:
					System.out.println("Cancelando operación");
					break;
	
				default:
					System.out.println("Error. Intriduzca una opción correcta");
					break;
				}	
			}
		}else{
			discografia.put(fecha, nombre);
		}
	}
	
	public LocalDate getFechaCd(String nombre) {
		LocalDate tempKey = null;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				tempKey = i.getKey();
			}
		}
		return tempKey;
	}
	
}
	



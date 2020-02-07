package dam.obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class Grupo {

	private String nombre;
	private String pais;
	private Map<LocalDate, String> discografia = new TreeMap<>();
	private ControlExcepciones ex = new ControlExcepciones();
	
	Grupo(){
		
	}
	
	/**
	 * Constructor Grupo Sobrecargado
	 * @param nombre
	 * @param pais
	 * @param discografia
	 */
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
	
	/**
	 * Metodo para introducir un nuevo CD
	 * @param cd
	 */
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
	
	/**
	 * Metodo para Obtener la fecha de salida de un CD
	 * @param nombre
	 * @return
	 */
	public LocalDate getFechaCd(String nombre) {
		LocalDate tempKey = null;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				tempKey = i.getKey();
			}
		}
		return tempKey;
	}
	
	/**
	 * Motodo para modificar la fecha de un CD
	 * @param fecha
	 * @param nuevaFecha
	 */
	public void modificarFechaCd(LocalDate fecha, LocalDate nuevaFecha) {
		String tempVal = null;
		LocalDate tempKey = null;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getKey().equals(fecha)) {
				tempVal = i.getValue();
				tempKey = i.getKey();
			}
		}
		if (tempKey != null) {
			discografia.remove(tempKey);
			discografia.put(nuevaFecha, tempVal);
		}
	}
	
	/**
	 * Metodo para eliminar un CD
	 * @param nombre
	 */
	public void eliminarCd(String nombre) {
		LocalDate tempKey = null;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().contentEquals(nombre)) {
				tempKey = i.getKey();
			}
		}
		if (tempKey != null) {
			discografia.remove(tempKey);
			System.out.println("El CD "+nombre+" ha sido eliminado.");
		}
		else {
			System.out.println("El nombre introducido no está en la lista.");
		}
	}
	
	/**
	 * Metodo para recorrer la discografia.
	 * @param nombre
	 * @return
	 */
	public boolean recorrerDiscografia(String nombre) {
		boolean b = false;
		for(Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				b = true;
			}
		}
		return b;
	}
	
	/**
	 * Metodo para modificar el nommbre de un CD
	 * @param nombre
	 * @param nuevoNombre
	 */
	public void modificarNombreCd(String nombre, String nuevoNombre) {
		for(Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				i.setValue(nuevoNombre);
			}
		}
	}
	
	/**
	 * Metodo para mostrar la discografia.
	 */
	public void mostrarDiscografia() {
		for(Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			System.out.println(i.getValue()+" ("+i.getKey().getDayOfMonth()+"/"+i.getKey().getMonthValue()+"/"+i.getKey().getYear()+")");
		}
	}
	
	/**
	 * Metodo para saber los datos del Grupo
	 * @return
	 */
	public String getDatos() {
		return "'"+nombre+"' ("+pais+")";
	}
	
	/**
	 * Método que ordena y muestra la discografia ordenada alfabeticamente.
	 */
	public void mostrarDiscografiaAlfabetica() {
		List<String> alfabetic = new ArrayList<>(discografia.values());
		Collections.sort(alfabetic);
		for(String nombre : alfabetic) {
			System.out.println(nombre);
		}
	}
	
	/**
	 * Metodo para saber si la lista de CD esta vacia
	 * @return
	 */
	public boolean discografiaVacia() {
		return (discografia.size() == 0);
	}
	
}
	



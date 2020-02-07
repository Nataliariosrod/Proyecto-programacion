package obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grupo {

	/**
	 * Definimos los atributos
	 */
	private String nombre;
	private String pais;
	private Map<LocalDate, String> discografia = new TreeMap<>();
	private ControlExcepciones ex = new ControlExcepciones();

	/**
	 * Constructor sin parametros
	 */
	
	Grupo() {

	}

	/**
	 * Constructor con parametros
	 * @param nombre El nombre del grupo
	 * @param pais El pais del grupo
	 */
	
	Grupo(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	/**
	 * Metodo para mostrar el nombre del grupo
	 * @return el nombre del grupo
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para modificar el nombre del grupo
	 * @param nombre El nuevo nombre del grupo
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo para mostrar el pais
	 * @return el pais del grupo
	 */

	public String getPais() {
		return pais;
	}
	
	/**
	 * Metodo para modificar el pais del grupo
	 * @param pais El nuevo pais que le queremos dar
	 */

	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Metodo para introducir un cd
	 * @param fecha La fecha de salida del cd
	 * @param nombre El nombre del cd
	 */
	
	public void introducirCd(LocalDate fecha, String nombre) {
		LocalDate tempKey = null;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getKey().equals(fecha)) {
				tempKey = i.getKey();
			}
		}
		if (tempKey != null) {
			int key = 0;
			System.out.println("Ya existe un CD con esa fecha de lanzamiento.\n¿Desea sobreescribirlo?");
			while (key == 0) {
				System.out.println("1. Sobreescribir.\n2. Cancelar.");
				key = ex.controlInt();
				switch (key) {
				case 1:
					discografia.remove(tempKey);
					discografia.put(fecha, nombre);
					System.out.println("El CD ha sido sobreescrito");
					break;
				case 2:
					System.out.println("Cancelando operacion...");
					break;
				default:
					System.out.println("Error. Introduce una opcion valida:");
					key = 0;
					break;
				}
			}
		} else {
			discografia.put(fecha, nombre);
		}
	}
	
	/**
	 * Metodo para mostrar la fecha del cd
	 * @param nombre El nombre del cd
	 * @return la fecha del cd
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
	 * Metodo para modificar la fecha del cd
	 * @param fecha La fecha antigua del cd
	 * @param nuevaFecha La nueva fecha del cd
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
	 * Metodo para eliminar un cd
	 * @param nombre El nombre del cd a eliminar
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
			System.out.println("El CD " + nombre + " ha sido eliminado.");
		} else {
			System.out.println("El nombre introducido no está en la lista.");
		}
	}
	
	/**
	 * Metodo para ver si un cd esta en la discografia
	 * @param nombre El nombre del cd 
	 * @return true o false dependiendo de si esta o no.
	 */

	public boolean recorrerDiscografia(String nombre) {
		boolean b = false;
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				b = true;
			}
		}
		return b;
	}
	
	/**
	 * Metodo para modificar el nombre del cd
	 * @param nombre El nombre del cd
	 * @param nuevoNombre El nuevo nombre del cd
	 */

	public void modificarNombreCd(String nombre, String nuevoNombre) {
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			if (i.getValue().equalsIgnoreCase(nombre)) {
				i.setValue(nuevoNombre);
			}
		}
	}
	
	/**
	 * Metodo para mostrar la discografia
	 */

	public void mostrarDiscografia() {
		for (Map.Entry<LocalDate, String> i : discografia.entrySet()) {
			System.out.println(i.getValue() + " (" + i.getKey().getDayOfMonth() + "/" + i.getKey().getMonthValue() + "/"
					+ i.getKey().getYear() + ")");
		}
	}

	/**
	 * Metodo para ver los datos del cd
	 * @return los datos del cd
	 */
	
	public String getDatos() {
		return "'" + nombre + "' (" + pais + ")";
	}

	/**
	 * Metodo para mostrar la discografia ordenada alfabeticamente.
	 */
	
	public void mostrarDiscografiaAlfabetica() {
		List<String> alfabetic = new ArrayList<>(discografia.values());
		Collections.sort(alfabetic);
		for (String nombre : alfabetic) {
			System.out.println(nombre);
		}
	}

	/**
	 * Metodo para ver si la discografia esta vacia
	 * @return true o false.
	 */
	
	public boolean discografiaVacia() {
		return (discografia.isEmpty());
	}
	
}

package obj;

public class Representante {
	
	/**
	 * Definimos atributos de la clase
	 */
	
	private static int idStatic = 1001;
	private int id;
	private String nombre;
	private int edad;
	private float sueldo;
	private Grupo grupo;

	/**
	 * Constructor sin parametros
	 */
	
	Representante() {

	}
	
	/**
	 * Constructor con parametros para crear el objeto
	 * @param nombre El nombre del representante
	 * @param edad La edad del representante
	 * @param sueldo El sueldo del representante
	 */

	Representante(String nombre, int edad, float sueldo) {

		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.id = idStatic++;
	}

	/**
	 * Metodo para mostrar el id del representante
	 * @return  el id del representante
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo para mostrar el nombre del representante
	 * @return el nombre del representante
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para modificar el nombre del representante
	 * @param nombre El nombre por el que se cambia.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo para mostrar la edad del representante
	 * @return la edad del representante
	 */

	public int getEdad() {
		return edad;
	}

	/**
	 * Metodo para modificar la edad del representante
	 * @param edad La edad por la que se modifica 
	 */
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Metodo para mostrar el sueldo del representante
	 * @return el sueldo del representante
	 */

	public float getSueldo() {
		return sueldo;
	}
	
	/**
	 * Metodo para modificar el sueldo del representante
	 * @param sueldo El sueldo por el que se modifica
	 */

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	/**
	 * Metodo para mostrar el grupo 
	 * @return un grupo
	 */

	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * Metodo para modificar el grupo
	 * @param group El grupo por el que se modifica.
	 */
	
	
	public void setGrupo(Grupo group) {
		Grupo grupo = new Grupo(group.getNombre(), group.getPais());
		this.grupo = grupo;
	}

	/**
	 * Metodo para eliminar el grupo del representante
	 */
	
	public void eliminarGrupo() {
		this.grupo = null;
	}
	
	/**
	 * Metodo para modificar el representante del grupo
	 * @param nombre El nombre del nuevo representante
	 * @param edad La edad del nuevo representante
	 * @param sueldo El sueldo del nuevo representante
	 */

	public void modificarRepre(String nombre, int edad, float sueldo) {
		setNombre(nombre);
		setEdad(edad);
		setSueldo(sueldo);

	}
	
	/**
	 * Metodo para mostrar los datos del representante
	 * @return los datos del representante
	 */

	public String mostrarDatos() {
		if (getGrupo() == null) {
			return "ID " + getId() + " " + getNombre() + " (" + getEdad() + ") " + getSueldo() + "€ SIN GRUPO ASIGNADO";
		} else {
			return "ID " + getId() + " " + getNombre() + " (" + getEdad() + ") " + getSueldo() + "€. Representa a "
					+ getGrupo().getDatos() + "";
		}
	}

}

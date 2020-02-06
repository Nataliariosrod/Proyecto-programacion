package ejercicio_3;

public class Representante {

	private static int idStatic = 1001;
	private int id;
	private String nombre;
	private int edad;
	private float sueldo;
	private Grupo grupo;

	Representante() {

	}

	Representante(String nombre, int edad, float sueldo) {

		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.id = idStatic++;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo group) {
		Grupo grupo = new Grupo(group.getNombre(), group.getPais());
		this.grupo = grupo;
	}

	public void eliminarGrupo() {
		this.grupo = null;
	}

	public void modificarRepre(String nombre, int edad, float sueldo) {
		setNombre(nombre);
		setEdad(edad);
		setSueldo(sueldo);

	}

	public String mostrarDatos() {
		if (getGrupo() == null) {
			return "ID " + getId() + " " + getNombre() + " (" + getEdad() + ") " + getSueldo() + "€ SIN GRUPO ASIGNADO";
		} else {
			return "ID " + getId() + " " + getNombre() + " (" + getEdad() + ") " + getSueldo() + "€. Representa a "
					+ getGrupo().getDatos() + "";
		}
	}

}

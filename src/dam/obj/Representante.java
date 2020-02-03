package dam.obj;

public class Representante {

		String nombre;
		int edad;
		float sueldo;
		Grupo grupo;
		
		Representante() {
		}
		
		Representante(String nombre, int edad, float sueldo) {
			this.nombre = nombre;
			this.edad = edad;
			this.sueldo = sueldo;
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
		public void setGrupo(Grupo grupo) {
			this.grupo = grupo;
		}

		@Override
		public String toString() {
			return "Representante [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + ", grupo=" + grupo
					+ "]";
		}
		
		
	}
	


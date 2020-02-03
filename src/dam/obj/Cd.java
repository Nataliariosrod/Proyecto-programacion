package dam.obj;

import java.time.LocalDate;

public class Cd {

	 String nombre;
	 LocalDate fecha;
	
	public Cd() {
	}
	public Cd(String nombre, int anio, int mes, int dia) {
		this.nombre = nombre;
		this.fecha = LocalDate.of(anio, mes, dia);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(int anio, int mes, int dia) {
		this.fecha = LocalDate.of(anio, mes, dia);
	}
	public int getDia() {
		return fecha.getDayOfMonth();
	}
	public int getMes() {
		return fecha.getMonthValue();
	}
	public int getAño() {
		return fecha.getYear();
	}
	public String getFechaString() {
		return "La fecha es:"+getDia()+"/"+getMes()+"/"+getAño();
	}
}

	


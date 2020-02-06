package ejercicio_3;

import java.time.LocalDate;

public class Cd {
	
	private String nombre;
	private LocalDate fecha;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getDia() {
		return fecha.getDayOfMonth();
	}
	
	public int getMes() {
		return fecha.getMonthValue();
	}
	
	public int getAnio() {
		return fecha.getYear();
	}
	
	public String getFechaString() {
		return getDia()+"/"+getMes()+"/"+getAnio();
	}
	
}

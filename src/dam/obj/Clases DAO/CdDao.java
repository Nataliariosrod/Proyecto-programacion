package ejercicio_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CdDao {

	
	static Scanner entrada = new Scanner(System.in);
	static ControlExcepciones ex = new ControlExcepciones();
	static int id = GrupoDao.id;
	static Grupo group = new Grupo();
	static Cd cd = new Cd();
	static List<Representante> managersList = GrupoDao.managersList;

	
	
	public boolean listaCdVacia() {
		boolean vacia = false;
		int i = 0;
		if (managersList.size() == 0) {
			vacia = true;
		}
		else {
			for (Representante representante : managersList) {
				if (!representante.getGrupo().discografiaVacia()) {
					i++;
				}
			}
		}
		if (i == 0) {
			vacia = true;
		}
		return vacia;
	}
	
	
	public void modificarNombreCd(String nombre) {
		System.out.println("\nIntroduce el nombre nuevo del CD:");
		String nuevoNombre = entrada.nextLine();
		for (Representante representante : managersList) {
			if (representante.getGrupo().recorrerDiscografia(nombre)) {
				representante.getGrupo().modificarNombreCd(nombre, nuevoNombre);
			}
		}
	}
	
	public void modificarFechaCd(String nombre) {
		System.out.println("\nIntroduce la fecha nueva del CD:");
		LocalDate nuevaFecha = ex.controlDate();
		for (Representante representante : managersList) {
			if (representante.getGrupo().recorrerDiscografia(nombre)) {
				representante.getGrupo().modificarFechaCd(representante.getGrupo().getFechaCd(nombre), nuevaFecha);
			}
		}
	}
	
	public void menuModificarCD() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		}
		else {
			System.out.println("\nIntroduce el nombre del CD para modificarlo:");
			String nombreCd = entrada.nextLine();
			
			for (Representante representante : managersList) {
				if(representante.getGrupo().recorrerDiscografia(nombreCd)) {
					int key = 0;
					do {
						System.out.println("\nMENU MODIFICAR CD");
						System.out.println("Elija una opción:");
						System.out.println("1. Modificar nombre.");
						System.out.println("2. Modificar fecha.");
						System.out.println("0. Volver al menu anterior.");;
						key = ex.controlInt();
						
						switch (key) {
						case 1:
							modificarNombreCd(nombreCd);
							break;
						case 2:
							modificarFechaCd(nombreCd);
							break;
						case 0:
							System.out.println("Volviendo al menu anterior...");
							break;
						default:
							System.out.println("Error. Introduce una opcion valida.");
							break;
						}
						
					}while(key != 0);
				}
				else {
					System.out.println("El nombre del cd introducido no existe.");
				}
			}
		}
	}

	
	public void eliminarCD() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		}
		else {
			System.out.println("\nIntroduce el nombre del CD para eliminarlo:");
			String nombre = entrada.nextLine();
			
			for (Representante representante : managersList) {
				if(id == representante.getId()) {
					representante.getGrupo().eliminarCd(nombre);
				}
			}
		}
	}
	public void menuDiscografia() {
		int key = 0;
		do {
			System.out.println("\nMENU DISCOGRAFIA");
			System.out.println("Elija una opcion:");
			System.out.println("1. Introducir nuevo CD.");
			System.out.println("2. Listar discografia.");
			System.out.println("3. Ir a MENU MODIFICAR CD.");
			System.out.println("4. Eliminar un CD.");
			System.out.println("0. Volver al menu anterior.");
		
			key = ex.controlInt();
			switch (key) {
			case 1:
				introducirCd();
				break;
			case 2:
				listarDiscografia();
				break;
			case 3:
				menuModificarCD();
				break;
			case 4:
				eliminarCD();
				break;
			case 0:
				System.out.println("Volviendo al menu anterior...");
				break;
			default:
				System.out.println("Error. Introduce una opcion valida.");
				break;
			}
		}while (key!=0);
	}
	public void listarDiscografia() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		}
		else {
			int key = 0;
			while (key == 0) {
				System.out.println("¿Como quiere mostrar la discografia?\n1. Por fecha de lanzamiento.\n2. Por orden alfabético");
				key = ex.controlInt();
				switch (key) {
				case 1:
					for (Representante representante : managersList) {
						if(id == representante.getId()) {
							representante.getGrupo().mostrarDiscografia();
						}
					}
					break;
				case 2:
					for (Representante representante : managersList) {
						if(id == representante.getId()) {
							representante.getGrupo().mostrarDiscografiaAlfabetica();;
						}
					}
					break;
				default:
					System.out.println("Error. Introduce una opcion valida.");
					key = 0;
					break;
				}
			}
		}
	}
	
	public void introducirCd() {
		System.out.println("\nIntroduce el nombre del CD:");
		String nombre = entrada.nextLine();
		System.out.println("\nIntroduce la fecha de lanzamiento:");
		cd.setFecha(ex.controlDate());
		cd.setNombre(nombre);
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.getGrupo().introducirCd(cd);
			}
		}
	}
}

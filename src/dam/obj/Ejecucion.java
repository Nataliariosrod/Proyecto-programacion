package ejercicio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Ejecucion {
	
	/**
	 * @param managerList Define un ArrayList de Representantes
	 * @param group Define un objeto Grupo
	 * @param  cd Define un objeto Cd 
	 * @param id Define un numero 
	 * @param ex Define un objeto ControlExcepciones
	 * @param entrada Define un objeto Scanner
	 */
	
	static List<Representante> managersList = new ArrayList<>();
	static Grupo group = new Grupo();
	static Cd cd = new Cd();
	static int id;
	static ControlExcepciones ex = new ControlExcepciones();
	static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Metodo para añadir representantes al ArrayList
	 */
	
	static void añadirRepres() {
		System.out.println("\nIntroduce nombre y apellidos del representante:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce edad del representante:");
		int edad = ex.controlInt();
		
		System.out.println("Introduce el sueldo del representante:");
		float sueldo = ex.controlFloat();
		
		Representante manager = new Representante(nombre, edad, sueldo);
		managersList.add(manager);
	}
	
	/**
	 * Metodo para eliminar representantes del ArrayList
	 */
	
	static void eliminarRepres() {
		int i = 0;
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		}
		else {
			do {
				Representante temp = new Representante();
				System.out.println("\nIntroduce el ID del representante para eliminarlo:");
				id = ex.controlInt();
				for (Representante representante : managersList) {
					if(id == representante.getId()) {
						temp = representante;
						
					}
				}
				if (temp.getNombre() != null) {
					System.out.println("El representante "+temp.getId()+" "+temp.getNombre()+" ha sido eliminado.");
					managersList.remove(temp);
					i++;
				}
				if (i == 0) {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			
			} while (i == 0);
		}
	}
	
	/**
	 * Metodo para listar los representantes
	 */
	
	static void listarRepres() {
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		}
		else {
			for (Representante representante : managersList) {
				System.out.println(("\n-")+representante.mostrarDatos());
			}
		}
	}
	
	/**
	 * Metodo para modificar el nombre del representante elegido
	 */
	
	static void modificarNombreRepres() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setNombre(nombre);
			}
		}
	}
	
	/**
	 * Metodo para modificar la edad del representante elegido
	 */
	
	static void modificarEdadRepres() {
		System.out.println("\nIntroduce la nueva edad:");
		int edad = ex.controlInt();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setEdad(edad);
			}
		}
	}
	
	/**
	 * Metodo para modificar el sueldo del representante elegido
	 */
	
	static void modificarSueldoRepres() {
		System.out.println("\nIntroduce el nuevo sueldo:");
		float sueldo = ex.controlFloat();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setSueldo(sueldo);
			}
		}
	}
	
	/*static void asignarNuevoGrupo() {
		int i = 0;
		if (managersList.size() == 0) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
			i++;
		}
		else {
			do {
				System.out.println("\nIntroduce el ID del representante para asignarle un grupo:");
				id = ex.controlInt();
				for (Representante representante : managersList) {
					if (id == representante.getId()) {
						System.out.println("\nIntroduce el nombre del grupo:");
						String nombreGrupo = entrada.nextLine();
						group.setNombre(nombreGrupo);
						System.out.println("Introduce el pais del grupo:");
						String paisGrupo = entrada.nextLine();
						group.setPais(paisGrupo);
						if(representante.getGrupo() == null) {
							representante.setGrupo(group);
							i++;
						}
						else {
							int key = 0;
							do {
								System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"+representante.getGrupo().getNombre()+"').\n¿Desea sustituirlo por '"+group.getNombre()+"'?\n1. Si\n2. No");
								key = ex.controlInt();
								switch (key) {
									case 1:
										representante.setGrupo(group);
										i++;
										break;
									case 2:
										System.out.println("Cancelando operacion...");
										i++;
										break;
									default:
										System.out.println("Error. Introduce una opcion valida.");
										break;
								}
							} while (key == 0);
						}
					}
				}
				if (i == 0) {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			} while (i == 0);
		}
	}*/
	
	/**
	 * Metodo para cambiar el representante del grupo que queremos
	 */
	
	static void cambiarRepresentante() {
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		}
		else {
			System.out.println("\nIntroduce el nombre del grupo al que quieres cambiarle el representante:");
			String nombreGrupo = entrada.nextLine();
			for (Representante origen : managersList) {
				if (origen.getGrupo() != null) {
					if (nombreGrupo.equalsIgnoreCase(origen.getGrupo().getNombre())) {
						group = origen.getGrupo();
						int i = 0;
						do {
							System.out.println("\nIntroduce la ID del representante que sera asignado:");
							id = ex.controlInt();
							for (Representante representante : managersList) {
								if(id == representante.getId()) {
									if(representante.getGrupo() != null) {
										if(representante.getGrupo().equals(group)) {
												System.out.println("El grupo '"+group.getNombre()+"' ya está asignado al representante "+representante.getNombre()+" ID: "+representante.getId());
												i++;
										}
										else {
											int key = 0;
											while (key == 0) {
												System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"+representante.getGrupo().getNombre()+"').\nSi lo sustituye perderá toda la informacion del grupo '"+representante.getGrupo().getNombre()+"'.\n¿Desea sustituirlo por '"+group.getNombre()+"'?\n1. Si\n2. No");
												key = ex.controlInt();
												switch (key) {
												case 1:
													representante.setGrupo(group);
													origen.eliminarGrupo();
													i++;
													break;
												case 2:
													System.out.println("Cancelando operacion...");
													i++;
													break;
												default:
													System.out.println("Error. Introduce una opcion valida.");
													key = 0;
													break;
												}
											}
										}
									}
									else {
										representante.setGrupo(group);
										i++;
									}
								}
							}
							if (i == 0) {
								System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
								listarRepres();
							}
						} while (i == 0);
					}
				}
			}
		}
	}
	
	
	/**
	 * Metodo para introducir un nuevo grupo 
	 */
	
	static void introducirNuevoGrupo() {
		int i = 0;
		if (listaRepresVacia()) {
			System.out.println("\nNo hay ningún representante en lista. Introduzca un representante primero desde MENU REPRESENTANTES.\n");
			i++;
		}
		else {
			System.out.println("\nIntroduce el nombre del grupo:");
			String nombreGrupo = entrada.nextLine();
			group.setNombre(nombreGrupo);
			System.out.println("Introduce el pais del grupo:");
			String paisGrupo = entrada.nextLine();
			group.setPais(paisGrupo);
			do {
				System.out.println("\nIntroduce la ID del representante que sera asignado:");
				id = ex.controlInt();
				for (Representante representante : managersList) {
					if(id == representante.getId()) {
						if(representante.getGrupo() == null) {
						representante.setGrupo(group);
						i++;
						}
						else {
							int key = 0;
							while (key == 0) {
								System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"+representante.getGrupo().getNombre()+"')\nSi lo sustituye perderá toda la informacion del grupo '"+representante.getGrupo().getNombre()+"'.\n¿Desea sustituirlo por '"+group.getNombre()+"'?\n1. Si\n2. No");
								key = ex.controlInt();
								switch (key) {
								case 1:
									representante.setGrupo(group);
									i++;
									break;
								case 2:
									System.out.println("Cancelando operacion...");
									i++;
									break;
								default:
									System.out.println("Error. Introduce una opcion valida.");
									key = 0;
									break;
								}
							}
						}
					}
				}
				if (i == 0) {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			} while (i == 0);
		}
	}
	
	/**
	 * Metodo para listar los grupos
	 */
	
	static void listarGrupos() {
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		}
		else {
			for (Representante representante : managersList) {
				if(representante.getGrupo() != null) {
					System.out.println(("\n-'")+representante.getGrupo().getNombre()+"' ("+representante.getGrupo().getPais()+") representado por "+representante.getNombre() +" (ID: "+representante.getId()+")");
				}
			}
		}
	}
	
	/**
	 * Metodo que devuelve si la lista de representantes esta vacia
	 * @return true en caso de estar vacia, false si no lo esta.
	 */
	
	static boolean listaRepresVacia() {
		boolean vacia = false;
		if (managersList.size() == 0) {
			vacia = true;
		}
		return vacia;
	}
	
	/**
	 * Metodo que devuelve si la lista de grupos esta vacia.
	 * @return true en caso de estarlo, false si no lo esta.
	 */
	
	static boolean listaGruposVacia() {
		boolean vacia = false;
		int i = 0;
		if (managersList.size() == 0) {
			vacia = true;
		}
		else {
			for (Representante representante : managersList) {
				if (representante.getGrupo() != null) {
					i++;
				}
			}
		}
		if (i == 0) {
			vacia = true;
		}
		return vacia;
	}
	
	/**
	 * Metodo que devuelve si la lista de cds esta vacia
	 * @return true en caso de estarlo, false si no lo esta.
	 */
	
	static boolean listaCdVacia() {
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
	
	/**
	 * Metodo para eliminar un grupo
	 */
	
	static void eliminarGrupo() {
		int i = 0;
		Representante temp = null;
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados está vacía.\n");
			i++;
		}
		else {
			System.out.println("\nIntroduce el nombre del grupo que quieres eliminar:");
			String nombreGrupo = entrada.nextLine();
			for (Representante representante : managersList) {
				if (representante.getGrupo() != null) {
					if (nombreGrupo.equalsIgnoreCase(representante.getGrupo().getNombre())) {
						temp = representante;
					}
				}
			}
			if (temp != null) {
				System.out.println("\nEl grupo '"+temp.getGrupo().getNombre()+"' ha sido eliminado.");
				temp.eliminarGrupo();
				i++;
			}
			if (i == 0) {
				System.out.println("\nEl nombre de grupo introducido no existe.\nLa lista de grupos actual es:");
				listarGrupos();
			}
		}
	}
	
	/**
	 * Metodo para modificar el nombre del grupo elegido
	 */
	
	static void modificarNombreGrupo() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.getGrupo().setNombre(nombre);
			}
		}
	}
	
	/**
	 * Metodo para modificar el pais del del grupo
	 */
	
	static void modificarPaisGrupo() {
		System.out.println("\nIntroduce el nuevo pais:");
		String pais = entrada.nextLine();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.getGrupo().setPais(pais);
			}
		}
	}
	
	/**
	 * Metodo para introducir Cds de un grupo
	 */
	
	static void introducirCd() {
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
	
	/**
	 * Metodo para listar la discografia, puede hacerlo por orden alfabetico o no.
	 */
	
	static void listarDiscografia() {
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
	
	/**
	 * Metodo para modificar el nombre del cd elegido.
	 * @param nombre El nombre del cd que queremos cambiar.
	 */
	
	static void modificarNombreCd(String nombre) {
		System.out.println("\nIntroduce el nombre nuevo del CD:");
		String nuevoNombre = entrada.nextLine();
		for (Representante representante : managersList) {
			if (representante.getGrupo().recorrerDiscografia(nombre)) {
				representante.getGrupo().modificarNombreCd(nombre, nuevoNombre);
			}
		}
	}
	
	/**
	 * Metodo para modificar la fecha del cd
	 * @param nombre El nombre del cd al que le queremos cambiar la fecha
	 */
	
	static void modificarFechaCd(String nombre) {
		System.out.println("\nIntroduce la fecha nueva del CD:");
		LocalDate nuevaFecha = ex.controlDate();
		for (Representante representante : managersList) {
			if (representante.getGrupo().recorrerDiscografia(nombre)) {
				representante.getGrupo().modificarFechaCd(representante.getGrupo().getFechaCd(nombre), nuevaFecha);
			}
		}
	}
	
	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del cd
	 */
	
	static void menuModificarCD() {
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

	/**
	 * Metodo para eliminar un cd
	 */
	
	static void eliminarCD() {
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
	
	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos hacer con la discografia
	 */
	
	static void menuDiscografia() {
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
	
	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del grupo
	 */
	
	static void menuModificarGrupo() {
		int i = 0;
		Representante temp = null;
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.");
		}
		else {
			do {
			System.out.println("\nIntroduce el nombre del grupo que quieres modificar:");
			String nombreGrupo = entrada.nextLine();
			for (Representante representante : managersList) {
				if (representante.getGrupo() != null) {
					if (nombreGrupo.equalsIgnoreCase(representante.getGrupo().getNombre())) {
						temp = representante;
						id = representante.getId();
					}
				}
			}
			if (temp != null) {
				int key = 0;
				do {
					System.out.println("\nMENU MODIFICAR GRUPO");
					System.out.println("Elija una opción:");
					System.out.println("1. Modificar nombre del grupo.");
					System.out.println("2. Modificar pais del grupo.");
					System.out.println("3. Ir a MENU DISCOGRAFIA.");
					System.out.println("0. Volver al menu anterior.");;
					key = ex.controlInt();
					
					switch (key) {
						case 1:
							modificarNombreGrupo();
							break;
						case 2:
							modificarPaisGrupo();
							break;
						case 3:
							menuDiscografia();
							break;
						case 0:
							System.out.println("Volviendo al menu anterior...");
							break;
						default:
							System.out.println("Error. Introduce una opcion valida.");
							break;
						}
						
					}while(key != 0);
					i++;
				}
				if (i == 0) {
					System.out.println("El nombre introducido no es valido.\nLos grupos actuales son:");
					listarGrupos();
				}
			}while(i == 0);
		}
	}
	
	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del representante.
	 */
	
	static void menuModificarRepres() {
		int i = 0;
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.");
		}
		else {
			do {
				System.out.println("\nIntroduce el ID de un representante para modificar sus datos:");
				id = ex.controlInt();
				
				for (Representante representante : managersList) {
					if(id == representante.getId()) {
						System.out.println("Ha seleccionado a "+representante.mostrarDatos());
						int key = 0;
						do {
							System.out.println("\nMENU MODIFICAR REPRESENTANTE");
							System.out.println("Elija una opción:");
							System.out.println("1. Modificar nombre.");
							System.out.println("2. Modificar edad.");
							System.out.println("3. Modificar sueldo.");
							System.out.println("0. Volver al menu anterior.");;
							key = ex.controlInt();
							
							switch (key) {
							case 1:
								modificarNombreRepres();
								break;
							case 2:
								modificarEdadRepres();
								break;
							case 3:
								modificarSueldoRepres();
								break;
							case 0:
								System.out.println("Volviendo al menu anterior...");
								break;
							default:
								System.out.println("Error. Introduce una opcion valida.");
								break;
							}
							
						}while(key != 0);
						i++;
					}
				}
				if (i == 0) {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			} while (i == 0);
		}
	}
	
	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos hacer con el representante
	 */
	
	static void menuRepres() {
		int key = 0;
		do {
			System.out.println("\nMENU REPRESENTANTES");
			System.out.println("Elija una opcion:");
			System.out.println("1. Introducir nuevo representante.");
			//System.out.println("2. Asignar nuevo grupo.");
			System.out.println("2. Listar representantes.");
			System.out.println("3. Ir a MENU MODIFICAR REPRESENTANTE.");
			System.out.println("4. Eliminar un representante.");
			System.out.println("0. Volver al menu principal.");
		
			key = ex.controlInt();
			switch (key) {
			case 1:
				añadirRepres();
				break;
			/*case 2:
				asignarNuevoGrupo();
				break;*/
			case 2:
				listarRepres();
				break;
			case 3:
				menuModificarRepres();
				break;
			case 4:
				eliminarRepres();
				break;
			case 0:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Error. Introduce una opcion valida.");
				break;
			}
		}while (key!=0);
	}
	
	/**
	 * Metodo que muestra un menu en el que podremos seleccionar que hacer con los grupos
	 */
	
	static void menuGrupos() {
		int key = 0;
		do {
			System.out.println("\nMENU GRUPOS");
			System.out.println("Elija una opcion:");
			System.out.println("1. Introducir nuevo grupo.");
			System.out.println("2. Listar grupos representados.");
			System.out.println("3. Cambiar representante a grupo.");
			System.out.println("4. Ir a MENU MODIFICAR GRUPO.");
			System.out.println("5. Eliminar un grupo.");
			System.out.println("0. Volver al menu principal.");
		
			key = ex.controlInt();
			switch (key) {
			case 1:
				introducirNuevoGrupo();
				break;
			case 2:
				listarGrupos();
				break;
			case 3:
				cambiarRepresentante();
				break;
			case 4:
				menuModificarGrupo();
				break;
			case 5:
				eliminarGrupo();
				break;
			case 0:
				System.out.println("Volviendo al menu principal...");
				break;
			default:
				System.out.println("Error. Introduce una opcion valida.");
				break;
			}
		}while (key!=0);
	}
	
	/**
	 * Metodo que muestra un primer menu en el que podemos seleccionar a que menu queremos ir.
	 */
	
	static void menuPrincipal() {
		int key = 0;
		do {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("Elija una opcion:");
			System.out.println("1. Ir a MENU REPRESENTANTES.");
			System.out.println("2. Ir a MENU GRUPOS.");
			System.out.println("0. Salir del programa.");
		
			key = ex.controlInt();
			switch (key) {
			case 1:
				menuRepres();
				break;
			case 2:
				menuGrupos();
				break;
			case 0 :
				System.out.println("Ha salido del programa.");
				break;
			default:
				System.out.println("Error. Introduce una opcion valida.");
				break;
			}
		}while(key != 0);
	}
		public static void main(String[] args) {
			
			System.out.println("Bienvenido al programa de gestion de JMusic.");
			menuPrincipal();
		}
		
}

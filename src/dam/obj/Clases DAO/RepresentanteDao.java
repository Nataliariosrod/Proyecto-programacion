package ejercicio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepresentanteDao {

	static List<Representante> managersList = new ArrayList<>();
	static Scanner entrada = new Scanner(System.in);
	static ControlExcepciones ex = new ControlExcepciones();
	static int id;
	static Grupo group = new Grupo();


	
	public void añadirRepres() {
		System.out.println("\nIntroduce nombre y apellidos del representante:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce edad del representante:");
		int edad = ex.controlInt();
		
		System.out.println("Introduce el sueldo del representante:");
		float sueldo = ex.controlFloat();
		
		Representante manager = new Representante(nombre, edad, sueldo);
		managersList.add(manager);
	}
	
	public void eliminarRepres() {
		int i = 0;
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		}
		else {
			do {
				Representante temp = new Representante();
				System.out.println("\nIntroduce el ID del representante para eliminarlo:");
				id = ex.controlInt();
				//managersList.stream().filter(r->r.getId()==id).map(Representante::getId);
				//managersList.stream().filter(r->r.getId()==id).collect(Collectors.toList());
 
	
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
	
	public void modificarNombreRepres() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setNombre(nombre);
			}
		}
	}
	
	public void modificarEdadRepres() {
		System.out.println("\nIntroduce la nueva edad:");
		int edad = ex.controlInt();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setEdad(edad);
			}
		}
	}
	
	public void modificarSueldoRepres() {
		System.out.println("\nIntroduce el nuevo sueldo:");
		float sueldo = ex.controlFloat();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.setSueldo(sueldo);
			}
		}
	}
	
	public void listarRepres() {
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		}
		else {
			for (Representante representante : managersList) {
				System.out.println(("\n-")+representante.mostrarDatos());
			}
		}
	}
	
	
	public void cambiarRepresentante() {
		int j = 0;
		int l = 0;
		int m = 0;
		boolean vacia = true;
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		} else {
			System.out.println("\nIntroduce el nombre del grupo al que quieres cambiarle el representante:");
			String nombreGrupo = entrada.nextLine();
			for (Representante confirmacion : managersList) {
				l++;
				if (confirmacion.getGrupo() != null) {
					if (nombreGrupo.equalsIgnoreCase(confirmacion.getGrupo().getNombre())) {
						vacia = false;
						for (Representante origen : managersList) {
							j = 0;
							if (origen.getGrupo() != null) {
								if (nombreGrupo.equalsIgnoreCase(origen.getGrupo().getNombre()) && m == 0) {
									int i = 0;
									do {
										System.out.println("\nIntroduce la ID del representante que sera asignado:");
										id = ex.controlInt();
										for (Representante representante : managersList) {
											if (id == representante.getId()) {
												if (representante.getGrupo() != null) {
													if (representante.getGrupo().equals(origen.getGrupo())) {
														System.out.println("El grupo '" + origen.getGrupo().getNombre()
																+ "' ya está asignado al representante "
																+ representante.getNombre() + " ID: "
																+ representante.getId());
														i++;
														j++;
														m++;
													} else {
														int key = 0;
														while (key == 0) {
															System.out.println(
																	"ATENCION. El representante ya tiene un grupo asignado ('"
																			+ representante.getGrupo().getNombre()
																			+ "').\nSi lo sustituye perderá toda la informacion del grupo '"
																			+ representante.getGrupo().getNombre()
																			+ "'.\n¿Desea sustituirlo por '"
																			+ origen.getGrupo().getNombre()
																			+ "'?\n1. Si\n2. No");
															key = ex.controlInt();
															switch (key) {
															case 1:
																System.out.println(
																		"El grupo " + origen.getGrupo().getNombre()
																				+ " ha sido cambiado al representante "
																				+ representante.getNombre() + " ID: "
																				+ representante.getId());
																representante.setGrupo(origen.getGrupo());
																origen.eliminarGrupo();
																i++;
																j++;
																m++;
																break;
															case 2:
																System.out.println("Cancelando operacion...");
																i++;
																j++;
																m++;
																break;
															default:
																System.out
																		.println("Error. Introduce una opcion valida.");
																key = 0;
																break;
															}
														}
													}
												} else {
													System.out.println("El grupo " + origen.getGrupo().getNombre()
															+ " ha sido cambiado al representante "
															+ representante.getNombre() + " ID: "
															+ representante.getId());
													representante.setGrupo(origen.getGrupo());
													origen.eliminarGrupo();
													i++;
													j++;
													m++;
												}
											}
										}
										if (i == 0) {
											System.out.println(
													"El ID introducido no es valido.\nLos representantes actuales son:");
											listarRepres();
										}
									} while (i == 0);
								}
							}
						}
						if (j != 0) {
							break;
						}
					}
				}
			}
			if ((l >= managersList.size() && vacia)) {
				System.out.println("El grupo no esta en la lista.");
			}
		}
	}
	
	public boolean listaRepresVacia() {
		boolean vacia = false;
		if (managersList.size() == 0) {
			vacia = true;
		}
		return vacia;
	}
	

	public void menuRepres() {
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
	
	public void menuModificarRepres() {
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
	
	
	
}

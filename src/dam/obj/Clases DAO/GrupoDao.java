package ejercicio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupoDao {

	
	static Scanner entrada = new Scanner(System.in);
	static ControlExcepciones ex = new ControlExcepciones();
	static int id = RepresentanteDao.id;
	static Grupo group = new Grupo();
	static Cd cd = new Cd();
	static RepresentanteDao r1= new RepresentanteDao();
	static CdDao cd1= new CdDao();
	static List<Representante> managersList = RepresentanteDao.managersList;
	
	
	public void listarGrupos() {
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
	
	public boolean listaGruposVacia() {
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
	
	public void eliminarGrupo() {
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
	
	public void modificarNombreGrupo() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.getGrupo().setNombre(nombre);
			}
		}
	}
	
	public void modificarPaisGrupo() {
		System.out.println("\nIntroduce el nuevo pais:");
		String pais = entrada.nextLine();
		
		for (Representante representante : managersList) {
			if(id == representante.getId()) {
				representante.getGrupo().setPais(pais);
			}
		}
	}
	
	
	public void menuModificarGrupo() {
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
							cd1.menuDiscografia();
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
	
	public void menuGrupos() {
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
				r1.cambiarRepresentante();
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
	
	
	public void introducirNuevoGrupo() {
		int i = 0;
		if (r1.listaRepresVacia()) {
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
					r1.listarRepres();
				}
			} while (i == 0);
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
	
}

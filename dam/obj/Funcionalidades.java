/**
 * Funcionalidades
 * 
 * @author Natalia Rios, Curro Caro y Miguel Alcantara
 */
package obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionalidades {

	/**
	 * @param managerList Define un ArrayList de Representantes
	 * @param id          Define un numero entero
	 * @param ex          Define un objeto ControlExcepciones
	 * @param entrada     Define un objeto Scanner
	 */

	static List<Representante> managersList = new ArrayList<>();
	static int id;
	static ControlExcepciones ex = new ControlExcepciones();
	static Scanner entrada = new Scanner(System.in);

	/**
	 * Metodo para añadir representantes al ArrayList
	 */

	static void aniadirRepres() {
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
		/*
		 * int i = 0; if (listaRepresVacia()) {
		 * System.out.println("\nLa lista de representantes esta vacia.\n"); } else {
		 * //Representante temp = new Representante();
		 * System.out.println("\nIntroduce el ID del representante para eliminarlo:");
		 * id = ex.controlInt(); for (Representante representante : managersList) { if
		 * (id == representante.getId()) { if (representante.getGrupo() == null) { temp
		 * = representante; } else {
		 * System.out.println("ATENCION. El representante con ID " +
		 * representante.getId() + " (" + representante.getNombre() +
		 * ") tiene asignado un grupo (" + representante.getGrupo().getNombre() + ").");
		 * System.out.println("Si lo elimina perderá todos los datos de ese grupo.");
		 * System.out.println("¿Está seguro de que desea eliminarlo?'?\n1. Si\n2. No"
		 * ); int key = ex.controlInt(); switch (key) { case 1: temp = representante;
		 * break; case 2: System.out.println("Cancelando operacion..."); i++; ; break;
		 * default: System.out.println("Error. Introduce una opcion valida."); key = 0;
		 * break; } } } } if (temp.getNombre() != null) {
		 * System.out.println("El representante " + temp.getId() + " " +
		 * temp.getNombre() + " ha sido eliminado."); managersList.remove(temp); i++; }
		 * if (i == 0) { System.out.
		 * println("El ID introducido no es valido.\nLos representantes actuales son:");
		 * listarRepres(); } } }
		 */
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		} else {

			System.out.println("\nIntroduce el ID del representante para eliminarlo:");
			id = ex.controlInt();
			if (managersList.stream().anyMatch(r -> r.getId() == id)) {
				Representante temp = managersList.stream().filter(r -> r.getId() == id).findFirst()
						.orElse(new Representante());
				if (temp.getGrupo() != null) {
					System.out.println("ATENCION. El representante con ID " + temp.getId() + " (" + temp.getNombre()
							+ ") tiene asignado un grupo (" + temp.getGrupo().getNombre() + ").");
					System.out.println("Si lo elimina perdera todos los datos de ese grupo.");
					System.out.println("�Esta seguro de que desea eliminarlo?\n1. Si\n2. No");
					int key = ex.controlInt();
					switch (key) {
					case 1:
						System.out.println(
								"El representante " + temp.getId() + " " + temp.getNombre() + " ha sido eliminado.");
						managersList.remove(temp);
						break;
					case 2:
						System.out.println("Cancelando operacion...");
						break;
					default:
						System.out.println("Error. Introduce una opcion valida.");
						key = 0;
						break;
					}
				}
				if (temp.getGrupo() == null) {
					System.out.println(
							"El representante " + temp.getId() + " " + temp.getNombre() + " ha sido eliminado.");
					managersList.remove(temp);
				}
			} else {
				System.out.println("El ID introducido no es valido.\nLos representantes actuales son:\n");
				listarRepres();
			}
		}
	}

	/**
	 * Metodo para listar los representantes
	 */

	static void listarRepres() {
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.\n");
		} else {
			/*
			 * for (Representante representante : managersList) { System.out.println(("\n-")
			 * + representante.mostrarDatos());
			 * 
			 * }
			 */
			managersList.stream().map(r -> r.mostrarDatos()).forEach(System.out::println);
		}
	}

	/**
	 * Metodo para modificar el nombre del representante elegido
	 */

	static void modificarNombreRepres() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();

		/*
		 * for (Representante representante : managersList) { if (id ==
		 * representante.getId()) { representante.setNombre(nombre); } }
		 */
		managersList.stream().filter(i -> i.getId() == id).forEach(r -> r.setNombre(nombre));
	}

	/**
	 * Metodo para modificar la edad del representante elegido
	 */

	static void modificarEdadRepres() {
		System.out.println("\nIntroduce la nueva edad:");
		int edad = ex.controlInt();

		/*
		 * for (Representante representante : managersList) { if (id ==
		 * representante.getId()) { representante.setEdad(edad); } }
		 */
		managersList.stream().filter(i -> i.getId() == id).forEach(r -> r.setEdad(edad));
	}

	/**
	 * Metodo para modificar el sueldo del representante elegido
	 */

	static void modificarSueldoRepres() {
		System.out.println("\nIntroduce el nuevo sueldo:");
		float sueldo = ex.controlFloat();

		/*
		 * for (Representante representante : managersList) { if (id ==
		 * representante.getId()) { representante.setSueldo(sueldo); } }
		 */
		managersList.stream().filter(i -> i.getId() == id).forEach(r -> r.setSueldo(sueldo));
	}

	/**
	 * Metodo para cambiar el representante del grupo que queremos
	 */

	static void cambiarRepresentante() {
		/*
		 * int j = 0; int l = 0; int m = 0; boolean vacia = true; if
		 * (listaGruposVacia()) {
		 * System.out.println("\nLa lista de grupos representados esta vacia.\n"); }
		 * else { System.out.
		 * println("\nIntroduce el nombre del grupo al que quieres cambiarle el representante:"
		 * ); String nombreGrupo = entrada.nextLine(); for (Representante confirmacion :
		 * managersList) { l++; if (confirmacion.getGrupo() != null) { if
		 * (nombreGrupo.equalsIgnoreCase(confirmacion.getGrupo().getNombre())) { vacia =
		 * false; for (Representante origen : managersList) { j = 0; if
		 * (origen.getGrupo() != null) { if
		 * (nombreGrupo.equalsIgnoreCase(origen.getGrupo().getNombre()) && m == 0) { int
		 * i = 0; do {
		 * System.out.println("\nIntroduce la ID del representante que sera asignado:");
		 * id = ex.controlInt(); for (Representante representante : managersList) { if
		 * (id == representante.getId()) { if (representante.getGrupo() != null) { if
		 * (representante.getGrupo().equals(origen.getGrupo())) {
		 * System.out.println("El grupo '" + origen.getGrupo().getNombre() +
		 * "' ya está asignado al representante " + representante.getNombre() + " ID: "
		 * + representante.getId()); i++; j++; m++; } else { int key = 0; while (key ==
		 * 0) { System.out.println(
		 * "ATENCION. El representante ya tiene un grupo asignado ('" +
		 * representante.getGrupo().getNombre() +
		 * "').\nSi lo sustituye perderá toda la informacion del grupo '" +
		 * representante.getGrupo().getNombre() + "'.\n¿Desea sustituirlo por '" +
		 * origen.getGrupo().getNombre() + "'?\n1. Si\n2. No"); key = ex.controlInt();
		 * switch (key) { case 1: System.out.println( "El grupo " +
		 * origen.getGrupo().getNombre() + " ha sido cambiado al representante " +
		 * representante.getNombre() + " ID: " + representante.getId());
		 * representante.setGrupo(origen.getGrupo()); origen.eliminarGrupo(); i++; j++;
		 * m++; break; case 2: System.out.println("Cancelando operacion..."); i++; j++;
		 * m++; break; default: System.out
		 * .println("Error. Introduce una opcion valida."); key = 0; break; } } } } else
		 * { System.out.println("El grupo " + origen.getGrupo().getNombre() +
		 * " ha sido cambiado al representante " + representante.getNombre() + " ID: " +
		 * representante.getId()); representante.setGrupo(origen.getGrupo());
		 * origen.eliminarGrupo(); i++; j++; m++; } } } if (i == 0) {
		 * System.out.println(
		 * "El ID introducido no es valido.\nLos representantes actuales son:");
		 * listarRepres(); } } while (i == 0); } } } if (j != 0) { break; } } } } if ((l
		 * >= managersList.size() && vacia)) {
		 * System.out.println("El grupo no esta en la lista."); } }
		 */

		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		} else {
			System.out.println("\nIntroduce el nombre del grupo al que quieres cambiarle el representante:");
			String nombreGrupo = entrada.nextLine();
			if (managersList.stream().filter(r -> r.getGrupo() != null)
					.anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))) {
				Representante origen = managersList.stream()
						.filter(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo)).findFirst()
						.orElse(new Representante());
				System.out.println("\nIntroduce la ID del representante que sera asignado:");
				id = ex.controlInt();
				if (managersList.stream().anyMatch(r -> r.getId() == id)) {
					Representante destino = managersList.stream().filter(r -> r.getId() == id).findFirst().get();
					if (origen.getGrupo() == destino.getGrupo()) {
						System.out.println(
								"El grupo '" + origen.getGrupo().getNombre() + "' ya esta asignado al representante "
										+ destino.getNombre() + " ID: " + destino.getId());
					} else if (destino.getGrupo() != null) {
						int key = 0;
						while (key == 0) {
							System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"
									+ destino.getGrupo().getNombre()
									+ "').\nSi lo sustituye perdera toda la informacion del grupo '"
									+ destino.getGrupo().getNombre() + "'.\n�Desea sustituirlo por '"
									+ origen.getGrupo().getNombre() + "'?\n1. Si\n2. No");
							key = ex.controlInt();
							switch (key) {
							case 1:
								System.out.println("El grupo " + origen.getGrupo().getNombre()
										+ " ha sido cambiado al representante " + destino.getNombre() + " ID: "
										+ destino.getId());
								destino.setGrupo(origen.getGrupo());
								origen.eliminarGrupo();
								break;
							case 2:
								System.out.println("Cancelando operacion...");
								break;
							default:
								System.out.println("Error. Introduce una opcion valida.");
								key = 0;
								break;
							}
						}
					} else {

						System.out.println(
								"El grupo " + origen.getGrupo().getNombre() + " ha sido cambiado al representante "
										+ destino.getNombre() + " ID: " + destino.getId());
						destino.setGrupo(origen.getGrupo());
						origen.eliminarGrupo();
					}

				} else {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			} else {
				System.out.println("El grupo no esta en la lista.");
			}
		}
	}

	/**
	 * Metodo para introducir un nuevo grupo
	 */

	static void introducirNuevoGrupo() {
		/*
		 * int i = 0; if (listaRepresVacia()) { System.out.println(
		 * "\nNo hay ningún representante en lista. Introduzca un representante primero desde MENU REPRESENTANTES.\n"
		 * ); i++; } else { System.out.println("\nIntroduce el nombre del grupo:");
		 * String nombreGrupo = entrada.nextLine(); group.setNombre(nombreGrupo);
		 * System.out.println("Introduce el pais del grupo:"); String paisGrupo =
		 * entrada.nextLine(); group.setPais(paisGrupo); do {
		 * System.out.println("\nIntroduce la ID del representante que sera asignado:");
		 * id = ex.controlInt(); for (Representante representante : managersList) { if
		 * (id == representante.getId()) { if (representante.getGrupo() == null) {
		 * representante.setGrupo(group); i++; } else { int key = 0; while (key == 0) {
		 * System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"
		 * + representante.getGrupo().getNombre() +
		 * "')\nSi lo sustituye perderá toda la informacion del grupo '" +
		 * representante.getGrupo().getNombre() + "'.\n¿Desea sustituirlo por '" +
		 * group.getNombre() + "'?\n1. Si\n2. No"); key = ex.controlInt(); switch (key)
		 * { case 1: representante.setGrupo(group); i++; break; case 2:
		 * System.out.println("Cancelando operacion..."); i++; break; default:
		 * System.out.println("Error. Introduce una opcion valida."); key = 0; break; }
		 * } } } } if (i == 0) { System.out.
		 * println("El ID introducido no es valido.\nLos representantes actuales son:");
		 * listarRepres(); } } while (i == 0); }
		 */

		if (listaRepresVacia()) {
			System.out.println(
					"\nNo hay ningun representante en lista. Introduzca un representante primero desde MENU REPRESENTANTES.\n");
		} else {
			Grupo tempGroup = new Grupo();
			System.out.println("\nIntroduce el nombre del grupo:");
			String nombreGrupo = entrada.nextLine();

			if (!managersList.stream().filter(r -> r.getGrupo() != null)
					.anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))) {
				tempGroup.setNombre(nombreGrupo);

				System.out.println("Introduce el pais del grupo:");
				String paisGrupo = entrada.nextLine();
				tempGroup.setPais(paisGrupo);
				do {
					System.out.println("\nIntroduce la ID del representante que sera asignado:");
					id = ex.controlInt();
					if (managersList.stream().anyMatch(r -> r.getId() == id)) {
						if (managersList.stream().filter(r -> r.getId() == id).anyMatch(r -> r.getGrupo() == null)) {
							managersList.stream().filter(r -> r.getId() == id).forEach(r -> r.setGrupo(tempGroup));
						} else {
							Representante destino = managersList.stream().filter(r -> r.getId() == id).findFirst()
									.orElse(new Representante());
							int key = 0;
							while (key == 0) {
								System.out.println("ATENCION. El representante ya tiene un grupo asignado ('"
										+ destino.getGrupo().getNombre()
										+ "')\nSi lo sustituye perdera toda la informacion del grupo '"
										+ destino.getGrupo().getNombre() + "'.\n�Desea sustituirlo por '"
										+ tempGroup.getNombre() + "'?\n1. Si\n2. No");
								key = ex.controlInt();
								switch (key) {
								case 1:
									destino.setGrupo(tempGroup);
									break;
								case 2:
									System.out.println("Cancelando operacion...");
									break;
								default:
									System.out.println("Error. Introduce una opcion valida.");
									key = 0;
									break;
								}
							}
						}
					} else {
						System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
						listarRepres();
					}
				} while (!managersList.stream().anyMatch(r -> r.getId() == id));
			} else {
				System.out.println("Ya existe un grupo en la lista con ese nombre.");
			}
		}
	}

	/**
	 * Metodo para listar los grupos
	 */

	static void listarGrupos() {
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		} else {
			for (Representante representante : managersList) {
				if (representante.getGrupo() != null) {
					System.out.println(("\n-'") + representante.getGrupo().getNombre() + "' ("
							+ representante.getGrupo().getPais() + ") representado por " + representante.getNombre()
							+ " (ID: " + representante.getId() + ")");
				}
			}
		}
	}

	/**
	 * Metodo que devuelve si la lista de representantes esta vacia
	 * 
	 * @return true o false
	 */

	static boolean listaRepresVacia() {
		return (managersList.isEmpty());
	}

	/**
	 * Metodo que devuelve si la lista de grupos esta vacia.
	 * 
	 * @return true en caso de estarlo, false si no lo esta.
	 */
	static boolean listaGruposVacia() {
		/*
		 * boolean vacia = false; int i = 0;
		 */
		if (listaRepresVacia()) {
			// vacia = true;
			return true;
		} else {
			/*
			 * for (Representante representante : managersList) { if
			 * (representante.getGrupo() != null) { i++; } } } if (i == 0) { vacia = true; }
			 */
			return (managersList.stream().map(r -> r).allMatch(r -> r.getGrupo() == null));
		}
		// return vacia;
	}

	/**
	 * Metodo que devuelve si la lista de cds esta vacia
	 * 
	 * @return true en caso de estarlo, false si no lo esta.
	 */

	static boolean listaCdVacia() {
		/*
		 * boolean vacia = false; int i = 0;
		 */
		if (listaRepresVacia()) {
			// vacia = true;
			return true;
		} else if (listaGruposVacia()) {
			return true;
			/*
			 * for (Representante representante : managersList) { if
			 * (!representante.getGrupo().discografiaVacia()) { i++; } } } if (i == 0) {
			 * vacia = true; }
			 */
			// return vacia;
		} else {
			return (managersList.stream().map(r -> r).allMatch(r -> r.getGrupo().discografiaVacia() == true));
		}
	}

	/**
	 * Metodo para eliminar un grupo
	 */

	static void eliminarGrupo() {
		/*
		 * int i = 0; Representante temp = null; if (listaGruposVacia()) {
		 * System.out.println("\nLa lista de grupos representados está vacía.\n"); }
		 * else {
		 * System.out.println("\nIntroduce el nombre del grupo que quieres eliminar:");
		 * String nombreGrupo = entrada.nextLine(); for (Representante representante :
		 * managersList) { if (representante.getGrupo() != null) { if
		 * (nombreGrupo.equalsIgnoreCase(representante.getGrupo().getNombre())) { temp =
		 * representante; } } } if (temp != null) { System.out.println("\nEl grupo '" +
		 * temp.getGrupo().getNombre() + "' ha sido eliminado."); temp.eliminarGrupo();
		 * i++; } if (i == 0) { System.out.
		 * println("\nEl nombre de grupo introducido no existe.\nLa lista de grupos actual es:"
		 * ); listarGrupos(); } }
		 */
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.\n");
		} else {
			System.out.println("\nIntroduce el nombre del grupo que quieres eliminar:");
			String nombreGrupo = entrada.nextLine();
			if (managersList.stream().filter(r -> r.getGrupo() != null)
					.anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))) {
				Representante temp = managersList.stream()
						.filter(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo)).findAny()
						.orElse(new Representante());
				System.out.println("\nEl grupo '" + temp.getGrupo().getNombre() + "' ha sido eliminado.");
				temp.eliminarGrupo();
			} else {
				System.out.println("No existe ning�n grupo en lista con ese nombre.");
			}

		}
	}

	/**
	 * Metodo para modificar el nombre del grupo elegido
	 */

	static void modificarNombreGrupo() {
		System.out.println("\nIntroduce el nuevo nombre:");
		String nombre = entrada.nextLine();

		/*
		 * for (Representante representante : managersList) { if (id ==
		 * representante.getId()) { representante.getGrupo().setNombre(nombre); } }
		 */
		if (!managersList.stream().filter(r -> r.getGrupo() != null)
				.anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombre))) {
			managersList.stream().filter(r -> r.getId() == id).findFirst()
					.ifPresent(r -> r.getGrupo().setNombre(nombre));
			System.out.println("El nombre se ha cambiado.");
		} else {
			System.out.println("Ya existe un grupo en la lista con ese nombre.");
		}
	}

	/**
	 * Metodo para modificar el pais del del grupo
	 */

	static void modificarPaisGrupo() {
		System.out.println("\nIntroduce el nuevo pais:");
		String pais = entrada.nextLine();

		/*
		 * for (Representante representante : managersList) { if (id ==
		 * representante.getId()) { representante.getGrupo().setPais(pais); } }
		 */
		managersList.stream().filter(r -> r.getId() == id).findFirst().ifPresent(r -> r.getGrupo().setPais(pais));
		System.out.println("El pais se ha cambiado.");
	}

	/**
	 * Metodo para introducir Cds de un grupo
	 */

	static void introducirCd() {
		System.out.println("\nIntroduce el nombre del CD:");
		String nombre = entrada.nextLine();
		if (!managersList.stream().anyMatch(r -> r.getGrupo().getFechaCd(nombre) != null)) {
			System.out.println("\nIntroduce la fecha de lanzamiento:");
			LocalDate fecha = ex.controlDate();

			/*
			 * for (Representante representante : managersList) { if (id ==
			 * representante.getId()) { representante.getGrupo().introducirCd(fecha,
			 * nombre); } }
			 */

			managersList.stream().filter(r -> r.getId() == id).findFirst()
					.ifPresent(r -> r.getGrupo().introducirCd(fecha, nombre));
			System.out.println("El cd " + nombre + " se ha introducido.");
		} else {
			System.out.println("Ya existe un CD en la lista con ese nombre.");
		}
	}

	/**
	 * Metodo para listar la discografia, puede hacerlo por orden alfabetico o por
	 * fecha de lanzamiento.
	 */

	static void listarDiscografia() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		} else {
			int key = 0;
			while (key == 0) {
				System.out.println(
						"�Como quiere mostrar la discografia?\n1. Por fecha de lanzamiento.\n2. Por orden alfabético");
				key = ex.controlInt();
				switch (key) {
				case 1:
					/*
					 * for (Representante representante : managersList) { if (id ==
					 * representante.getId()) { representante.getGrupo().mostrarDiscografia(); } }
					 */
					System.out.println("\nDiscografia de "
							+ managersList.stream().filter(r -> r.getId() == id).findAny().get().getGrupo().getNombre()
							+ "\n");
					managersList.stream().filter(r -> r.getId() == id).forEach(r -> r.getGrupo().mostrarDiscografia());
					break;
				case 2:
					/*
					 * for (Representante representante : managersList) { if (id ==
					 * representante.getId()) {
					 * representante.getGrupo().mostrarDiscografiaAlfabetica(); ; } }
					 */
					System.out.println("\nDiscografia de "
							+ managersList.stream().filter(r -> r.getId() == id).findAny().get().getGrupo().getNombre()
							+ "");
					managersList.stream().filter(r -> r.getId() == id)
							.forEach(r -> r.getGrupo().mostrarDiscografiaAlfabetica());
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
	 * 
	 * @param nombre El nombre del cd que queremos cambiar.
	 */

	static void modificarNombreCd(String nombre) {
		System.out.println("\nIntroduce el nombre nuevo del CD:");
		String nuevoNombre = entrada.nextLine();
		if (!managersList.stream().filter(r -> r.getId() == id)
				.anyMatch(r -> r.getGrupo().recorrerDiscografia(nuevoNombre))) {
			/*
			 * for (Representante representante : managersList) { if
			 * (representante.getGrupo().recorrerDiscografia(nombre)) {
			 * representante.getGrupo().modificarNombreCd(nombre, nuevoNombre); } }
			 */
			managersList.stream().filter(r -> r.getGrupo().recorrerDiscografia(nombre))
					.forEach(r -> r.getGrupo().modificarNombreCd(nombre, nuevoNombre));
			System.out.println("El nombre del CD se ha modificado.");
		} else {
			System.out.println("Ya existe un CD en la lista con ese nombre.");
		}
	}

	/**
	 * Metodo para modificar la fecha del cd
	 * 
	 * @param nombre El nombre del cd al que le queremos cambiar la fecha
	 */

	static void modificarFechaCd(String nombre) {

		System.out.println("\nIntroduce la fecha nueva del CD:");
		LocalDate nuevaFecha = ex.controlDate();
		if (!managersList.stream().filter(r -> r.getId() == id)
				.anyMatch(r -> r.getGrupo().getFechaCd(nombre).equals(nuevaFecha))) {
			/*
			 * for (Representante representante : managersList) { if
			 * (representante.getGrupo().recorrerDiscografia(nombre)) {
			 * representante.getGrupo().modificarFechaCd(representante.getGrupo().getFechaCd
			 * (nombre), nuevaFecha); } }
			 */
			managersList.stream().filter(r -> r.getGrupo().recorrerDiscografia(nombre))
					.forEach(r -> r.getGrupo().modificarFechaCd(r.getGrupo().getFechaCd(nombre), nuevaFecha));
		} else {
			System.out.println("Ya existe un CD en la lista con esa fecha.");
		}
	}

	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del
	 * cd
	 */

	static void menuModificarCD() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		} else {
			System.out.println("\nIntroduce el nombre del CD para modificarlo:");
			String nombreCd = entrada.nextLine();

			/*
			 * for (Representante representante : managersList) { if
			 * (representante.getGrupo().recorrerDiscografia(nombreCd))
			 */
			if (managersList.stream().anyMatch(r -> r.getGrupo().recorrerDiscografia(nombreCd))) {
				int key = 0;
				do {
					System.out.println("\nMENU MODIFICAR CD");
					System.out.println("Elija una opcion:");
					System.out.println("1. Modificar nombre.");
					System.out.println("2. Modificar fecha.");
					System.out.println("0. Volver al menu anterior.");
					;
					key = ex.controlInt();

					switch (key) {
					case 1:
						// modificarNombreCd(nombreCd);
						managersList.stream().filter(r -> r.getGrupo().recorrerDiscografia(nombreCd))
								.forEach(r -> modificarNombreCd(nombreCd));
						break;
					case 2:
						// modificarFechaCd(nombreCd);
						managersList.stream().filter(r -> r.getGrupo().recorrerDiscografia(nombreCd))
								.forEach(r -> modificarFechaCd(nombreCd));
						break;
					case 0:
						System.out.println("Volviendo al menu anterior...");
						break;
					default:
						System.out.println("Error. Introduce una opcion valida.");
						break;
					}

				} while (key != 0);
			} else {
				System.out.println("El nombre del cd introducido no existe.");
			}
		}
	}

	/**
	 * Metodo para eliminar un cd
	 */

	static void eliminarCD() {
		if (listaCdVacia()) {
			System.out.println("La lista de CDs esta vacia.");
		} else {
			System.out.println("\nIntroduce el nombre del CD para eliminarlo:");
			String nombre = entrada.nextLine();

			/*
			 * for (Representante representante : managersList) { if (id ==
			 * representante.getId()) { representante.getGrupo().eliminarCd(nombre); } } }
			 */
			managersList.stream().filter(r -> r.getId() == id).forEach(r -> r.getGrupo().eliminarCd(nombre));
		}
	}

	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos hacer con la
	 * discografia
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
		} while (key != 0);
	}

	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del
	 * grupo
	 */

	static void menuModificarGrupo() {
		int i = 0;
		Representante temp = null;
		if (listaGruposVacia()) {
			System.out.println("\nLa lista de grupos representados esta vacia.");
		} else {
			do {
				System.out.println("\nIntroduce el nombre del grupo que quieres modificar:");
				String nombreGrupo = entrada.nextLine();
				/*
				 * for (Representante representante : managersList) { if
				 * (representante.getGrupo() != null) { if
				 * (nombreGrupo.equalsIgnoreCase(representante.getGrupo().getNombre())) { temp =
				 * representante; id = representante.getId(); } } }
				 */
				if (managersList.stream().filter(r -> r.getGrupo() != null)
						.anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))) {
					temp = managersList.stream().filter(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))
							.findAny().orElse(new Representante());
					id = temp.getId();
					int key = 0;
					do {
						System.out.println("\nMENU MODIFICAR GRUPO");
						System.out.println("Elija una opcion:");
						System.out.println("1. Modificar nombre del grupo.");
						System.out.println("2. Modificar pais del grupo.");
						System.out.println("3. Ir a MENU DISCOGRAFIA.");
						System.out.println("0. Volver al menu anterior.");

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

					} while (key != 0);
					i++;
				}

				/*
				 * if (temp != null) {
				 * 
				 * }
				 * 
				 * if (i == 0) { System.out.
				 * println("El nombre introducido no es valido.\nLos grupos actuales son:");
				 * listarGrupos(); }
				 */
				if (!managersList.stream().anyMatch(r -> r.getGrupo().getNombre().equalsIgnoreCase(nombreGrupo))) {
					System.out.println("El nombre introducido no es valido.\nLos grupos actuales son:");
					listarGrupos();
				}
			} while (i == 0);
		}
	}

	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos modificar del
	 * representante.
	 */

	static void menuModificarRepres() {
		int i = 0;
		if (listaRepresVacia()) {
			System.out.println("\nLa lista de representantes esta vacia.");
		} else {
			do {
				System.out.println("\nIntroduce el ID de un representante para modificar sus datos:");
				id = ex.controlInt();

				/*
				 * for (Representante representante : managersList) { if (id ==
				 * representante.getId())
				 */
				if (managersList.stream().anyMatch(r -> r.getId() == id)) {
					System.out.println("Ha seleccionado a ");
					managersList.stream().filter(r -> r.getId() == id).map(r -> r.mostrarDatos()).findFirst()
							.ifPresent(System.out::println);
					int key = 0;
					do {
						System.out.println("\nMENU MODIFICAR REPRESENTANTE");
						System.out.println("Elija una opcion:");
						System.out.println("1. Modificar nombre.");
						System.out.println("2. Modificar edad.");
						System.out.println("3. Modificar sueldo.");
						System.out.println("0. Volver al menu anterior.");
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

					} while (key != 0);
					i++;
				}
				if (!managersList.stream().anyMatch(r -> r.getId() == id)) {
					System.out.println("El ID introducido no es valido.\nLos representantes actuales son:");
					listarRepres();
				}
			} while (i == 0);
		}
	}

	/**
	 * Metodo que muestra un menu que nos dara a elegir que queremos hacer con el
	 * representante
	 */

	static void menuRepres() {
		int key = 0;
		do {
			System.out.println("\nMENU REPRESENTANTES");
			System.out.println("Elija una opcion:");
			System.out.println("1. Introducir nuevo representante.");
			System.out.println("2. Listar representantes.");
			System.out.println("3. Ir a MENU MODIFICAR REPRESENTANTE.");
			System.out.println("4. Eliminar un representante.");
			System.out.println("0. Volver al menu principal.");

			key = ex.controlInt();
			switch (key) {
			case 1:
				aniadirRepres();
				break;
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
		} while (key != 0);
	}

	/**
	 * Metodo que muestra un menu en el que podremos seleccionar que hacer con los
	 * grupos
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
		} while (key != 0);
	}

	/**
	 * Metodo que muestra un primer menu en el que podemos seleccionar a que menu
	 * queremos ir.
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
			case 0:
				System.out.println("Ha salido del programa.");
				break;
			default:
				System.out.println("Error. Introduce una opcion valida.");
				break;
			}
		} while (key != 0);
	}
}

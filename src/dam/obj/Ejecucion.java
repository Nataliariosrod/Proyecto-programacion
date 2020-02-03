package dam.obj;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejecucion {
 static Scanner sc;
 static Representante r1 = new Representante();
 static Grupo g1 = new Grupo();
 static Cd cd1 = new Cd();
 static ArrayList<Representante> r=new ArrayList<>();
 static ArrayList<Grupo> g=new ArrayList<>();
 static ArrayList<Cd> cd=new ArrayList<>();
public static void main(String[] args) {
		

		menu();
		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			try {
				menu();
				opcion = Integer.parseInt(sc.nextLine());
				switch (opcion) {
					case 1:
						nuevoRepresentante();
						listarRepresentantes();
						System.out.println(r1.toString());
						break;
					case 2:
						

						break;
					case 3:
						eliminarTodosLosRepresentantes();
						
						break;
					case 4:
						//nuevoGrupo();
						break;

					case 5:
						
						break;
					default:
						System.out.println("Opción no valida. Por favor, introduzca una opción valida.");
				}
			}catch (Exception Ex) {
				
			}
		} while (opcion != 0);
		sc.close();
	
	}

	public static void menu() {
		System.out.println("==============================================================");
		System.out.println("|*|-------- Bienvenido al programa gestor de JMUSIC -------|*|");
		System.out.println("==============================================================");
		System.out.println("1. Insertar nuevo representante.");
		System.out.println("2. Modificar los datos de un representante.");
		System.out.println("3. Eliminar un representante.");
		
		System.out.println("4. Insertar nuevo grupo de musica.");
		System.out.println("5. Modificar los datos de un grupo de musica.");
		System.out.println("6. Eliminar un grupo de musica.");
	
		System.out.println("7.- Insertar un CD");
		System.out.println("8. Modificar los datos de un CD de musica: ");
		System.out.println("9. Eliminar un CD de musica: ");

		System.out.println("10. Salir del programa\n\n");
		System.out.print("Introduzca una opción: ");
	}
	
	public static void nuevoRepresentante() {
		System.out.println("Introduzca el nombre del nuevo representante: ");
		r1.nombre=sc.nextLine();
		System.out.println("Introduzca la edad del nuevo representante: ");
		r1.edad=sc.nextInt();
		System.out.println("Introduzca el sueldo del nuevo representante: ");
		r1.sueldo=sc.nextFloat();
		for (int i = 0; i < r.size(); i++) {
			r.add(r1);
		}
	}

//	public static void nuevoGrupo() {
//		System.out.println("Introduzca el nombre del nuevo grupo: ");
//		g1.nombre=sc.nextLine();
//		System.out.println("Introduzca el pais del nuevo grupo: ");
//		g1.pais=sc.nextLine();
//		System.out.println("Introduzca el nombre de los cds del nuevo grupo: ");
//		cd1.nombre=sc.nextLine();
//		System.out.println("Introduzca la fecha de los cds del nuevo grupo: ");
//		String m=cd1.getFechaString();
//		m=sc.nextLine();
//		g1.discografia.containsKey(cd1.fecha);
//		g1.discografia.containsValue(cd1.nombre);
//		for (int i = 0; i < r.size(); i++) {
//			g.add(g1);
//		}
//	}
	
	public static void listarRepresentantes() {
		if (r.isEmpty()) {
			System.out.println("No existen clientes registrados");
		}else {
			for (int i = 0; i < r.size(); i++) {
				System.out.println(r.get(i).toString());
			
		}
	}
	
	public static void listarGrupos() {
		if (g.isEmpty()) {
			System.out.println("No existen clientes registrados");
		}else {
			for (int i = 0; i < g.size(); i++) {
				System.out.println(g.toString());
			}
		}
	}
	
	public static void listarCds() {
		if (cd.isEmpty()) {
			System.out.println("No existen clientes registrados");
		}else {
			for (int i = 0; i < cd.size(); i++) {
				System.out.println(cd.toString());
			}
		}
	}
	public static void eliminarTodosLosRepresentantes() {
		r.clear();
		System.out.println("Todos los representantes han sido eliminados");
	}
	


}

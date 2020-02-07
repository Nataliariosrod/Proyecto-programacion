package ejercicio_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Ejecucion {


	static ControlExcepciones ex = new ControlExcepciones();
	static Scanner entrada = new Scanner(System.in);
	
	static RepresentanteDao r = new RepresentanteDao();
	static GrupoDao g = new GrupoDao();
	

	
	
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
				r.menuRepres();
				break;
			case 2:
				g.menuGrupos();
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

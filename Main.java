package org.edaii.practicas_01_02.clases;

import java.io.FileNotFoundException;
import java.util.*;

import org.edaii.practicas_01_02.pruebas.PruebaDeRendimiento; 

// TODO: Auto-generated Javadoc
/**
 * Clase MainPrueba.
 */
public class Main {

	/** Atributo: lectura. */
	private static Scanner lectura;
	
	/** Atributo: ciudad. */
	private static Ciudad ciudad;
	
	/**
	 * Main elegir opciones del programa
	 *
	 * @param args 
	 */
	public static void main(String[] args) {
		boolean exit = false;
		int opcion;
		menu();
		while(!exit) {
			System.out.println();
			System.out.println("Elija una opción (1-6):");
			try {
				lectura = new Scanner(System.in);
				opcion = lectura.nextInt();
				if(opcion < 1 || opcion > 6) { 
					System.out.println("Valor no permitido. Introduzca un valor dentro del rango: [1-6]");
					continue;
				}
			if(opcion == 6)
				exit = true;
			ejecutarOpcion(opcion);
			} catch(InputMismatchException e) {
				System.out.println("Valor no permitido. Introduzca un numero entero dentro del rango: [1-6]");
				continue;
			}
		}
	}
    
	/**
	 * Metodo de Ejecutar opciones
	 *
	 * @param opc 
	 */
	private static void ejecutarOpcion(int opc) {
		switch (opc) {
		case 1:
			System.out.println();
			System.out.println("Ha seleccionado la opcion 1: Cargar ciudad.");
			System.out.println("Eligiendo archivo...");
			System.out.println();
			
			String ruta = Utilidades.cargar();
	        try {
				ciudad = new Ciudad(ruta);
			} catch (FileNotFoundException e) {
				System.out.println("No ha cargado ninguna ciudad...");
			}
			break;
			
		case 2:
			System.out.println();
			System.out.println("Ha seleccionado la opcion 2: Generar ciudad.");
			Utilidades.generarCiudad();
			break;
			
		case 3:
			if(ciudad == null) {
				System.out.println();
				System.out.println("Antes debe de cargar una ciudad (1) o generar una (2) ... ");
				break;
			}
			System.out.println();
			System.out.println("Ha seleccionado la opcion 3: Ejecutar algoritmos.");
			System.out.println("====DyV====");
			ciudad.DyV();
			System.out.println(ciudad.getResultados());
			System.out.println("=====FB=====");
			ciudad.FuerzaB();
			System.out.println(ciudad.getResultados());
			System.out.println("====Greedy====");
			ciudad.GreedyA();
			System.out.println(ciudad.getResultados());
			break;
			
		case 4:
			System.out.println("Ha seleccionado la opcion 4: Prueba de rendimiento.");
			System.out.println("Elija el caso con el que desea hacer la prueba de rendimiento:");
			System.out.println("1. Mejor caso");
			System.out.println("2. Caso Lineal Inverso");
			System.out.println("3. Caso Lineal Normal");
			System.out.println("4. Caso Valor Constante");
			System.out.println("5. Caso Valores Adaptados a Campana de Gauss");
			int caso;
			try {
				lectura = new Scanner(System.in);
				caso = lectura.nextInt();
				if(caso < 1 || caso > 5) { 
					System.out.println("Valor no permitido. Introduzca un valor dentro del rango: [1-5]");
					break;
				}
				PruebaDeRendimiento.medir(caso);
			} catch(InputMismatchException e) {
				System.out.println("Valor no permitido. Introduzca un numero entero dentro del rango: [1-6]");
				break;
			}
			break;
			
		case 5:
			if(ciudad == null) {
				System.out.println("Antes debe de cargar una ciudad (1) o generar una (2) ... ");
				break;
			}
			System.out.println("Ha seleccionado la opcion 5: Guardar resultados.");
			Utilidades.guardar(ciudad.getResultados());
			break;
						
		case 6:
			System.out.println("Ha seleccionado la opcion 6: Salir del programa.");
			System.out.println("Finalizando ejecución.");
			break;
		}
	}
	
	/**
	 * Menu del programa
	 */
	public static void menu() {
		System.out.println("Opciones disponibles:");
		System.out.println("*********************");
		System.out.println("1.- Cargar ciudad"); 
		System.out.println("2.- Generar ciudad");
		System.out.println("3.- Ejecutar algoritmos"); 
		System.out.println("4.- Prueba de rendimiento");
		System.out.println("5.- Guardar resultados");
		System.out.println("6.- Salir");
	}
}

package org.edaii.practicas_01_02.pruebas;

import org.edaii.practicas_01_02.clases.*;

public class PruebaDeRendimiento {
	
	public static void medir (int caso) {
	
		System.out.println("Resultados de la prueba de rendimiento sobre el algoritmo Divide y Vencerás:");
		for(int i = 1; i <=10000001 ; i=i+500000) {
			System.out.println("Numero de dias: " + i);
			Distrito distrito = new Distrito(i,i);
			for(int j = 0; j <= i; j++) {
				distrito.add(i%9);
			}
			Ciudad ciudad = new Ciudad (2,2,i,distrito,caso);
			
			double Inicio1 = System.nanoTime();
			ciudad.DyV();
			double Final1 = System.nanoTime();
			System.out.println("Tiempo: " + ((double)Final1 - Inicio1));
		}
		System.out.println("Resultados de la prueba de rendimiento sobre el algoritmo FuerzaBruta:");
		for(int i = 1; i <=10000001 ; i=i+500000) {
			System.out.println("Numero de dias: " + i);
			Distrito distrito = new Distrito(i,i);
			for(int j = 0; j <= i; j++) {
				distrito.add(i%9);
			}
			Ciudad ciudad = new Ciudad (2,2,i,distrito,caso);
			
			double Inicio2 = System.nanoTime();
			ciudad.FuerzaB();
			double Final2 = System.nanoTime();
			System.out.println("Tiempo: " + ((double)Final2 - Inicio2));
		}
		System.out.println("Resultados de la prueba de rendimiento sobre el algoritmo Greedy:");
		for(int i = 1; i <=10000001 ; i=i+500000) {
			System.out.println("Numero de dias: " + i);
			Distrito distrito = new Distrito(i,i);
			for(int j = 0; j <= i; j++) {
				distrito.add(i%9);
			}
			Ciudad ciudad = new Ciudad (2,2,i,distrito,caso);
			
			double Inicio3 = System.nanoTime();
			ciudad.FuerzaB();
			double Final3 = System.nanoTime();
			System.out.println("Tiempo: " + ((double)Final3 - Inicio3));
		}
	}
}

package org.edaii.practicas_01_02.casos;

import org.edaii.practicas_01_02.clases.Distrito;
import org.edaii.practicas_01_02.clases.Utilidades;

// TODO: Auto-generated Javadoc
/**
 * Clase Casos.
 */
public class Casos {
	
	/**
	 * Caso 1.
	 *
	 * @param d the d
	 * @param dias the dias
	 */
	public static void caso1 (Distrito d,  int dias) {
		for (int i=0; i<=dias/2; i++) {
			d.add(i);
		}
		for (int i=0; i<dias/2; i++) {
			d.add(dias/2 -1 -i);
		}
	}
	
	/**
	 * Caso 2.
	 *
	 * @param d the d
	 * @param dias the dias
	 */
	public static void caso2 (Distrito d,  int dias) {
		for (int i=0; i<dias; i++) {
			d.add(dias -i);
		}
	}
	
	/**
	 * Caso 3.
	 *
	 * @param d the d
	 * @param dias the dias
	 */
	public static void caso3 (Distrito d,  int dias) {
		for (int i=0; i<dias; i++) {
			d.add(i);
		}
	}
	
	/**
	 * Caso 4.
	 *
	 * @param d the d
	 * @param dias the dias
	 */
	public static void caso4 (Distrito d,  int dias) {
		for (int i=0; i<dias; i++) {
			d.add(3);
		}
	}
	
	/**
	 * Caso 5.
	 *
	 * @param d the d
	 * @param dias the dias
	 */
	public static void caso5 (Distrito d,  int dias) {
		for (int i=0; i<dias; i++) {
			d.add(Utilidades.gauss(i, 100, dias/2, dias/4));
		}
	}
	
	
}

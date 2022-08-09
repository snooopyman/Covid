package org.edaii.practicas_01_02.clases;

// TODO: Auto-generated Javadoc
/**
 *  Clase Resultado.
 */
public class Resultado implements Comparable<Resultado> {

	/** Atributo: calle. */
	private int calle;
	
	/** Atributo: avenida. */
	private int avenida;
	
	/** Atributo: dia. */
	private int dia;
	
	/** Atributo: valor. */
	private int valor;

	/**
	 * Constructor: inicializa los atributos
	 *
	 * @param avenida the avenida
	 * @param calle the calle
	 * @param dia the dia
	 * @param valor the valor
	 */
	public Resultado(int avenida, int calle, int dia, int valor) {
		this.calle = calle;
		this.avenida = avenida;
		this.dia = dia;
		this.valor = valor;
	}

	/**
	 * Metodo toString.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "d(" + avenida + "," + calle + "), " + dia + ", " + valor + ")";
	}

	/**
	 * Metodo CompareTo.
	 *
	 * @param otro 
	 * @return the int
	 */
	public int compareTo(Resultado otro) {
		// Orden y restricciones: (1.dia > 2.valor > 3.avenida > 4.calle)
		if (dia > otro.dia) return 1;
		if (dia < otro.dia) return -1;
		if (valor > otro.valor) return -1;
		if (valor < otro.valor) return 1;
		if (avenida > otro.avenida) return -1;
		if (avenida < otro.avenida) return 1;
		if (calle > otro.calle) return -1;
		if (calle < otro.calle) return 1;
		return 0;
	}
}
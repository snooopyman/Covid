package org.edaii.practicas_01_02.clases;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Clase Distrito.
 */
public class Distrito {
	
	/** Atributo: calle. */
	private int calle;
	
	/** Atributo: avenida. */
	private int avenida;
	
	/** Atributo: dias. */
	private ArrayList<Integer> dias;
	
	/**
	 * Constructor: inicializa los atributos
	 *
	 * @param avenida the avenida
	 * @param calle the calle
	 */
	public Distrito (int avenida, int calle) {
		this.calle =  calle;
		this.avenida = avenida;
		this.dias = new ArrayList<Integer>();
	}
	
	/**
	 * Metodo add, controla fallos en la entrada de datos
	 *
	 * @param valor 
	 */
	public void add(String valor) {
		try {
			int v = Integer.parseInt(valor);
			if(v < 0) { //Si valor negativo, repetimos el ultimo valor
				repetirUltimo();
			}else {
				add(v);
			}
		}catch (NumberFormatException e) {//Si no es un numero, repetimos el ultimo
			repetirUltimo();
		}
	}
	
	/**
	 * Metodo Add
	 *
	 * @param v the v
	 */
	public void add(int v) {
		this.dias.add(v);
	}
	
	
	/**
	 * Repetir ultimo.
	 */
	private void repetirUltimo() {
		if(this.dias.size() == 0) {
			this.dias.add(0);
		}else {
			this.dias.add(this.dias.get(this.dias.size()-1));
		}
	}
	
	/**
	 * Gets the calle.
	 *
	 * @return the calle
	 */
	public int getCalle() {
		return calle;
	}

	/**
	 * Gets the avenida.
	 *
	 * @return the avenida
	 */
	public int getAvenida() {
		return avenida;
	}

	/**
	 * Gets the dias.
	 *
	 * @return the dias
	 */
	public ArrayList<Integer> getDias() {
		return dias;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return this.dias.size();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString () {
		return "d(" + avenida + "," + calle + ") -> "+ this.dias;
	}

	
}

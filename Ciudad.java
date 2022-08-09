package org.edaii.practicas_01_02.clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * Clase Ciudad.
 */
public class Ciudad {
	
	/** atributo: calles. */
	private int calles;
	
	/** atributo: avenidas. */
	private int avenidas;
	
	/** atributo: distritos. */
	private ArrayList<Distrito> distritos;
	
	/** atributo: resultados. */
	private ArrayList<Resultado> resultados;

	/**
	 * Constructor: carga el archivo.
	 *
	 * @param archivo the archivo
	 * @throws FileNotFoundException the file not found exception
	 */
	// CONSTRUCTOR
	public Ciudad(String archivo) throws FileNotFoundException {
			load(archivo);
	}
	
	/**
	 * Constructor: crea una ciudad por defecto dado un distrito en concreto, numero de dias y caso
	 * 
	 * @param distrito the distrito
	*/
	
	public Ciudad (int avenidas, int calles, int dias, Distrito d, int caso) {
		this.avenidas = avenidas;
		this.calles = calles;
		this.distritos = new ArrayList<Distrito>();
		for (int i=0; i < (avenidas - 1); i++) {
			for (int j = 0; j < (calles -1); j++) {
				d =  new Distrito(i + 1, j + 1);
				Utilidades.rellenar(d, dias, caso);
				this.distritos.add(d);
			}
		}
	}

	/**
	 * Constructor: inicializa los atributos y rellena la ciudad
	 *
	 * @param avenidas the avenidas
	 * @param calles the calles
	 * @param dias the dias
	 * @param d1 the d 1
	 * @param d2 the d 2
	 * @param caso the caso
	 */
	public Ciudad(int avenidas, int calles, int dias, int d1, int d2, int caso) {
		this.avenidas =  avenidas;
		this.calles = calles;
		this.distritos =  new ArrayList<Distrito>();
		for (int i=0; i<(avenidas -1) / d1; i++) {
			for (int j = 0; j < (calles -1)/ d2; j++) {
				Distrito d =  new Distrito(d1 * i + 1, d2 * j + 1);
				Utilidades.rellenar(d, dias, caso);
				this.distritos.add(d);
			}
		}
	}

	/**
	 * Load. Formatear
	 *
	 * @param rutaArchivo the ruta archivo
	 * @throws FileNotFoundException the file not found exception
	 */
	private void load(String rutaArchivo) throws FileNotFoundException {
		this.distritos = new ArrayList<Distrito>();
		String line;
		String[] items;
		Distrito dis;
		Scanner sc = new Scanner(new File(rutaArchivo));

		while (sc.hasNextLine()) {
			line = sc.nextLine().trim();
			if (line.isEmpty() || line.startsWith("//") || line.startsWith("@Datos"))
				continue;
			// IFS DE LAS OPERACIONES
			if (line.startsWith("@Dimensiones")) {
				line = sc.next().trim();
				items = line.split("x");
				this.avenidas = Integer.parseInt(items[0]);
				this.calles = Integer.parseInt(items[1]);
				continue;
			}
			items = line.replace("[", "").replace("]", "").split("[d(), >-]+");
			dis = new Distrito(Integer.parseInt(items[1]), Integer.parseInt(items[2]));
			for (int i = 3; i < items.length; i++) {
				dis.add(items[i]);
			}
			distritos.add(dis);
		}
		
		sc.close();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return distritos.toString();
	}
	
	/**
	 * To string generar ciudad.
	 *
	 * @return the string
	 */
	public String toStringGenerarCiudad() {
		String s = "@Dimensiones\n" + this.avenidas + "x" + this.calles + "\n@Datos\n";
		for (Distrito d : distritos) {
		s += d.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Algoritmo Fuerza Bruta
	 */
	public void FuerzaB() {
		this.resultados = new ArrayList<Resultado>();
		Resultado r;
		for (Distrito d : distritos) {
			int pos = -1;
			int max = Integer.MIN_VALUE;//-INF
			for (int i = 0; i < d.getSize(); i++) {
				if(d.getDias().get(i) > max) {
					max = d.getDias().get(i);
					pos = i;
				}
			}
			r = new Resultado(d.getAvenida(), d.getCalle(), pos+1, d.getDias().get(pos));
			this.resultados.add(r);
		}
		this.resultados.sort(null);
	}

	/**
	 * Algoritmo Divide y Venceras
	 */
	public void DyV() {
		this.resultados = new ArrayList<Resultado>();
		Resultado r;
		for (Distrito d : distritos) {
			int pos = DivideYVenceras(d.getDias(), 0, d.getSize()-1);
			r = new Resultado(d.getAvenida(), d.getCalle(), pos+1, d.getDias().get(pos));
			this.resultados.add(r);
		}
		this.resultados.sort(null);
	}

	/**
	 * Algoritmo Divide Y venceras
	 *
	 * @param dias the dias
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the int
	 */
	private int DivideYVenceras(ArrayList<Integer> dias, int inicio, int fin) {
		int mitad, izq, der;

		if (inicio == fin)
			return inicio;

		if (inicio + 1 == fin) {
			if (dias.get(inicio) >= dias.get(fin)) {
				return inicio;
			} else {
				return fin;
			}
		}
		mitad = (inicio + fin) / 2;
		if ((dias.get(mitad) > dias.get(mitad - 1)) && (dias.get(mitad) > dias.get(mitad + 1)))
			return mitad;

		if (dias.get(mitad - 1) > dias.get(mitad))
			return DivideYVenceras(dias, inicio, mitad - 1);
		if (dias.get(mitad + 1) > dias.get(mitad))
			return DivideYVenceras(dias, mitad + 1, fin);

		izq = DivideYVenceras(dias, inicio, mitad - 1);
		der = DivideYVenceras(dias, mitad + 1, fin);
		if (dias.get(izq) >= dias.get(der))
			return izq;

		return der;
	}
	
	/**
	 * Algoritmo Greedy A.
	 */
	public void GreedyA() {
		this.resultados = new ArrayList<Resultado>();
		Resultado r;
		for (Distrito d : distritos) {
			int pos = -1;
			int max = Integer.MIN_VALUE;//-INF
			for (int i = 0; i < d.getSize(); i++) {
				if(d.getDias().get(i) > max) {
					max = d.getDias().get(i);
					pos = i;
				}else {
					break;
				}
			}
			r = new Resultado(d.getAvenida(), d.getCalle(), pos+1, d.getDias().get(pos));
			this.resultados.add(r);
		}
		this.resultados.sort(null);
	}

	/**
	 * Gets the resultados.
	 *
	 * @return the resultados
	 */
	public String getResultados() {
		return resultados.toString().replace("[,", "").replace("]", "");
	}

	/**
	 * Guardar resultados.
	 *
	 * @param nombre
	 */
	public void guardarResultados(String nombre) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(nombre));
			pw.println("Resultados de la ciudad");
			for (Resultado r : resultados) {
				pw.println(r.toString());
			}
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
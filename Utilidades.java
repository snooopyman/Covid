package org.edaii.practicas_01_02.clases;

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.edaii.practicas_01_02.casos.Casos;

// TODO: Auto-generated Javadoc
/**
 * Clase Utilidades.
 */
public class Utilidades {

	/** The directorio. */
	public static String directorio = System.getProperty("user.dir") + File.separator + "src" 
										+ File.separator + "org" + File.separator + "edaii" + File.separator ;
	// Método para abrir una ventana del explorador de archivos y seleccionar un
	/**
	 * Metodo Cargar archivo
	 *
	 * @return the string
	 */
	// .txt para cargar
	public static String cargar() {
		Scanner entrada = null;
		JFileChooser fileChooser = new JFileChooser(directorio);
		fileChooser.showOpenDialog(fileChooser);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("archivo de texto", "txt", "text");
		fileChooser.setFileFilter(filter);
		String ruta = "";
		try {
			ruta = fileChooser.getSelectedFile().getAbsolutePath();
			File f = new File(ruta);
			entrada = new Scanner(f);
			System.out.println("Ha elegido el archivo de nombre: " + f.getName());
			System.out.println("Ruta absoluta: " + f.getAbsolutePath());
			System.out.println("Contenido del archivo...");
			System.out.println();
			while (entrada.hasNext()) {
				System.out.println(entrada.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningún fichero");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
		return ruta;
	}

	/**
	 * Metodo Guardar archivo.
	 *
	 * @param archivo the archivo
	 */
	// Método para guardar un archivo usando el explorador de archivos
	public static void guardar(String archivo) {
		JFileChooser jF1 = new JFileChooser(directorio);
		String ruta = "";
		try {
			if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
				ruta = jF1.getSelectedFile().getAbsolutePath();
				ruta = ruta.endsWith(".txt") ? "" : ruta + ".txt";
				FileWriter fileWriter=new FileWriter(ruta);
				BufferedWriter br = new BufferedWriter(fileWriter);
				br.write(archivo);
				br.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo Generar ciudad.
	 */
	public static void generarCiudad() {
		
		System.out.println("Introduce la dimensión de la ciudad");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nº Avenidas");
		int avenidas = sc.nextInt();
		System.out.println("Nº Calles");
		int calles = sc.nextInt();
		System.out.println("Seleccione el caso");
		System.out.println("1. Mejor caso");
		System.out.println("2. Caso Lineal Inverso");
		System.out.println("3. Caso Lineal Normal");
		System.out.println("4. Caso Valor Constante");
		System.out.println("5. Caso Valores Adaptados a Campana de Gauss");
		int caso = sc.nextInt();
		System.out.println("Seleccione numero de dias");
		int dias = sc.nextInt();
		System.out.println("Tamaño del distrito por avenidas");
		int d1 = sc.nextInt();
		System.out.println("Tamaño del distrito por calles");
		int d2 = sc.nextInt();

		Distrito d = new Distrito(avenidas, calles);
		for(int i = 0; i < dias; i++) {
			rellenar(d, dias, caso);
		}
		Ciudad c = new Ciudad(avenidas, calles, dias, d, caso);
		guardar(c.toStringGenerarCiudad());
	}

	/**
	 * Metodo Rellenar.
	 *
	 * @param d the d
	 * @param dias the dias
	 * @param caso the caso
	 */
	public static void rellenar(Distrito d, int dias, int caso) {
		switch (caso) {
		case 1:
			Casos.caso1(d, dias);
			break;
		case 2:
			Casos.caso2(d, dias);
			break;
		case 3:
			Casos.caso3(d, dias);
			break;
		case 4:
			Casos.caso4(d, dias);
			break;
		case 5:
			Casos.caso5(d, dias);
			break;
		}
	}
	
	/**
	 * Función de Gauss.
	 *
	 * @param x el valor de tiempo dia
	 * @param a la altura de la campana de gauss
	 * @param b la posicion central de la campana
	 * @param c la anchura de la campana
	 * @return the int
	 */
	public static int gauss(int x, int a, int b, int c) {
		return (int)(a*Math.pow(Math.E, -(Math.pow(x-b, 2)/(2*Math.pow(c, 2)))));
	}

}

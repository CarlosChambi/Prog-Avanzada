import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EntradaSalida {

	// CONSTANTES.
	final static String rutaArchivosIn = "archivosIN/";
	final static String rutaArchivosOut = "archivosOUT/";

//	public static void main(String[] args) throws IOException {
//
//		 System.out.println(leerArchivoNumerosConScanner("pruebaRandom.in"));
//		 escrituraDeArchivo("pruebaRandom.in");
//
//		leerYCrearArchivo("pruebaRandom.in", "pruebaSalida.out");
//
//	}
//
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	public static int leerArchivoNumerosConScanner(String nombreArchivo) throws FileNotFoundException {
//
//		Scanner entrada = new Scanner(new File(rutaArchivosIn + nombreArchivo));
//		int suma = 0;
//		int maximo = 0;
//		int minimo = 0;
//		int cant = 0;
//		int actual;
//		int bandera = 1;
//		
//
//		while (entrada.hasNext()) {// Mientras existan datos en el archivo.
//
//			actual = entrada.nextInt();
//
//			if (bandera == 1)
//				minimo = actual;
//
//			if (actual > maximo)
//				maximo = actual;
//
//			if (actual < minimo)
//				minimo = actual;
//
//			suma += actual;// Leer el número entero.
//			cant++;
//			bandera = 0;
//		}
//
//		entrada.close();
//
//		int promedio = suma / cant;
//
//		System.out.println("Maximo: " + maximo);
//		System.out.println("Minimo: " + minimo);
//		System.out.println("Promedio: " + promedio);
//
//		return suma;
//
//	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void escrituraDeArchivo(String nombreArchivo) throws IOException {

		FileWriter archivo = new FileWriter(rutaArchivosOut + nombreArchivo);
		PrintWriter pw = new PrintWriter(archivo);

		int bandera = 0;

		while (bandera < 12000) {

			int numero = (int) (Math.random() * 12001);

			pw.println(numero);

			bandera++;
		}

		archivo.close();

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void leerYCrearArchivo(String nombreArchivoDeLectura, String nombreArchivoDeEscritura) throws IOException {

		// Lectura del archivo

		Scanner entrada = new Scanner(new File(rutaArchivosIn + nombreArchivoDeLectura));

		int suma = 0;
		int maximo = 0;
		int minimo = 0;
		int cant = 0;
		int actual;
		int bandera = 1;

		// Cálculo de Max, Min y Promedio

		while (entrada.hasNext()) {

			actual = entrada.nextInt();

			if (bandera == 1)
				minimo = actual;

			if (actual > maximo)
				maximo = actual;

			if (actual < minimo)
				minimo = actual;

			suma += actual;
			cant++;
			bandera = 0;
		}

		entrada.close();

		int promedio = suma / cant;
		
		//Escritura del archivo

		FileWriter archivo = new FileWriter(rutaArchivosOut + nombreArchivoDeEscritura);
		PrintWriter pw = new PrintWriter(archivo);

		String cadena = new String("+----------+-------+");

		pw.println(cadena);

		pw.printf("| Máximo   | %5d |", maximo);

		pw.println();
		pw.println(cadena);

		pw.printf("| Minimo   | %5d |", minimo);

		pw.println();
		pw.println(cadena);

		pw.printf("| Promedio | %5d |", promedio);

		pw.println();
		pw.print(cadena);

		archivo.close();
	}

}

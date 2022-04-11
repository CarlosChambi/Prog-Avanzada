
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
//
//public class pruebas {
//
//	public static void main(String[] args) {
//		try {
//			FileWriter fwIn = new FileWriter("Numeros.txt");
//			BufferedWriter bwIn = new BufferedWriter(fwIn);
//			
//			int limite = (int)(Math.random()*10000) + 10000;
//			for(int i = 0; i < limite; i++) 
//				bwIn.write((int)(Math.random()*12000) + "\n");
//			
//			bwIn.close();
//			
//			FileReader fr = new FileReader("Numeros.txt");
//			BufferedReader br = new BufferedReader(fr);
//			
//			String linea;
//			int num;
//			int max = 0;
//			int min = 12001;
//			int suma = 0;
//			
//			while((linea = br.readLine()) != null) {				
//				if(max < (num = Integer.parseInt(linea))) 
//					max = num;				
//				else if(min > num)
//					min = num;
//				
//				suma += num;
//			}	
//			br.close();
//
//			FileWriter fwOut = new FileWriter("Resultados.txt");
//			BufferedWriter bwOut = new BufferedWriter(fwOut);
//			
//			bwOut.write("+----------+-------+\n");
//			bwOut.write(String.format("| %-8s |%6d |\n", "Máximo", max));			
//			bwOut.write("+----------+-------+\n");
//			bwOut.write(String.format("| %-8s |%6d |\n", "Mínimo", min));			
//			bwOut.write("+----------+-------+\n");			
//			bwOut.write(String.format("| %-8s |%6d |\n", "Promedio", suma/limite));			
//			bwOut.write("+----------+-------+");
//			
//			bwOut.close();						
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//	}
//}
import java.util.Scanner;

public class pruebas {

	public static void main(String[] args) {
		int[] loteDePrueba = prepararLoteDePrueba();
		Archivo arch = new Archivo("numeros");
		arch.guardarArchivo(loteDePrueba);
		int[] numeros = arch.leerArchivo();
		int[] procesado = procesarNumeros(numeros);
		arch.grabarProcesado(procesado);
	}

	static int[] prepararLoteDePrueba() {
		int cantidadNumeros = enteroAleatorio(10000, 20000);
		int[] numeros = new int[cantidadNumeros];

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = enteroAleatorio(0, 12000);
		}
		return numeros;
	}

	static int enteroAleatorio(int nMenor, int nMayor) {
		return (int) Math.floor(Math.random() * (nMayor - nMenor + 1) + nMenor);
	}

	static int[] procesarNumeros(int[] numeros) {
		int max, min, acum;
		max = numeros[0];
		min = numeros[0];
		acum = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > max)
				max = numeros[i];
			if (numeros[i] < min)
				min = numeros[i];
			acum += numeros[i];
		}
		acum /= numeros.length;
		int[] procesado = { max, min, acum };
		return procesado;
	}

}

//CLASE ARCHIVO
public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public int[] leerArchivo() {
		Scanner arch = null;
		int[] datos = new int[20000];
		int cantE = 0;
		int[] datosReales;
		try {
			arch = new Scanner(new File("archivos/in/" + this.nombre + ".in"));
			arch.useLocale(Locale.ENGLISH);
			while (arch.hasNextInt()) {
				datos[cantE] = arch.nextInt();
				cantE++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
		datosReales = new int[cantE];
		for (int i = 0; i < datosReales.length; i++) {
			datosReales[i] = datos[i];
		}
		return datosReales;
	}

	public void guardarArchivo(int[] datos) {
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("archivos/in/" + this.nombre + ".in");
			pw = new PrintWriter(archivo);
			for (int i = 0; i < datos.length; i++) {
				pw.println(datos[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void grabarProcesado(int[] datos) {
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("archivos/out/" + this.nombre + ".out");
			pw = new PrintWriter(archivo);
			pw.println("+----------+-------+");
			pw.printf("| Máximo   |%6d |\n", datos[0]);
			pw.println("+----------+-------+");
			pw.printf("| Mínimo   |%6d |\n", datos[1]);
			pw.println("+----------+-------+");
			pw.printf("| Promedio |%6d |\n", datos[2]);
			pw.println("+----------+-------+");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
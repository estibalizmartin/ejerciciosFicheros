package ficheros;

import java.io.*;

public class EscribirFichero {

	public static void main(String[] args) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("C:\\trastero\\prueba2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw = new PrintWriter(fichero);
		
		pw.println("hola guapa");
		
		pw.close();
		
		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package ficheros;

import java.io.*;

public class LeerFichero {

	public static void main(String[] args) {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		archivo = new File ("C:\\trastero\\prueba1.txt");
		try {
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		
		String linea = null;
		try {
			while((linea=br.readLine()) != null){
			System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practica15 {

	private static Scanner scanner = null;
	 
	private static final String NOMBRE_FICHERO = "diario.txt";
	private static final String RUTA_FICHERO = "c://Trastero//";
	
	public Practica15() {
		scanner = new Scanner(System.in);
	}
	
	public static void iniciar() {

		int opcion = 0;
		do {
			opcion = opcionMenu();
			if (opcion != 0) {
				ejecutarOpcionMenu(opcion);
				System.out.println("");
			}
		} while (opcion != 0);
		System.out.print("¡Adiós!");
		
	}

	private static int opcionMenu() {
		int ret = 0;
		do {
			try {
				escribirMenu();
				System.out.print("Elige una opción: ");
				ret = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				scanner.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > 6));
		return ret;
	}

	private static void escribirMenu() {
		System.out.println("---- MENÚ DE PEDIDOS DE COMPRA ----");
		System.out.println("");
		System.out.println("0. Salir");  
		System.out.println("1. AÑADIR un pedido"); 
		System.out.println("2. MOSTRAR todos los pedidos"); 
		System.out.println("3. MODIFICAR un pedido"); 
		System.out.println("4. BORRAR fichero"); 
		System.out.println("5. NUEVO fichero"); 
		System.out.println("");
		System.out.println("--------------");
	}
	
	private static void ejecutarOpcionMenu(int opcion) {
		switch (opcion) {
		case 1:
			agregarPedido();
			break;
		case 2:
			mostrarAllPedidos();
			break;
		case 3:
			modificarFichero();
			break;
		case 4:
			borrarFichero();
			break;
		case 5:
			nuevoFichero();
			break;
		}
	}

	private static void agregarPedido() {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("C:\\trastero\\Practica15\\listaPedidos.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw = new PrintWriter(fichero);
		
		System.out.println("");
		System.out.println("Añadiendo un nuevo producto...");
		System.out.print("Producto: ");
		String producto = scanner.nextLine();
		System.out.print("Cantidad: ");
		int cantidad = scanner.nextInt();
		
		pw.println("Producto: " + producto + " | Cantidad: " + cantidad);
		
		try {
			fichero.close();
			System.out.println("Producto añadido.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void mostrarAllPedidos() {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		archivo = new File ("C:\\trastero\\Practica15\\listaPedidos.txt");
		
		System.out.println("");
		System.out.println("      Lista de pedidos");
		System.out.println("----------------------------");
		
		try {
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		
		String linea = null;
		try {
			while((linea=br.readLine()) != null){
			System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
				
	}
	
	private static void modificarFichero() {
		// TODO Auto-generated method stub
		
	}

	private static void borrarFichero() {
		
		boolean borradoCheck = false;
		File archivo = null;
		archivo = new File ("C:\\trastero\\Practica15\\listaPedidos.txt");
		
		while(!borradoCheck) {
			System.out.println("");
			System.out.print("¿Desea borrar el fichero de pedidos? (S/N): ");
			String ficheroBorrar = scanner.nextLine();
			
			if (ficheroBorrar.equalsIgnoreCase("S")) {
				try {
					if (archivo.delete()) {
						System.out.println("Fichero eliminado correctamente.");
					} else {
						System.out.println("Este fichero no existe.");
					}
				} catch (Exception e) {
					System.out.println("Error de borrado del fichero"); 
					e.printStackTrace();
					borradoCheck = false;
				}
				borradoCheck = true;
			} else if(ficheroBorrar.equalsIgnoreCase("N")) {
				System.out.println("");
				System.out.println("Volviendo al menú inicial...");
				System.out.println("");
				borradoCheck = true;
			} else {
				System.out.println("");
				System.out.print("Elige una opción válida: ");
				ficheroBorrar = scanner.nextLine();
			}
		}
		
		
	}

	private static void nuevoFichero() {

		System.out.println("");
		System.out.println("Creando un nuevo fichero...");
		System.out.print("Nombre: ");
		String nuevoFichero = scanner.nextLine();
		nuevoFichero = "C:\\trastero\\Practica15\\" + nuevoFichero + ".txt";
		
		File archivo = new File(nuevoFichero);
		
		try {
			if(archivo.createNewFile()) {
				System.out.println("Archivo creado.");
			} else {
				System.out.println("El fichero ya existe.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		iniciar();
		
	}

}

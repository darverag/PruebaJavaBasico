package servicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Importador {
	Scanner sc = new Scanner(System.in);

	@Override
	public void cargarDatos(String fileName1, List<Cliente> listaClientes) {

		System.out.println("----------Cargar Datos en Windows---------\n");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
		System.out.println("Ejemplo ingresar: src/descargaClientes");
		String archivo = sc.nextLine();
		System.out.println("--------------------------------------------------------");

		try {
				FileReader archivoReader = new FileReader(archivo + "/" + "/" + fileName1);
			    BufferedReader archivoBuffered = new BufferedReader(archivoReader);
			    
			    String lineaArchivo = archivoBuffered.readLine();
			    
			    while (lineaArchivo != null) {
			    	String[] elemento = lineaArchivo.split(",");
			    	
			    	Cliente clienteTemp = new Cliente(elemento[0], elemento[1], elemento[2], elemento[3],
						CategoriaEnum.valueOf(elemento[4].toUpperCase()));
			    		lineaArchivo = archivoBuffered.readLine();
				
			    		listaClientes.add(clienteTemp);
			    		
			}
			archivoBuffered.close();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Archivo NO encontrado");
		} catch (IOException ioe) {
			System.out.println("Error en el ingreso de la información");
		}
		System.out.println("Descarga de datos realizada correctamente en la lista!!");
		System.out.println("-------------------------------------------------------\n");
	}

	
	/*@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub

	}*/

}

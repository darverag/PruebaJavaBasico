package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {
	Scanner sc = new Scanner(System.in);

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
	

		String path = "src/";

		System.out.println("\n-------Exportar datos en Windows-------");
		System.out.println("Ingrese ruta en donde desea exportar el archivo Clientes.csv");
		System.out.println("Ejemplo: exportaClientes/Clientes.csv");
		String ruta = sc.nextLine();
		System.out.println("-------------------------------------------------------------");

		File directorio = new File(path + ruta);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}

			try {
				File archivo = new File(directorio + fileName);
				if (!archivo.exists()) {
					archivo.createNewFile();
				}
				
				FileWriter archivoWriter = new FileWriter(archivo);
				PrintWriter printWriter = new PrintWriter(archivoWriter);

				for (Cliente cliente : listaClientes) {
					String lineaCliente = cliente.getRunCliente() + ";" + cliente.getNombreCliente() + ";"
							+ cliente.getApellidoCliente() + ";" + cliente.getAniosCliente() + ";"
							+ cliente.getNombreCategoria();
					printWriter.write(lineaCliente);
					printWriter.println();
				}
				printWriter.close();
			} catch (IOException e) {
				System.out.println("No se pudo crear el archivo");
			}
			System.out.println("Datos de clientes exportados correctamente en formato.csv\n");
			System.out.println("---------------------------------------------------------\n");
		}
	}
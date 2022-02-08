package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {
	
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv= new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	private Utilidad utilidades = new Utilidad();
	
	String fileName ="Clientes";
	String fileName1= "DBClientes.csv";
	
	Scanner sc = new Scanner  (System.in);
	

	@Override
	public void listarClientes() {
		
		clienteServicio.retornolistarClientes();
		
		System.out.println();
		
	}

	@Override
	public void agregarCliente() {
		
		@SuppressWarnings("unused")
		// Se crea cliente nuevo
		Cliente agregadoCliente = new Cliente();
		
		/*-------------Datos del Cliente-------------
		RUN del Cliente: 12.123.412-2
		Nombre del Cliente: Nicolas
		Apellido del Cliente: Cake
		Años como Cliente: 7 años
		Categoría del Cliente: Activo
		-------------------------------------------
		-------------Datos del Cliente-------------
		RUN del Cliente: 25.673.022-2
		Nombre del Cliente: Taylor
		Apellido del Cliente: Shift S.
		Años como Cliente: 1 día
		Categoría del Cliente: Activo*/
		
		// Esta es la información necesaria para poder crear un cliente
		
		System.out.println("--------Crear Cliente--------\n");
		System.out.println("Ingresa RUN del Cliente: ");
		System.out.println("Asegurate de ingresarlo con puntos y con guión");
		String run = sc.nextLine();
		
		
		while(run.isEmpty()) {
			System.out.println("No es posible dejar datos nulos");
			System.out.println("Ingrese nuevamente el RUN del Cliente");
			System.out.println("Asegurate de ingresarlo con puntos y con guión");
			run =sc.nextLine();
		}
		
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre = sc.nextLine();
		
		while(nombre.isEmpty()) {
			System.out.println("No es posible dejar datos nulos");
			System.out.println("Ingrese nuevamente el Nombre del Cliente");
			nombre = sc.nextLine();
		}
				
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido = sc.nextLine();
		
		while(apellido.isEmpty()) {
			System.out.println("No es posible dejar datos nulos");
			System.out.println("Ingrese nuevamente el Apellido del Cliente");
			apellido = sc.nextLine();
		}
				
		System.out.println("Ingresa años como Cliente: ");
		String anios = sc.nextLine();
		
		while(anios.isEmpty()) {
			System.out.println("No es posible dejar datos nulos");
			System.out.println("Ingrese nuevamente los años como Cliente");
			anios = sc.nextLine();
		}
		System.out.println("\nInformación ingresada con éxito!!!");
		System.out.println("-------------------------------\n");

		
		// Se utiliza clienteServicio para pasarle los datos del cliente agregado
		clienteServicio.agregarCliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		
		
	}

	@Override
	public void editarCliente() {
				
		// Información solicitada a cliente para edición de datos
		
				System.out.println("-------------Editar Cliente-------------");
				System.out.println("Seleccione qué desea hacer:             ");
				System.out.println("1.- Cambiar el estado del Cliente       ");
				System.out.println("2.- Editar los datos del Cliente      \n");
				System.out.println("Ingrese opción:                         ");
				System.out.println("--------------------------------------\n");
				int opcion = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Ingrese RUN del Cliente a editar:      ");
				System.out.println("Asegurate de ingresarlo con puntos y con guión");
				String runEditar = sc.nextLine();
				System.out.println();
				
				for(Cliente clienteEditado: clienteServicio.getListaClientes()) {
					if(clienteEditado.getRunCliente().equals(runEditar)) {
						
						if (opcion == 1) {
							System.out.println("-----Actualizando estado del Cliente------");
							System.out.println("El estado actual es: " + clienteEditado.getNombreCategoria());
							System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
							System.out.println("2.- Si desea mantener el estado del Cliente Activo \n");
							System.out.println("Ingrese opción:                                      ");
							System.out.println("-----------------------------------------------------");
							int opEditar = sc.nextInt();
							sc.nextLine();
							
							
							switch (opEditar) {
							case 1:
								clienteEditado.setNombreCategoria(CategoriaEnum.INACTIVO);
								System.out.println("El cambio fue realizado con éxito");
								System.out.println("El nuevo estado del Cliente es: " + CategoriaEnum.INACTIVO);
								System.out.println();
								break;
							case 2:
								clienteEditado.setNombreCategoria(CategoriaEnum.ACTIVO);
								System.out.println("El estado del Cliente se mantiene en " + CategoriaEnum.ACTIVO);
								System.out.println();
								break;

							default:
								break;
							}
							
						} else if (opcion == 2) {
							System.out.println("----Actualizando datos del Cliente----\n");
							System.out.println("1.- El RUN del Cliente es: " + clienteEditado.getRunCliente());
							System.out.println("2.- El Nombre del Cliente es: " + clienteEditado.getNombreCliente());
							System.out.println("3.- El Apellido del Cliente es: " + clienteEditado.getApellidoCliente());
							System.out.println("4.- Los años como Cliente son: " + clienteEditado.getAniosCliente());
							System.out.println();

							System.out.println("Ingrese opción a editar de los datos del Cliente: ");
							System.out.println("------------------------------------------------\n");
							int opcionEditar = sc.nextInt();
							sc.nextLine();
							System.out.println();
							
							switch (opcionEditar) {
							case 1:
								System.out.println("Ingrese nuevo RUN del Cliente");
								System.out.println("Asegurate de ingresarlo con puntos y con guión");
								String nuevoRun = sc.nextLine();
								
								while(nuevoRun.isEmpty()) {
									System.out.println("No es posible dejar datos nulos");
									System.out.println("Ingrese nuevamente RUN del Cliente");
									System.out.println("Asegurate de ingresarlo con puntos y con guión");
									nuevoRun = sc.nextLine();
								}
								
								clienteEditado.setRunCliente(nuevoRun);
								System.out.println("-------------------------------------------");
								System.out.println("El cambio fue realizado con éxito\nEl nuevo RUN ingresado corresponde a " + nuevoRun);
								System.out.println("--------------------------------------------\n");
								break;
							case 2:
								System.out.println("Ingrese nuevo Nombre del Cliente");
								String nuevoNombre = sc.nextLine();
								
								while(nuevoNombre.isEmpty()) {
									System.out.println("No es posible dejar datos nulos");
									System.out.println("Ingrese nuevamente el Nombre del Cliente");
									nuevoNombre = sc.nextLine();
								}
								
								clienteEditado.setNombreCliente(nuevoNombre);
								System.out.println("-------------------------------------------");
								System.out.println(
										"El cambio fue realizado con éxito\nEl nuevo Nombre ingresado corresponde a "+ nuevoNombre);
								System.out.println("-------------------------------------------\n");
								break;
							case 3:
								System.out.println("Ingrese nuevo Apellido del Cliente");
								String nuevoApellido = sc.nextLine();
								
								while(nuevoApellido.isEmpty()) {
									System.out.println("No es posible dejar datos nulos");
									System.out.println("Ingrese nuevamente el Apellido del Cliente");
									nuevoApellido = sc.nextLine();
								}
								
								clienteEditado.setApellidoCliente(nuevoApellido);
								System.out.println("-------------------------------------------");
								System.out.println(
										"El cambio fue realizado con éxito\nEl nuevo Apellido ingresado corresponde a "+ nuevoApellido);
								System.out.println("-------------------------------------------\n");
								break;
							case 4:
								System.out.println("Ingrese los nuevos años como Cliente");
								String nuevoAnio = sc.nextLine();
								
								while(nuevoAnio.isEmpty()) {
									System.out.println("No es posible dejar datos nulos");
									System.out.println("Ingrese nuevamente los años como Cliente");
									nuevoAnio = sc.nextLine();
								}
								
								clienteEditado.setAniosCliente(nuevoAnio);
								System.out.println("-------------------------------------------");
								System.out.println(
										"El cambio fue realizado con éxito\nLos nuevos años corresponden a " + nuevoAnio);
								System.out.println("-------------------------------------------\n");
								break;

							default:
								break;
							}
				}		
			}
		}
	}
				


	@Override
	public void cargarDatos() {
		
		archivoServicio.cargarDatos(fileName1, clienteServicio.getListaClientes());
	}

	@Override
	public void exportarDatos() {
		// Información solicitada a cliente para comenzar exportacion de datos

				System.out.println("------------Exportar Datos----------------");
				System.out.println("Seleccione el formato a exportar:         ");
				System.out.println("1.- Formato csv");
				System.out.println("2.- Formato txt \n");
				System.out.println("Ingrese una opción para exportar");
				System.out.println("------------------------------------------");
				int opcion = sc.nextInt();
				sc.nextLine();
				
				if (opcion == 1) {

					exportadorCsv.exportar(fileName, clienteServicio.getListaClientes());

				} else {
					if (opcion == 2) {

						exportadorTxt.exportar(fileName, clienteServicio.getListaClientes());

					}
				}
			}

		

	@Override
	public void terminarPrograma() {
		Utilidad.tiempoEspera();
		Utilidad.printLine("Gracias por usar nuestro sistema, hasta pronto!!");
		Utilidad.limpiarPantalla();
		System.exit(0);
	}
	
	public void iniciarMenu() {

		int seleccion = 0;
		
		System.out.println();
		System.out.println("                                         ");
		System.out.println("      Bienvenido al Sistema de Control   ");
		System.out.println("            y Gestión de Clientes        ");
		System.out.println("           Pastelería Bon Bon Jovi       ");
		System.out.println("                                         ");
		System.out.println();

		try {
			do {

				System.out.println("1. Listar Clientes\n" + "2. Agregar Cliente\n" + "3. Editar Cliente\n"
						+ "4. Cargar Datos\n" + "5. Exportar Datos\n" + "6. Salir\n");

				System.out.println("Ingrese una opción: ");
				seleccion = sc.nextInt();
				sc.nextLine();

				switch (seleccion) {
				case 1:
					listarClientes();
					Utilidad.tiempoEspera();
					break;
				case 2:
					agregarCliente();
					Utilidad.tiempoEspera();
					break;
				case 3:
					editarCliente();
					Utilidad.tiempoEspera();
					break;
				case 4:
				    cargarDatos();
				    Utilidad.tiempoEspera();
					break;
				case 5:
					exportarDatos();
					Utilidad.tiempoEspera();
					break;
				case 6:
					terminarPrograma();// Salir
					break;
				default:
					System.out.println("La opción ingresada NO es válida, saliendo del sistema...");
					break;
				}
			} while (seleccion >= 1 && seleccion <= 5);
		} catch (InputMismatchException ime) {
			System.out.println("¡Error en el ingreso de información, solo ingrese números!..");
		}
	}

}


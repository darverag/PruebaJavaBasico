package main;

import vista.Menu;
import vista.MenuTemplate;

/*
 * Orden
 * 
 * [X] Creaci�n (Main, Cliente y CategoriaEnum)
 * [X] Creaci�n de MenuTemple
 * [X] Creaci�n de Menu
 * [X] Creaci�n de Utilidad
 * [X] Creaci�n de ClienteServicio 
 * [X] Creaci�n de ArchivoServicio
 * [X] Creaci�n de Exportador, ExportadorCsv, ExportadorTxt, Importador
 * [X] Creaci�n de ClienteServicioTest
 */


public class Main {

	public static void main(String[] args) {
			
		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}

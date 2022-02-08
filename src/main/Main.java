package main;

import vista.Menu;
import vista.MenuTemplate;

/*
 * Orden
 * 
 * [X] Creación (Main, Cliente y CategoriaEnum)
 * [X] Creación de MenuTemple
 * [X] Creación de Menu
 * [X] Creación de Utilidad
 * [X] Creación de ClienteServicio 
 * [X] Creación de ArchivoServicio
 * [X] Creación de Exportador, ExportadorCsv, ExportadorTxt, Importador
 * [X] Creación de ClienteServicioTest
 */


public class Main {

	public static void main(String[] args) {
			
		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}

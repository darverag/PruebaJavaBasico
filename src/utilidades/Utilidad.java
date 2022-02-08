package utilidades;

public class Utilidad {

	public  static void limpiarPantalla() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");

		}
	}

	public static void tiempoEspera () {
		try {
			Thread.sleep(3500);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void printLine (String mensaje) {
		System.out.println(mensaje);
	}

}

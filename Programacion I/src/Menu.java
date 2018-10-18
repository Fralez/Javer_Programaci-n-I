public class Menu {
	
	public static void displayMenu(String etiqueta, String[] asignaturas) {		

		//En este método se imprime el menú en la consola
		Custom.printMensaje("Bienvenido al gestor de alumnos Javer!");
		
		boolean menu = true;
		while (menu) {
			Custom.printMensaje("¿Cómo puedo ayudarle?");
			Custom.printMensaje("1 - Ingresar nueva clase y datos de los alumnos");
			Custom.printMensaje("2 - Opción 2");
			Custom.printMensaje("3 - Opción 3");
			Custom.printMensaje("0 - Salir");
			String opcion = Custom.scanStringInput();
			
			switch (opcion) {
				case "1":
					String[][] opcion1 = Opciones.opcionUno(etiqueta, asignaturas);
					break;
				case "2":
					String[][] opcion2 = Opciones.opcionDos(etiqueta, asignaturas);
					break;
				case "3":
					Opciones.opcionTres(etiqueta);
					break;
				case "0":
					menu = false;
					Custom.printMensaje("Vuelva Pronto! :D");
					break;
	
				default:
					Custom.printMensaje("Ese opción no es correcta, por favor, seleccione otra");
					break;
			}
		}
	}
	
}
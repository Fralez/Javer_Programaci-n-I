public class Menu {
	
	public static void displayMenu() {
		//En este método se imprime el menú en la consola
		Custom.printMensaje("Bienvenido al gestor de alumnos Javer!");
		
		boolean menu = true;
		while (menu) {
			Custom.printMensaje("¿Cómo puedo ayudarle?");
			Custom.printMensaje("1 - Opción 1");
			Custom.printMensaje("2 - Opción 2");
			Custom.printMensaje("3 - Opción 3");
			Custom.printMensaje("0 - Salir");
			String opcion = Custom.scanStringInput();
			
			switch (opcion) {
				case "1":
					Opciones.opcionUno();
					break;
				case "2":
					Opciones.opcionDos();
					break;
				case "3":
					Opciones.opcionTres();
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
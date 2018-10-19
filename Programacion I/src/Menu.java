public class Menu {
	
	public static void displayMenu(String etiqueta, String[][] asignaturas) {		

		//En este método se imprime el menú en la consola
		Custom.printMensaje("Bienvenido al gestor de alumnos Javer!");
		
		boolean menu = true;
		while (menu) {
			Custom.printMensaje("¿Cómo puedo ayudarle?");
			Custom.printMensaje("1 - Ingresar nueva clase y datos de los alumnos");
			Custom.printMensaje("2 - Ingresar datos según tu título");
			Custom.printMensaje("3 - Listar datos y mostrar promedios y fallos");
			Custom.printMensaje("0 - Salir");
			String opcion = Custom.scanStringInput();
			
			boolean entroOpcion1 = false;
			boolean entroOpcion2 = false;
			String[][] opcion1 = {};
			String[][][] opcion2 = {};
			
			switch (opcion) {
				case "1":
					entroOpcion1 = true;
					opcion1 = Opciones.opcionUno(etiqueta, asignaturas);
					break;
				case "2":
					entroOpcion2 = true;
					opcion2 = Opciones.opcionDos(etiqueta, asignaturas);
					break;
				case "3":
					if (entroOpcion1 || entroOpcion2) {
						Opciones.opcionTres(opcion1, opcion2);
					} else {
						Custom.printMensaje("Para entrar a esta opción debe al menos haber entrado a una de las otras dos!!");
					}
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
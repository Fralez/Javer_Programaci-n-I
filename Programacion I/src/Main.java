public class Main {

	public static void main(String[] args) {
		
		// Primero, declaramos las asignaturas de primer año
		String[] asignaturas = { "Programación", "Introducción", "Lógica", "Inglés", "Historia", "Geometría",
								 "Biología", "SistemasOperativos", "Física", "TallerMantenimiento", "Electricidad", "Matemática",
								 "APT" };
		
		String[][] usuariosRegistrados = Setup.MatrizUsuariosRegistrados(); // Este método crea la matriz de usuarios
																			// registrados
		String usuario = Log.In(usuariosRegistrados); // Acá guardamos el resultado del logIn

		// Si el logIn fue exitoso
		if (usuario.length() > 0) {
			Menu.displayMenu(usuario, asignaturas); // Muestra el menú y empieza el programa
		}
		
	}

}
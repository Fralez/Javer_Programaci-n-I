public class Main {

	public static void main(String[] args) {
		
		// Primero, declaramos las asignaturas de primer año
		String[][] asignaturas = { {"Programación", "2"}, {"Computación", "2"}, {"Lógica", "2"}, {"Inglés", "3"}, {"Historia", "3"},
								   {"Geometría", "3"}, {"Biología", "3"}, {"SistemasOperativos", "2"}, {"Física", "3"},
								   {"TallerMantenimiento", "4"},{"Electricidad", "3"}, {"Matemática", "3"}, {"APT", "3"} };
		
		String[][] usuariosRegistrados = Setup.MatrizUsuariosRegistrados(); // Este método crea la matriz de usuarios registrados
		
		String usuario = Log.In(usuariosRegistrados); // Acá guardamos el resultado del logIn

		// Si el logIn fue exitoso
		if (usuario.length() > 0) {
			Menu.displayMenu(usuario, asignaturas); // Muestra el menú y empieza el programa
		}
		
	}

}
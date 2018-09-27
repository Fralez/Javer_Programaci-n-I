public class Main {

	public static void main(String[] args) {
		
		String[][] usuariosRegistrados = Setup.MatrizUsuariosRegistrados(); //Este método crea la matriz de usuarios registrados
		boolean logIn = Log.In(usuariosRegistrados);
		
		//Si el logIn fue exitoso
		if(logIn) {
			Menu.displayMenu(); //Muestra el menú y empieza el programa
		}
	}

}
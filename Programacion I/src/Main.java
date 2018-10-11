public class Main {

	public static void main(String[] args) {
		
		String[][] usuariosRegistrados = Setup.MatrizUsuariosRegistrados(); //Este método crea la matriz de usuarios registrados
		String usuario = Log.In(usuariosRegistrados); //Acá guardamos el resultado del logIn
		
		//Si el logIn fue exitoso
		if(usuario.length() > 0) {
			Menu.displayMenu(); //Muestra el menú y empieza el programa
		}
	}

}
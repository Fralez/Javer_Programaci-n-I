
public class Matrix {
	
	public static String[][] crearMatriz(int rows, int cols) {
		String[][] matriz = new String[rows][cols]; //Crea una matriz bidimensional de valores de tipo String
			
		//Retorna la matriz bidimensional que creó y llenó
		return matriz;
	}
	
	//Sub-método de Crear Matriz
	public static void llenarUsuario(String[][] matriz, int lugarDeUsuario, String usuario, String contraseña, String etiqueta) {
		
		//Itera sobre una matriz dada y asigna valores a esos lugares
		for(int i = 0; i < matriz[lugarDeUsuario].length; i++) {
			switch (i) {
				case 0:
					matriz[lugarDeUsuario][i] = usuario;
					break;
				case 1:
					matriz[lugarDeUsuario][i] = contraseña;
					break;
				case 2:
					matriz[lugarDeUsuario][i] = etiqueta;
					break;
			}
		}
	}

}
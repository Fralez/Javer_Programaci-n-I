
public class Setup {
	
	public static String[][] MatrizUsuariosRegistrados() {
		String[][] matriz = Matrix.crearMatriz(4, 3);
		
		//Itera sobre ellos y les da valores utilizando el sub-método "llenarUsuario"
		for(int i = 0; i < matriz.length; i++) {
			switch (i) {
				case 0:
					//Este usuario es especial, se utiliza para manejar las acciones root y tiene una etiqueta especial: Admin.
					Matrix.llenarUsuario(matriz, i, "root", "root", "Admin");
					break;
				case 1:
					Matrix.llenarUsuario(matriz, i, "FraqueDanilo", "fraquito123", "Profesor de Programación");					
					break;
				case 2:
					Matrix.llenarUsuario(matriz, i, "GonzálezFranco", "un12profePLS", "Adscripto");
					break;
				case 3:
					Matrix.llenarUsuario(matriz, i, "BonillaAndrés", "buñuelo456", "Profesor de Computación");
					break;
				default:
					//PD: Los usuarios registrados que vienen por defecto son los que se añaden aquí, si se quisiera esto se podría ampliar, pero no es requerido.
					break;
			}
		}
		return matriz;
	}
	
}
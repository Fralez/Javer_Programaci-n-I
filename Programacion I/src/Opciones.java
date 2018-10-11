//Working
public class Opciones {
	
	//OPCIÓN 1
	public static void opcionUno() {
		Custom.printMensaje("Ingresá el número de alumnos en la clase");
		int numAlumnos = Custom.scanIntInput();
		
		Matrix.crearMatriz(numAlumnos, 3);
		
		String materia = "";
		
		Custom.printMensaje("Ahora podrá crear una clase de la materia " + materia);
		Custom.printMensaje("Ahora, ingrese los nombres de los alumnos con el formato 'ApellidoNombre'.");
		
	}
	
	
	
	
	
	//OPCIÓN 2
	public static void opcionDos() {
		
	}
	
	
	
	
	
	//OPCIÓN 3
	public static void opcionTres() {
		
	}
	
}
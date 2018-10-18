//Working
public class Opciones {
	
	//OPCIÓN 1
	public static String[][] opcionUno(String etiqueta, String[] asignaturas) {
		
		String[][] alumnos = {}; //Se crean los alumnos como vacíos así el return no se buggea
		
		if (etiqueta.equals("Adscripto")) {
			
			Custom.printMensaje("Ingresá el número de alumnos en la clase");
			int numAlumnos = Custom.scanIntInput(); //Cantidad de alumnos
			int numMaterias = asignaturas.length; //Cantidad de materias
			alumnos = Matrix.crearMatriz(numAlumnos, numMaterias + 1); //Matriz de alumnos asignada, pendiente llenar
			
			Custom.printMensaje("Ahora, ingrese los nombres de los alumnos con el formato 'ApellidoNombre'.");
			
			Custom.printMensaje("Y la nota correspondiente del 1 al 12.");
			
			for (int i = 0; i < alumnos.length; i++) {
			
				Custom.printMensaje("Ingrese nombre:");
				String nombre = Custom.scanStringInput();
				alumnos[i][0] = nombre;
				
				for(int j = 1; j < alumnos[i].length; j++) { //Itera sobre las asignaturas del alumno //FUNCA
					System.out.println("Cantidad de materias: " + alumnos[i].length);
					int nota = 0; //Nota es 0 porque hay que inicializar la variable, pero nunca va a llegar en ese estado a llenar la array de alumnos
					boolean esBuenaNota = false; //Para verificar que la nota sea entre el 1 y el 12
					
					while(esBuenaNota == false) {
						
						Custom.printMensaje("Ingrese nota de la materia número " + j  + ":");
						nota = Custom.scanIntInput();
						
						if (nota > 12 || nota < 1) {
							System.out.println("Error, ingrese una buena nota");
						} else {
							String notaParseada = Integer.toString(nota);
							alumnos[i][j] = notaParseada;
							System.out.println("Nota de la materia numero" + j +  ": " + alumnos[i][j]);
							
							// llenarAlumno(alumnos,i, nombre, nota);
							esBuenaNota = true;
						}
					}
				}
				
			}
			
		} else {			
			System.out.println("Lo siento, solo adscriptos pueden ingresar a esta opción :/");
		}
		
		
		
		return alumnos;
	}
	
	
	
	
	
	//OPCIÓN 2
	public static String[][] opcionDos(String etiqueta, String[] asignaturas) {
		
		
		return null;
	}
	
	
	
	
	
	//OPCIÓN 3
	public static void opcionTres(String etiqueta) {
		
	}
	
}
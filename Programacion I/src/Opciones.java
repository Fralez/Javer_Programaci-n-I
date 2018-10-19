//Working
public class Opciones {
	
	//*********************************************************************************
	//									OPCIÓN 1
	//*********************************************************************************
	public static String[][] opcionUno(String etiqueta, String[][] asignaturas) {
		
		String[][] alumnos = {}; //Se crean los alumnos como vacíos así el return reacciona correctamente
		
		if (etiqueta.equals("Adscripto") || etiqueta.equals("Admin")){
			
			Custom.printMensaje("Bienvenido, Adscripto!");
			
			Custom.printMensaje("Ingresá el número de alumnos en la clase");
			int numAlumnos = Custom.scanIntInput(); //Cantidad de alumnos
			
			if (numAlumnos <= 0) {
			
				System.out.println("No podemos trabajar con " + numAlumnos + " alumnos :/");
			
			} else {
				int numMaterias = asignaturas.length; //Cantidad de materias (13)
				alumnos = Matrix.crearMatriz(numAlumnos, numMaterias + 1); //Matriz de alumnos asignada, pendiente llenar
				
				Custom.printMensaje("Ahora, ingrese los nombres de los alumnos con el formato 'ApellidoNombre'.");
				Custom.printMensaje("Y la nota correspondiente del 1 al 12.");
				Custom.printMensaje("------------");
				
				for (int i = 0; i < alumnos.length; i++) {
				
					Custom.printMensaje("Ingrese nombre:");
					String nombre = Custom.scanStringInput();
					alumnos[i][0] = nombre;
					
					for(int j = 1; j < alumnos[i].length; j++) { //Itera sobre las asignaturas del alumno
						System.out.println("Cantidad de materias: " + numMaterias);
						int nota = 0; //Nota es 0 porque hay que inicializar la variable, pero nunca va a llegar en ese estado a llenar la array de alumnos
						boolean esBuenaNota = false; //Para verificar que la nota sea entre el 1 y el 12
						
						while(esBuenaNota == false) {
							
							Custom.printMensaje("Ingrese nota de la materia " + asignaturas[j - 1][0]  + ":");
							nota = Custom.scanIntInput();
							
							if (nota > 12 || nota < 1) {
								System.out.println("Error, ingrese una buena nota");
							} else {
								String notaParseada = Integer.toString(nota);
								alumnos[i][j] = notaParseada;
								System.out.println("Nota de la materia numero " + j +  ": " + alumnos[i][j]);
								
								// llenarAlumno(alumnos,i, nombre, nota);
								esBuenaNota = true;
							}
						}
					}	
				}
			}
		} else {
			
			System.out.println("Lo siento, solo adscriptos pueden ingresar a esta opción :/");
		
		}
		
		
		return alumnos;
	}
	
	
	
	
	
	//*********************************************************************************
	//									OPCIÓN 2
	//*********************************************************************************
	public static String[][][] opcionDos(String etiqueta, String[][] asignaturas) {

		String[][][] alumnos = {}; //Se crean los alumnos como vacíos así el return reacciona correctamente
		
		//ADSCRIPTOS
		if (etiqueta.equals("Adscripto") || etiqueta.equals("Admin")) {
			
			Custom.printMensaje("Bienvenido, Adscripto!!");
			
			int numAlumnos = -1; //Se inicializa el número de alumnos
			
			while(numAlumnos <= 0) {
				Custom.printMensaje("Ingresá el número de alumnos en la clase");
				numAlumnos = Custom.scanIntInput(); //Cantidad de alumnos
				if (numAlumnos <= 0) {				
					System.out.println("No podemos trabajar con " + numAlumnos + " alumnos :/");
				}
			}
			
			int numMaterias = asignaturas.length; //Cantidad de materias (13)
			alumnos = Matrix.crearMatrizTri(numAlumnos, numMaterias + 1, 2); //Matriz de alumnos asignada, pendiente llenar (3ra dimensión de faltas semanales por materia)
			
			Custom.printMensaje("Ahora, ingrese los nombres de los alumnos con el formato 'ApellidoNombre', ");
			Custom.printMensaje("la nota correspondiente del 1 al 12.");
			Custom.printMensaje(" y las inasistencias semanales del alumno");
			Custom.printMensaje("------------");
			
			for (int i = 0; i < alumnos.length; i++) { //Itera sobre los alumnos
				
				Custom.printMensaje("Ingrese nombre:");
				String nombre = Custom.scanStringInput();
				alumnos[i][0][0] = nombre;
				
				
				System.out.println("Cantidad de materias: " + numMaterias);
				
				for(int j = 1; j < alumnos[i].length; j++) { //Itera sobre las asignaturas del alumno
					int nota = 0; //Nota es 0 porque hay que inicializar la variable, pero nunca va a llegar en ese estado a llenar la array de alumnos
					boolean esBuenaNota = false; //Para verificar que la nota sea entre el 1 y el 12
					boolean esFaltaCorrecta = false; //Para verificar que el rango de faltas sea acorde a la materia
					
					while(!esBuenaNota || !esFaltaCorrecta) {
						
						if (!esBuenaNota) { //Este if se coloca porque, si se ingresan mal las faltas, vuelva a pedir la nota, y eso no se quiere
							Custom.printMensaje("Ingrese nota de la materia " + asignaturas[j - 1][0]  + ":");
							nota = Custom.scanIntInput();
								
							if (nota > 12 || nota < 1) {
								Custom.printMensaje("Error, ingrese una nota correspondiente al rango establecido");
							} else {
								String notaParseada = Integer.toString(nota); //Se parsea porque se usan arrays de tipo String
								alumnos[i][j][0] = notaParseada; //Añade la nota
							
								esBuenaNota = true;
							}
						}
						
						if (esBuenaNota) { //Este if se coloca para que el algoritmo no se "saltee" pasos y ejecute esto antes de ingresar nota
							Custom.printMensaje("Ahora, ingrese las faltas semanales de la materia:");
							int faltas = Custom.scanIntInput();
							int faltasMax = Custom.validarFaltas(asignaturas[j - 1][0], asignaturas);
							if (faltas > faltasMax) { //Si las faltas ingresadas son ilógicas
								Custom.printMensaje("Es imposible que el alumno haya tenido esas faltas, ingrese datos adecuados");
								System.out.println("Faltas Máx. de " + asignaturas[j - 1][0] + ": " + faltasMax);
							
							} else {
								String faltasParseadas = Integer.toString(faltas); //Se parsea porque se usan arrays de tipo String
								alumnos[i][j][1] = faltasParseadas; //Añade las faltas
								esFaltaCorrecta = true;
							}
						}
						
					}
				}	
			}
			
		//PROFESORES
		} else {
			Custom.printMensaje("Bienvenido, Profe de " + etiqueta + "!!");
			
			int numAlumnos = -1; //Se inicializa el número de alumnos
			
			while(numAlumnos <= 0) {
				Custom.printMensaje("Ingresá el número de alumnos en la clase");
				numAlumnos = Custom.scanIntInput(); //Cantidad de alumnos
				if (numAlumnos <= 0) {				
					System.out.println("No podemos trabajar con " + numAlumnos + " alumnos :/");
				}
			}
			
			alumnos = Matrix.crearMatrizTri(numAlumnos, 2, 2); //Matriz de alumnos asignada, pendiente llenar (3ra dimensión de faltas semanales de la materia)
			
			Custom.printMensaje("Ahora, ingrese los nombres de los alumnos con el formato 'ApellidoNombre', ");
			Custom.printMensaje("la nota correspondiente del 1 al 12.");
			Custom.printMensaje(" y las inasistencias semanales del alumno");
			Custom.printMensaje("------------");
			
			for (int i = 0; i < alumnos.length; i++) { //Itera sobre los alumnos
				
				Custom.printMensaje("Ingrese nombre:");
				String nombre = Custom.scanStringInput();
				alumnos[i][0][0] = nombre;
				
				int nota = 0; //Nota es 0 porque hay que inicializar la variable, pero nunca va a llegar en ese estado a llenar la array de alumnos
				boolean esBuenaNota = false; //Para verificar que la nota sea entre el 1 y el 12
				boolean esFaltaCorrecta = false; //Para verificar que el rango de faltas sea acorde a la materia
				
				while(!esBuenaNota || !esFaltaCorrecta) {					
					if (!esBuenaNota) { //Este if se coloca porque si se ingresan mal las faltas, vuelva a pedir la nota, y eso no se quiere
						Custom.printMensaje("Ingrese nota de la materia: ");
						nota = Custom.scanIntInput();
							
						if (nota > 12 || nota < 1) {
							Custom.printMensaje("Error, ingrese una buena nota");
						} else {
							String notaParseada = Integer.toString(nota); //Se parsea porque se usan arrays de tipo String
							alumnos[i][1][0] = notaParseada; //Añade la nota
							
							esBuenaNota = true;
						}
					}
					
					if (esBuenaNota) { //Este if se coloca para que el algoritmo no se "saltee" pasos y ejecute esto antes de ingresar nota
						Custom.printMensaje("Ahora, ingrese las faltas semanales de la materia:");
						int faltas = Custom.scanIntInput();
						int faltasMax = Custom.validarFaltas(etiqueta, asignaturas);
						if (faltas > faltasMax) { //Si las faltas ingresadas son ilógicas
							Custom.printMensaje("Es imposible que el alumno haya tenido esas faltas, ingrese datos adecuados");
							System.out.println("Faltas Máx. de " + etiqueta + ": " + faltasMax);
						
						} else {
							String faltasParseadas = Integer.toString(faltas); //Se parsea porque se usan arrays de tipo String
							alumnos[i][1][1] = faltasParseadas; //Añade las faltas
							esFaltaCorrecta = true;
						}
					}	
				}	
			}
		
		}
		
		return alumnos;
	}
	
	
	
	//*********************************************************************************
	//									OPCIÓN 3
	//*********************************************************************************
	public static void opcionTres(String[][] opcion1, String[][][] opcion2) {
		
		//Mostrar opción 1
		for (int i = 0; i < opcion1.length; i++) {
			System.out.println("Alumno: " + i);
			for (int j = 0; j < opcion1[i].length; j++) {
				if (j == 0) {
					System.out.println("Nombre: " + opcion1[i][j]);
				} else {
					System.out.println("Nota numero " + j + ": " + opcion1[i][j]);
				}
			}
		}
		
		//Mostrar opción 2
		for (int i = 0; i < opcion2.length; i++) {
			System.out.println("Alumno: " + i);
			for (int j = 0; j < opcion2[i].length; j++) {
				if (j == 0) {
					System.out.println("Nombre: " + opcion2[i][j][0]);
					Custom.printMensaje("");
				} else {
					Custom.printMensaje("");
					System.out.println("Nota numero " + j + ": " + opcion2[i][j][0]);
					Custom.printMensaje("");
					System.out.println("Inasistencias: " + j + ": " + opcion2[i][j][1]);
					Custom.printMensaje("");
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
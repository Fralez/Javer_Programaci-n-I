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
	public static void opcionTres(String[][] opcion1, String[][][] opcion2, String[][] asignaturas) {
		/**
		 * Falta:
		 * Promedio Individual |X|
		 * Promedio General de Clase Por Materia | |
		 * Alumno con mayor promedio (Indicar nombre y promedio) | |
		 * Juicio Correspondiente (En base al promedio) | |
		 */
		
		//Promedios individuales de la opción 1
		String[][] PromediosIndividualesOpcion1 = new String[opcion1.length][2]; //0: Nombre - 1: Promedio
		
		//Promedios generales por materia de la opción 1
		String[][] PromediosGeneralesPorMateriaOpcion1 = new String[13][2]; //0: Materia - 1: Promedio
		
		//Alumno con mayor promedio de la opción 1
		String[][] AlumnoMayorPromedioOpcion1 = new String[1][2]; //0: Nombre - 1: Promedio
		
		//Mostrar opción 1
		Custom.printMensaje("Clase ingresada en la opción 1");
		for (int i = 0; i < opcion1.length; i++) {
			System.out.println("Alumno: " + i);
			int counterFinalMateriasI = i + 1; //Este counter sirve para saber cuál es el último recorrido del for grande //CHECK
			int promedio = 0; //Inicializamos la variable que contendrá el promedio
			int promedioMaterias = 0; //Inicializamos la variable que contendrá el promedio por materia
			for (int j = 0; j < opcion1[i].length; j++) {
				int counterFinal = j + 1; //Este counter sirve para saber cuál es el último recorrido del for
				if (j == 0) {
					System.out.println("Nombre: " + opcion1[i][j]);
					Custom.printMensaje("");
					PromediosIndividualesOpcion1[i][0] = opcion1[i][j]; //Agrego el nombre a la casilla correspondiente de promedios
				} else {
					System.out.println("Nota numero " + j + ": " + opcion1[i][j]);
					Custom.printMensaje("");
					//Ahora hay que parsear todas las notas a int, hacer el promedio y después pushearla al array
					int notaPromedial = Integer.parseInt(opcion1[i][j]);
					promedio += notaPromedial;

					if(counterFinal == opcion1[i].length) { //ANTES de terminar el alumno
						int promedioCalculado = promedio / 13; //Promedio pero dividido entre las materias
						String promedioParseado = Integer.toString(promedioCalculado);

						PromediosIndividualesOpcion1[i][1] = promedioParseado;

						System.out.println("Promedio del alumno " + PromediosIndividualesOpcion1[i][0] + ": " + PromediosIndividualesOpcion1[i][1]);
					}
					//Materia's Code...
					
				}
				
				
			}
			//Para denotar los distintos alumnos
			System.out.println("************************************************************************************************************");
		}

		
		
		//Promedios individuales de la opción 2
		String[][] PromediosIndividualesOpcion2 = new String[opcion2.length][2]; //Nombre - Promedio
		
		//Promedios generales por materia de la opción 2
		String[][] PromediosGeneralesPorMateriaOpcion2 = new String[1][2]; //Materia - Promedio
		
		//Alumno con mayor promedio de la opción 2
		String[][] AlumnoMayorPromedioOpcion2 = new String[1][2]; //Nombre - Promedio
		
		//Mostrar opción 2
		Custom.printMensaje("Clase ingresada en la opción 2");
		for (int i = 0; i < opcion2.length; i++) {
			System.out.println("Alumno: " + i);
			int promedio = 0; //Inicializamos la variable que contendrá el promedio
			for (int j = 0; j < opcion2[i].length; j++) {
				int counterProm = j + 1; //Este counter sirve para saber cuándo ya están todas las notas recorridas
				if (j == 0) {
					System.out.println("Nombre: " + opcion2[i][j][0]);
					PromediosIndividualesOpcion2[i][0] = opcion2[i][j][0]; //Agrego el nombre a la casilla correspondiente
					Custom.printMensaje("");
				} else {
					System.out.println("Nota numero " + j + ": " + opcion2[i][j][0]);
					//Ahora hay que parsear todas las notas a int, hacer el promedio y después pushearla al array
					int notaPromedial = Integer.parseInt(opcion2[i][j][0]);
					promedio += notaPromedial;
					
					System.out.println("Inasistencias en materia " + j + ": " + opcion2[i][j][1]);
					Custom.printMensaje("");
					
					if(counterProm == opcion2[i].length) {
						int promedioCalculado = promedio / 13; //Promedio pero dividido entre las materias
						String promedioParseado = Integer.toString(promedioCalculado);

						PromediosIndividualesOpcion2[i][1] = promedioParseado;
						System.out.println("Promedios individual del alumno " + PromediosIndividualesOpcion2[i][0] + ": " + PromediosIndividualesOpcion2[i][1]);
					}
					
				}
			}
			//Para denotar los distintos alumnos
			System.out.println("************************************************************************************************************");
		}
		
	}
	
	
	//SUB-MÉTODOS
	
	public String falloCorrespondiente(String promedio) {
		
		
		return null;
	}
	
	//Do not Touch c:
	/*
	{
		//STORE
		PromediosGeneralesPorMateriaOpcion1[j][0] = Integer.toString(j); //Primero Guardo el número ID de la materia
		
		if (counterFinalMateriasI == 1) { //Si hay materia antes:
			PromediosGeneralesPorMateriaOpcion1[j][1] = "0";
		}
		
		int notaMateriaAntes = Integer.parseInt(PromediosGeneralesPorMateriaOpcion1[j][1]); //Llamo a lo que tenía la materia antes
		System.out.println("Nota materia antes: " + notaMateriaAntes); //CHECKTEST
		System.out.println("");
		
		int notaPromedialMaterias = Integer.parseInt(opcion1[i][j]); //Nota a promediar
		System.out.println("Nota a promediar: " + notaPromedialMaterias); //CHECKTEST
		System.out.println("");
		
		promedioMaterias += notaMateriaAntes + notaPromedialMaterias; //Promedio por materia sumado a la anterior nota
		System.out.println("Promedio materias: " + promedioMaterias); //CHECKTEST
		System.out.println("");
		
		String promedioMateriasParseado = Integer.toString(promedioMaterias);
		PromediosGeneralesPorMateriaOpcion1[j][1] = promedioMateriasParseado;
		System.out.println("MATERIA NUMERO " + j + ": " + "Como termina el promedio g. materia: " + PromediosGeneralesPorMateriaOpcion1[j][1]);
		
		System.out.println("Mas o menos llegue hasta aca 1 vez");
		
		if(counterFinal == opcion1[i].length) { //ANTES de terminar el alumno
			int notaFinalMateria = Integer.parseInt(PromediosGeneralesPorMateriaOpcion1[j][1]); //Llamo a la suma de todas las notas de todos los alumnos de la materia
			int promedioCalculado = notaFinalMateria / opcion1.length; //Promedio por materia pero dividido entre los alumnos
			String promedioParseadoMateria = Integer.toString(promedioCalculado);
			PromediosGeneralesPorMateriaOpcion1[j][1] = promedioParseadoMateria; //Guardo la nota de la materia
			
			System.out.println("Promedio de la materia número " + PromediosGeneralesPorMateriaOpcion1[j][0] + ": " + PromediosGeneralesPorMateriaOpcion1[j][1]);
		}
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
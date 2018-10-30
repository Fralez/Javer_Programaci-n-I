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
	public static void opcionTres(String[][] opcion1, String[][][] opcion2, String[][] asignaturas, String etiqueta) {
		/**
		 * Falta:
		 * Promedio Individual |X|
		 * Promedio General de Clase Por Materia |X|
		 * Alumno con mayor promedio (Indicar nombre y promedio) | |
		 * Juicio Correspondiente (En base al promedio) | |
		 */
		
		//Promedios individuales de la opción 1
		String[][] PromediosIndividualesOpcion1 = new String[opcion1.length][2]; //0: Nombre - 1: Promedio
		
		//Mostrar opción 1 -- Calcular promedio individual
		Custom.printMensaje("Clase ingresada en la opción 1");
		
		for (int i = 0; i < opcion1.length; i++) {
			
			System.out.println("Alumno: " + (i + 1));
			
			int promedio = 0; //Inicializamos la variable que contendrá el promedio
			
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
				}
			}
			//Para denotar los distintos alumnos
			System.out.println("************************************************************************************************************");
		}
		
		//Calcular promedio por MATERIA opción 1

		//Promedios generales por materia de la opción 1
		String[][] PromediosGeneralesPorMateriaOpcion1 = new String[13][2]; //0: Materia - 1: Promedio
		
		for (int i = 0; i <= 13; i++) { //13 por la cantidad de materias

			int promedioMat = 0; //Inicializamos el promedio por materia
			
			for (int j = 0; j < opcion1.length; j++) {

				int counterFinalMat = j + 1; //Contador para identificar la ultima recorrida del for
				
				if (i == 0) {
					// PromediosGeneralesPorMateriaOpcion1[j][0] = opcion1[j][i];					
				} else {
					//Para interar sobre las MATERIAS por encima de ALUMNOS, cambiamos el lugar de las variables de iteracion i y j

					int matNotaPromedial = Integer.parseInt(opcion1[j][i]);
					promedioMat += matNotaPromedial;
					
					if (counterFinalMat == opcion1.length) {
						promedioMat = promedioMat / opcion1.length;
						String promedioMatParseado = Integer.toString(promedioMat);
						
						PromediosGeneralesPorMateriaOpcion1[i - 1][1] = promedioMatParseado;
						
						System.out.println("Promedio De la materia de " + asignaturas[i-1][0] + ": " + PromediosGeneralesPorMateriaOpcion1[i - 1][1]);
					}
				}
			}
		}

		//Alumno con MAYOR promedio de la opción 1
		
		//Averiguar alumno con mayor promedio
		
		int promedioMasAlto = 1; //Guarda el supuesto promedio "más alto"
		String nombreDeAlumno = "null"; //Guarda el nombre del alumno con el promedio más alto
		for (int i = 0; i < PromediosIndividualesOpcion1.length; i++) {
			if (i == 0) {
				promedioMasAlto = Integer.parseInt(PromediosIndividualesOpcion1[i][1]); //Le da el primer valor al supuesto promedio "más alto"
			}
			int promedioComp = Integer.parseInt(PromediosIndividualesOpcion1[i][1]); //Guarda el promedio a comparar
			if (promedioComp >= promedioMasAlto) { //Si el promedio es mayor, lo sustituye por el que se está comparando
				promedioMasAlto = promedioComp;
				nombreDeAlumno = PromediosIndividualesOpcion1[i][0]; //Guardo el nombre del alumno
			}
		}
		if (!nombreDeAlumno.equals("null")) { //Si se encontró, lo muestro
			System.out.println("El promedio más alto es del alumno " + nombreDeAlumno +  ": " + promedioMasAlto);			
		}
		
		falloCorrespondiente(opcion1);
		
		
		
		
		
		//*******************************************************************************************************************************
		//*******************************************************************************************************************************
		
		
		//Promedios individuales de la opción 2
		String[][] PromediosIndividualesOpcion2 = new String[opcion2.length][2]; //0: Nombre - 1: Promedio
		
		
		
		//Mostrar opción 2
		Custom.printMensaje("Clase ingresada en la opción 2, con la etiqueta de: " + etiqueta);
		for (int i = 0; i < opcion2.length; i++) {
			System.out.println("Alumno: " + (i + 1));
			int promedio = 0; //Inicializamos la variable que contendrá el promedio
			for (int j = 0; j < opcion2[i].length; j++) {
				int counterProm = j + 1; //Este counter sirve para saber cuándo ya están todas las notas recorridas
				if (j == 0) {
					System.out.println("Nombre: " + opcion2[i][j][0]);
					PromediosIndividualesOpcion2[i][0] = opcion2[i][j][0]; //Agrego el nombre a la casilla correspondiente
					Custom.printMensaje("");
				} else {
					System.out.println("Nota número " + j + ": " + opcion2[i][j][0]);
					//Ahora hay que parsear todas las notas a int, hacer el promedio y después pushearla al array
					int notaPromedial = Integer.parseInt(opcion2[i][j][0]);
					promedio += notaPromedial;
					
					System.out.println("Inasistencias en materia " + j + ": " + opcion2[i][j][1]);
					Custom.printMensaje("");
					
					if (!etiqueta.equals("Adscripto")) {
						int promedioCalculado = promedio;
						String promedioParseado = Integer.toString(promedioCalculado);
						
						PromediosIndividualesOpcion2[i][1] = promedioParseado;
						System.out.println("Promedio del alumno " + PromediosIndividualesOpcion2[i][0] + ": " + PromediosIndividualesOpcion2[i][1]);
					
					} else if(counterProm == opcion2[i].length) {
						int promedioCalculado = promedio / 13; //Promedio pero dividido entre las materias
						String promedioParseado = Integer.toString(promedioCalculado);

						PromediosIndividualesOpcion2[i][1] = promedioParseado;
						System.out.println("Promedio del alumno " + PromediosIndividualesOpcion2[i][0] + ": " + PromediosIndividualesOpcion2[i][1]);
					}
					
				}
			}
			//Para denotar los distintos alumnos
			System.out.println("************************************************************************************************************");
		}
		
		//Calcular promedio por materia opción 2

		//Promedios generales por materia de la opción 2
		String[][] PromediosGeneralesPorMateriaOpcion2 = new String[13][2]; //0: Materia - 1: Promedio
		
		boolean SoloUnaVezSiEtiqueta = false;
		for (int i = 0; i < 13; i++) { //13 por la cantidad de materias

			int promedioMat = 0; //Inicializamos el promedio por materia
							
			for (int j = 0; j < opcion2.length; j++) {

				int counterFinalMat = j + 1; //Contador para identificar la ultima recorrida del for
				
				if (etiqueta.equals("Adscripto")) {
					if (i != 0) {
						//Para interar sobre las MATERIAS por encima de ALUMNOS, cambiamos el lugar de las variables de iteracion i y j
						
						int matNotaPromedial = Integer.parseInt(opcion2[j][i][0]);
						promedioMat += matNotaPromedial;
						
						if (counterFinalMat == opcion2.length) {
							promedioMat = promedioMat / opcion2.length;
							String promedioMatParseado = Integer.toString(promedioMat);
								
							PromediosGeneralesPorMateriaOpcion2[i - 1][1] = promedioMatParseado;
								
							System.out.println("Promedio De la materia de " + asignaturas[i-1][0] + ": " + PromediosGeneralesPorMateriaOpcion2[i - 1][1]);
						}	
					}
				} else {
					//Para interar sobre las MATERIAS por encima de ALUMNOS, cambiamos el lugar de las variables de iteracion i y j
					
					if ((i+1 != 1) && !etiqueta.equals("Adscripto")) {						
						int matNotaPromedial = Integer.parseInt(opcion2[j][1][0]);
						promedioMat += matNotaPromedial;
					} else {
						int matNotaPromedial = Integer.parseInt(opcion2[j][i+1][0]);
						promedioMat += matNotaPromedial;
					}
					
					if (counterFinalMat == opcion2.length) {
						promedioMat = promedioMat / opcion2.length;
						String promedioMatParseado = Integer.toString(promedioMat);
							
						PromediosGeneralesPorMateriaOpcion2[i][1] = promedioMatParseado;
						
						
						if (etiqueta.equals("Adscripto")) {
							System.out.println("Promedio De la materia de " + asignaturas[i][0] + ": " + PromediosGeneralesPorMateriaOpcion2[i][1]);							
						} else if (!SoloUnaVezSiEtiqueta){
							System.out.println("Promedio De la materia de " + etiqueta + ": " + PromediosGeneralesPorMateriaOpcion2[i][1]);
							SoloUnaVezSiEtiqueta = true;
						}
					}
				}
				
				
			}
		}
		
		//Alumno con mayor promedio de la opción 2
				
		//Averiguar alumno con mayor promedio
				
		int promedioMasAltoOp2 = 1; //Guarda el supuesto promedio "más alto"
		String nombreDeAlumnoOp2 = "null"; //Guarda el nombre del alumno con el promedio más alto
		for (int i = 0; i < PromediosIndividualesOpcion2.length; i++) {
			if (i == 0) {
				promedioMasAltoOp2 = Integer.parseInt(PromediosIndividualesOpcion2[i][1]); //Le da el primer valor al supuesto promedio "más alto"
			}
			int promedioCompOp2 = Integer.parseInt(PromediosIndividualesOpcion2[i][1]); //Guarda el promedio a comparar
			if (promedioCompOp2 >= promedioMasAltoOp2) { //Si el promedio es mayor, lo sustituye por el que se está comparando
				promedioMasAltoOp2 = promedioCompOp2;
				nombreDeAlumnoOp2 = PromediosIndividualesOpcion2[i][0];
			}
		}
		if (!nombreDeAlumnoOp2.equals("null")) { //Si se encontró, lo muestro
			System.out.println("El promedio más alto es del alumno " + nombreDeAlumnoOp2 +  ": " + promedioMasAltoOp2);
		}
			
		falloCorrespondienteOp2(opcion2, etiqueta);

	}
	
	
	//SUB-MÉTODOS
	
	public static void falloCorrespondiente(String[][] notasOp1) {
		//NotasOp1 - 0-length: Alumno / 0: Nombre ; 1-12: Nota
		for (int i = 0; i < notasOp1.length; i++) {
			int materiasExoneradas = 0; //En esta variable se guardan la cantidad de materias altas
			for (int j = 1; j < notasOp1[i].length; j++) {
				int notaParseada = Integer.parseInt(notasOp1[i][j]);
				if (notaParseada >= 8) { //Si la nota es mayor o igual a 8, se suma como nota exonerada
					materiasExoneradas++;
				}
			}
			//Ahora, si las materias exoneradas son mayores a la mitad más 1 de las materias (7), pase a 2ndo y cantidad de exámenes a rendir.
			if (materiasExoneradas >= 7) {
				Custom.printMensaje("Juicio del alumno " + notasOp1[i][0] + ": Pase a segundo año.");
				if (materiasExoneradas == 0) {
					System.out.println("Sin exámenes a rendir.");
				} else {
					System.out.println("Materias a rendir examen: " + (13 - materiasExoneradas));					
				}
			} else {
				Custom.printMensaje("Juicio del alumno " + notasOp1[i][0] + ": Recurso de año.");
			}
		}
		
	}
	
	//Métodos de Fallos
	
	public static void falloCorrespondienteOp2(String[][][] notasOp2, String etiqueta) {
		//NotasOp1 - 0-length: Alumno / 0: Nombre ; 1-12: Nota / 0: Nota ; 1: Inasistencias
		for (int i = 0; i < notasOp2.length; i++) {
			int materiasExoneradas = 0; //En esta variable se guardan la cantidad de materias altas
			for (int j = 1; j < notasOp2[i].length; j++) {
				int notaParseada = Integer.parseInt(notasOp2[i][j][0]);
				if (notaParseada >= 8) { //Si la nota es mayor o igual a 8, se suma como nota exonerada
					materiasExoneradas++;
				}
			}
			//Ahora, si las materias exoneradas son mayores a la mitad más 1 de las materias (7), pase a 2ndo y cantidad de exámenes a rendir.
			if (etiqueta.equals("Adscripto")) {
				if (materiasExoneradas >= 7) {
					System.out.println("entre a ADSCRIPTOS"); //TODO
					Custom.printMensaje("Juicio del alumno " + notasOp2[i][0][0] + ": Pase a segundo año.");
					if (materiasExoneradas == 0) {
						System.out.println("Sin exámenes a rendir.");
					} else {
						System.out.println("Materias a rendir examen: " + (13 - materiasExoneradas));					
					}
				} else {
					Custom.printMensaje("Juicio del alumno " + notasOp2[i][0][0] + ": Recurso de año.");
				}
			} else {
				if (materiasExoneradas == 1) {
					System.out.println("entre a Profes"); //TODO
					Custom.printMensaje("Juicio del alumno " + notasOp2[i][0][0] + ": Pase a segundo año.");
				} else {
					Custom.printMensaje("Juicio del alumno " + notasOp2[i][0][0] + ": Recurso de materia.");
				}
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
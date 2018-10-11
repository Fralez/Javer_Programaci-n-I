public class Log {
	
	public static String In(String[][] listaDeUsuarios) {
		
		boolean estaLoggeado = false; //Esta variable habilitará el Log In exitoso cuando tenga el valor "true"
		String usuario = "", contraseña = ""; //En estas variables se guardarán los valores que ingrese el usuario como nombre de usuario y contraseña
		
		int logCounter = 0; //Esta variable avisará que el usuario falló el Log In más de 3 veces
		
		String etiqueta = ""; //Esto es el RETURN del método
		
		//Mientras no esté loggeado y no haya fallado 3 veces o más el Log In pedirá que se loggee
		while(!estaLoggeado && logCounter < 3) {
			
			//Se declaran dentro del while porque se tiene que resetear su valor en cada logIn
			String etiquetaEsUsuario = "";
			String etiquetaEsContraseña = "";
			
			boolean esUsuario = false, esContraseña = false; // Autorizan el loggeo de usuario y de contraseña
			
			Custom.printMensaje("Ingrese su usuario");
			usuario = Custom.scanStringInput();
			Custom.printMensaje("");
			
			Custom.printMensaje("Ingrese su contraseña");
			contraseña = Custom.scanStringInput();
			Custom.printMensaje("");
			
			//Iteramos sobre todos los usuarios hasta que se nos acaben o encontremos el correcto
			for(int i = 0; i < listaDeUsuarios.length; i++) {
				//Iteramos sobre las propiedades del usuario actual (usuario y contraseña son las que importan)
				for(int j = 0; j < listaDeUsuarios[i].length; j++) {
					switch (j) {
						case 0:
							//Si el usuario coincide
							if (listaDeUsuarios[i][j].equals(usuario)) {
								esUsuario = true;
								if (esUsuario) {
									etiquetaEsUsuario = listaDeUsuarios[i][2];
								}
							}
							break;
						case 1:
							//Si la contraseña coincide
							if (listaDeUsuarios[i][j].equals(contraseña)) {
								esContraseña = true;
								if (esContraseña) {
									etiquetaEsContraseña = listaDeUsuarios[i][2];
								}
							}
							break;
						default:
							break;
					}
				}
			}
			
			//Si ambos usuario y contraseña coinciden
			if ((esUsuario && esContraseña) && (etiquetaEsUsuario.equals(etiquetaEsContraseña))) {
				estaLoggeado = true;
				etiqueta = etiquetaEsUsuario;
				System.out.println("La etiqueta es: " + etiqueta);
				
			} else { //si no, incrementará el contador
				Custom.printMensaje("Lo siento, el usuario o la contraseña no son correctos :/");
				Custom.printMensaje("");
				logCounter++;
			}
		}
		//Si llega a esto significa que intentó loggearse más de 3 veces y no pudo, por lo cual se termina el programa
		if(logCounter >= 3) {
			Custom.printMensaje("Sus intentos han excedido los 3 permitidos por el sistema, llame al servicio técnico para más información");
		}
		//Retorna la asignatura del profesor (en caso de adscripto, devuelve "adscripto")
		return etiqueta;
	}
	
}

public class Log {
	
	public static boolean In(String[][] listaDeUsuarios) {
		
		boolean estaLoggeado = false; //Esta variable habilitará el Log In exitoso cuando tenga el valor "true"
		boolean esUsuario = false, esContraseña = false; 
		int logCounter = 0; //Esta variable avisará que el usuario falló el Log In más de 3 veces
		
		String usuario = "", contraseña = ""; //En estas variables se guardarán los valores que ingrese el usuario como nombre de usuario y contraseña
		
		//Mientras no esté loggeado y no haya fallado 3 veces o más el Log In pedirá que se loggee
		while(!estaLoggeado && logCounter < 3) {

			Custom.printMensaje("Ingrese su usuario");
			usuario = Custom.scanStringInput();
			Custom.printMensaje("");
			
			Custom.printMensaje("Ingrese su contraseña");
			contraseña = Custom.scanStringInput();
			Custom.printMensaje("");
			
			//Iteramos sobre todos los usuarios
			for(int i = 0; i < listaDeUsuarios.length; i++) {
				//Iteramos sobre las propiedades del usuario actual (usuario y contraseña son las que importan)
				for(int j = 0; j < listaDeUsuarios[i].length && !estaLoggeado; j++) {
					switch (j) {
						case 0:
							//Si el usuario coincide
							if (listaDeUsuarios[i][j].equals(usuario)) {
								esUsuario = true;
							}
							break;
						case 1:
							//Si la contraseña coincide
							if (listaDeUsuarios[i][j].equals(contraseña)) {
								esContraseña = true;
							}
							break;
						default:
							break;
					}
				}
			}
			//Si ambos usuario y contraseña coinciden
			if (esUsuario && esContraseña) {
				estaLoggeado = true;
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
		//Retorna un booleano, si es true, significa que el LogIn fue exitoso, si es false, significa que el programa terminó
		return estaLoggeado;
	}
	
}
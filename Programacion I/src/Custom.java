import java.util.Scanner;

//En esta clase se encuentran todos los métodos que sirven de "apoyo", o sea, para hacer el código más limpio
public class Custom {
	
	public static String scanStringInput() {
		
		Scanner scan = new Scanner(System.in);
		String variable = scan.nextLine();
		
		return variable;
	}
	
	public static int scanIntInput() {
		
		Scanner scan = new Scanner(System.in);
		int variable = scan.nextInt();
		
		return variable;
	}
	
	public static void printMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static int validarFaltas(String etiqueta, String[][] asignaturas) {
		
		for (int i = 0; i < asignaturas.length; i++) {
			if (asignaturas[i][0].equals(etiqueta)) {
				int faltasDeAsignatura = Integer.parseInt(asignaturas[i][1]);
				return faltasDeAsignatura;
			}
		}
		
		return -1; //Return que devuelve -1 si algo salió mal en el algoritmo
		
	}
	
}

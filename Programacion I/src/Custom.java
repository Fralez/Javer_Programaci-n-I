import java.util.Scanner;

//En esta clase se encuentran todos los métodos que sirven de "apoyo", o sea, para hacer el código más limpio
public class Custom {
	
	public static String scanStringInput() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String variable = scan.nextLine();
		
		return variable;
	}
	
	public static int scanIntInput() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int variable = scan.nextInt();
		
		return variable;
	}
	
	public static void printMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	
}

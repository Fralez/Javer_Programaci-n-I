import java.util.Scanner;

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
	
	
}

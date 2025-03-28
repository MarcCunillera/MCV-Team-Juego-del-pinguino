package Vista;
import java.util.Scanner;
public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//menú del juego (main)
		Scanner sc = new Scanner(System.in);
		int elec = 0;
		System.out.println("||--------____Bienvenido al juego del pingüino____--------||");
		//Menú principal del juego
		do {
			System.out.println("MENÚ");
			System.out.println("1- Nueva partida");
			System.out.println("2- Cargar partida");
			System.out.println("3- Salir del juego");
			elec = sc.nextInt();
			switch(elec) { //selecciones disponibles para el jugador
			case 1:
				System.out.println("Partida NUEVA");
				
				break;
			case 2:
				System.out.println("Hs elegido cargar partida");
				System.out.print("Elige la partida a cargar (1 - 3): ");
				int numP = sc.nextInt();
				
				break;
			case 3:
				System.out.println("Hasta pronto :)");
				System.out.println("Saliendo ...");
				break;
			default:
				System.out.println("No es una opción válida, vuelve a intentarlo");
				break;
			}
		}while (elec != 3); //condición menú principal
	}
	
}

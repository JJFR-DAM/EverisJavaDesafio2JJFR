package operators;

import java.util.Scanner;

public class Pinball {

	// Declaración de variables:

	private static int score = 0;
	private static int probability = 1000;
	private static int estimateProb = 0;
	private static int game = 0;
	private static String NickName;
	public static String option;

	// Métodos Getters & Setters

	public int getScore() {
		return score;
	}

	public static int getGame() {
		return game;
	}

	public static String getNickName() {
		return NickName;
	}

	public void setNickName(String NickName) {
		Pinball.NickName = NickName;
	}

	// Método constructor:

	public Pinball(String NickName) {
		super();
		Pinball.NickName = NickName;
	}

	public Pinball() {
		super();
	}

	// Método para visualizar Score:

	public static void viewScore() {
		System.out.println("LA PUNTUACION OBTENIDA POR " + getNickName() + " ES: " + score + " POINTS" + "\n"
				+ "NUMERO DE TIRADAS CONSEGUIDAS: " + game + " THROW");
	}

	// Método para calcular Probability:

	public static void calculateProb() {
		for (int i = 0; i < 30; i++) {
			estimateProb = (int) (Math.random() * 10) + 1;
			probability -= estimateProb;
		}
	}

	// Método para lanzar la bola:

	public void launchBall() {

		// Apertura del escaner:

		Scanner sc = new Scanner(System.in);

		/*
		 * El objetivo de usar el do/while es reducir los fallos que pueda generar el
		 * Scanner.
		 */

		do {

			// Se utiliza el try/catch con el fin de minimizar posibles fallos.

			try {

				// Menú inicial en el que se ofertan las opciones.

				System.out.println("---   Tirada débil    --- Opcion '1' ---");
				System.out.println("---   Tirada media    --- Opcion '2' ---");
				System.out.println("---   Tirada fuerte   --- Opcion '3' ---");
				System.out.println("--- Visualizar Puntos --- Opcion '4' ---");
				System.out.println("---      Apagar       --- Opcion '5' ---");

				// Obtencion de la opción para el Switch Case.
				System.out.println("\n      --- Introducir numero ---");
				option = sc.nextLine();

				// Se trabaja el String para quitar posibles excepciones.

				option = option.toLowerCase();
				if (option.equals("uno")) {
					option = option.replaceAll("uno", "1");
				} else if (option.equals("dos")) {
					option = option.replaceAll("dos", "2");
				} else if (option.equals("tres")) {
					option = option.replaceAll("tres", "3");
				} else if (option.equals("cuatro")) {
					option = option.replaceAll("cuatro", "4");
				} else if (option.equals("cinco")) {
					option = option.replaceAll("cinco", "5");
				}

				// Switch Case en el que se subdividen las opciones.

				switch (Integer.parseInt(option)) {
				/*
				 * Se procesa las tiradas en los casos 1-3, en ellas se utiliza un bucle para
				 * generar aleatoriamente una modificación de la probabilidad de seguir en
				 * partida.
				 */
				case 1:
					System.out.println("HAS SELECCIONADO TIRADA DÉBIL");
					score += 1000 * (Math.random() * 100) + 1;
					game = getGame() + 1;
					calculateProb();
					break;
				case 2:
					System.out.println("HAS SELECCIONADO TIRADA MEDIA");
					score += 2000 * (Math.random() * 100) + 1;
					game = getGame() + 1;
					calculateProb();
					break;
				case 3:
					System.out.println("HAS SELECCIONADO TIRADA FUERTE");
					score += 3000 * (Math.random() * 100) + 1;
					game = getGame() + 1;
					calculateProb();
					break;
				/*
				 * Se muestra por consola la puntuación, el nombre del jugador y las tiradas que
				 * lleva realizadas.
				 */
				case 4:
					System.out.println("HAS SELECCIONADO VER LA PUNTUACIÓN");
					viewScore();
					break;
				/*
				 * Su uso es el de finalizar el programa y mostrar los datos como en el caso 4.
				 */
				case 5:
					System.out.println("APAGANDO, GRACIAS POR JUGAR");
					viewScore();
					break;
				default:
					System.out.println("ERROR 404: NOT FOUND");
					;
				}
			} catch (Exception e) {
				System.out.println("ERROR \nIntroducir la opcion sin carácteres especiales/signos de puntuación/etc.");
			}
		} while (option != "1" && probability > 0 || option != "2" && probability > 0
				|| option != "3" && probability > 0 || option != "4" && probability > 0
				|| option != "5" && probability > 0);

		System.out.println("HAS FALLADO, BUEN INTENTO.");
		viewScore();
		System.out.println("APAGANDO, GRACIAS POR JUGAR");

		/*
		 * Hacer con do while sino es 1-5 sigue pintando el menú. Para demás excepciones
		 * aprovechar el default del switch case. switch case pilla String. Comentarios
		 * modo guía, tercera persona. Centrarse en el uso de los operadores
		 */

		// Cierre Scanner

		sc.close();
	}
}
package operators;

import java.util.Scanner;

public class Pinball {

	// Declaraci�n de variables:

	private static int puntuacion = 0;
	private static int probabilidad = 1000;
	private static int contadorProb = 0;
	private static int tirada = 0;
	private String NombreJugador;
	public static String opcion;

	// M�todos Getters & Setters

	public int getPuntuacion() {
		return puntuacion;
	}

	public static int getTirada() {
		return tirada;
	}

	public String getNombreJugador() {
		return NombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		NombreJugador = nombreJugador;
	}

	// M�todo constructor:

	public Pinball(String nombreJugador) {
		super();
		NombreJugador = nombreJugador;
	}

	public Pinball() {
		super();
	}

	// M�todo para lanzar la bola:

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

				// Men� inicial en el que se ofertan las opciones.

				System.out.println("---   Tirada d�bil    --- Opcion '1' ---");
				System.out.println("---   Tirada media    --- Opcion '2' ---");
				System.out.println("---   Tirada fuerte   --- Opcion '3' ---");
				System.out.println("--- Visualizar Puntos --- Opcion '4' ---");
				System.out.println("---      Apagar       --- Opcion '5' ---");

				// Obtencion de la opci�n para el Switch Case.
				System.out.println("\n      --- Introducir numero ---");
				opcion = sc.nextLine();

				// Se trabaja el String para quitar posibles excepciones.

				opcion = opcion.toLowerCase();
				if (opcion.equals("uno")) {
					opcion = opcion.replaceAll("uno", "1");
				} else if (opcion.equals("dos")) {
					opcion = opcion.replaceAll("dos", "2");
				} else if (opcion.equals("tres")) {
					opcion = opcion.replaceAll("tres", "3");
				} else if (opcion.equals("cuatro")) {
					opcion = opcion.replaceAll("cuatro", "4");
				} else if (opcion.equals("cinco")) {
					opcion = opcion.replaceAll("cinco", "5");
				}

				// Switch Case en el que se subdividen las opciones.

				switch (Integer.parseInt(opcion)) {
				/*
				 * Se procesa las tiradas en los casos 1-3, en ellas se utiliza un bucle para
				 * generar aleatoriamente una modificaci�n de la probabilidad de seguir en
				 * partida.
				 */
				case 1:
					System.out.println("HAS SELECCIONADO TIRADA D�BIL");
					puntuacion += (Math.random() * 100) + 1;
					tirada = getTirada() + 1;
					for (int i = 0; i < 100; i++) {
						contadorProb = (int) (Math.random() * 10) + 1;
						probabilidad -= contadorProb;
					}
					break;
				case 2:
					System.out.println("HAS SELECCIONADO TIRADA MEDIA");
					puntuacion += 2 * (Math.random() * 100) + 1;
					tirada = getTirada() + 1;
					for (int i = 0; i < 100; i++) {
						contadorProb = (int) (Math.random() * 10) + 1;
						probabilidad -= contadorProb;
					}
					break;
				case 3:
					System.out.println("HAS SELECCIONADO TIRADA FUERTE");
					puntuacion += 3 * (Math.random() * 100) + 1;
					tirada = getTirada() + 1;
					for (int i = 0; i < 10; i++) {
						contadorProb = (int) (Math.random() * 10) + 1;
						probabilidad -= contadorProb;
					}
					break;
				/*
				 * Se muestra por consola la puntuaci�n, el nombre del jugador y las tiradas que
				 * lleva realizadas.
				 */
				case 4:
					System.out.println("HAS SELECCIONADO VER LA PUNTUACI�N");
					System.out.println("LA PUNTUACION OBTENIDA POR " + getNombreJugador() + " ES: " + puntuacion + "\n"
							+ "NUMERO DE TIRADAS CONSEGUIDAS: " + tirada);
					break;
				/*
				 * Su uso es el de finalizar el programa y mostrar los datos como en el caso 4.
				 */
				case 5:
					System.out.println("APAGANDO, GRACIAS POR JUGAR");
					System.out.println("LA PUNTUACION OBTENIDA POR " + getNombreJugador() + " ES: " + puntuacion + "\n"
							+ "NUMERO DE TIRADAS CONSEGUIDAS: " + tirada);
					break;
				default:
					System.out.println("ERROR 404: NOT FOUND");
					;
				}
			} catch (Exception e) {
				System.out.println("ERROR \nIntroducir la opcion sin car�cteres especiales/signos de puntuaci�n/etc.");
			}
		} while (opcion != "1" && probabilidad > 0 || opcion != "2" && probabilidad > 0
				|| opcion != "3" && probabilidad > 0 || opcion != "4" && probabilidad > 0
				|| opcion != "5" && probabilidad > 0);

		System.out.println("HAS FALLADO, BUEN INTENTO.");
		System.out.println("LA PUNTUACION OBTENIDA POR " + getNombreJugador() + " ES: " + puntuacion + "." + "\n"
				+ "NUMERO DE TIRADAS CONSEGUIDAS: " + tirada + ".");
		System.out.println("APAGANDO, GRACIAS POR JUGAR");

		/*
		 * Hacer con do while sino es 1-5 sigue pintando el men�. Para dem�s excepciones
		 * aprovechar el default del switch case. switch case pilla String. Comentarios
		 * modo gu�a, tercera persona. Centrarse en el uso de los operadores
		 */

		// Cierre Scanner

		sc.close();
	}

}
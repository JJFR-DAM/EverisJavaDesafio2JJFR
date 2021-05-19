package fpdualeveris;

import java.util.Scanner;

import operators.Pinball;

public class FPDual {

	public static void main(String[] args) {

		operatorsChallenge();

	}

	// Creación del método

	private static void operatorsChallenge() {
		/*
		 * Paintball.launchBall(); si el metodo statico y publico permite usarlo de esta
		 * forma.
		 */

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("PROPORCIONA SU NOMBRE DE JUGADOR:");
			String nombreJugador = sc.nextLine();
			Pinball pinball = new Pinball();
			pinball.setNombreJugador(nombreJugador);
			pinball.launchBall();
			if (pinball instanceof Pinball) {
				System.out.println("Este pinball ha sido ideado\ny creado con propósitos meramente lucrativos.\nDesde EVERIS esperamos que haya disfrutado.");
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("FALLO INMINENTE: REINICIAR");
		}
		;
	}

}

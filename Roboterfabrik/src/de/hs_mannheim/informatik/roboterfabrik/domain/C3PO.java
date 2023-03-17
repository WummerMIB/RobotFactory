package de.hs_mannheim.informatik.roboterfabrik.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotMagicValueException;

public class C3PO extends BaseRobot {

	/**
	 * Konstruktor, erstellt ein Objekt von C3PO
	 * 
	 * @param name Name des Roboter
	 * @param id   Eindeutige Identifikation des Roboter
	 */
	C3PO(String name, int id) {
		super(name, id);
	}

	/**
	 * @see RobotInstructions
	 */
	@Override
	public String speak(int[] zahlen) throws RobotException {
		int[] arr = think(zahlen);
		String bs = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(";"));
		return bs;
	}

	/**
	 * @see RobotInstructions
	 */
	@Override
	public int[] think(int[] zahlen) throws RobotException {
		if (schalter == false) {
			this.blackBox = 2;
			throw new RobotIllegalStateException("Fehler -> Roboter einschalten");
		}

		for (Integer i : zahlen) {
			if (i == 42) {
				this.blackBox = 1;
				throw new RobotMagicValueException("Fehler -> Input: 42");
			}
		}

		for (int i = 0; i < zahlen.length - 1; i++) {

			if (zahlen[i] < zahlen[i + 1]) {
				int help = zahlen[i];
				zahlen[i] = zahlen[i + 1];
				zahlen[i + 1] = help;

				for (int j = i; j > 0; j--) {
					if (zahlen[j] > zahlen[j - 1]) {
						int help2 = zahlen[j];
						zahlen[j] = zahlen[j - 1];
						zahlen[j - 1] = help2;

					}
				}
			}
		}
		return zahlen;
	}

}

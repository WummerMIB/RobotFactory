package de.hs_mannheim.informatik.roboterfabrik.domain;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotMagicValueException;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.platform.commons.util.StringUtils;

public class R2D2 extends BaseRobot {
	
	/**
	 * Konstruktor, erstellt ein Objekt von R2D2
	 * @param name Name des Roboter
	 * @param id Eindeutige Identifikation des Roboter
	 */
	R2D2(String name, int id) {
		super(name, id);
	}
	/**
	 * @see RobotInstructions
	 */
	@Override
	public String speak(int[] zahlen) throws RobotException {
		int[] arr = think(zahlen);
		String sb1 = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
		return sb1;
	}
	/**
	 * @see RobotInstructions
	 */
	@Override
	public int[] think(int[] zahlen) throws RobotException {

		if (schalter == false) {
			this.blackBox=2;			
			throw new RobotIllegalStateException("Fehler -> Roboter einschalten");
		}

		for (Integer i : zahlen) {
			if (i == 42) {
				this.blackBox = 1;
				throw new RobotMagicValueException("Fehler -> Input: 42");
			}
		}
		for (int j = 0; j < zahlen.length; j++) {
			int merke = Integer.MAX_VALUE;
			int pos = -1;
			for (int i = j; i < zahlen.length; i++) {
				if (zahlen[i] < merke) {
					merke = zahlen[i];
					pos = i;
				}
			}
			int zws = zahlen[j];
			zahlen[j] = zahlen[pos];
			zahlen[pos] = zws;
		}
		return zahlen;
	}
	
}

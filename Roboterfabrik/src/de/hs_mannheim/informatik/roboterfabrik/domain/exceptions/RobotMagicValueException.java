package de.hs_mannheim.informatik.roboterfabrik.domain.exceptions;

public class RobotMagicValueException extends RobotException {

	/**
	 * Wirft eine RobotMAgicValueException
	 */
	public RobotMagicValueException() {
	}
	/**
	 * Wirft eine RobotMAgicValueException mit einer Nachricht
	 * @param message Möglichkeit zum beschreiben des Fehlers.
	 */
	public RobotMagicValueException(String message) {
		super(message);
	}
}

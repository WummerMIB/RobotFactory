package de.hs_mannheim.informatik.roboterfabrik.domain.exceptions;

public class RobotIllegalStateException extends RobotException{
	
	/**
	 * Wirft eine RobotIllegalStateException 
	 */
	public RobotIllegalStateException() {
	}
	 /**
	 * Wirft eine RobotIllegalStateException mit einer Nachricht.
	 * @param message  Möglichkeit zum beschreiben des Fehlers.
	 */
	public RobotIllegalStateException(String message) {
		super(message);
	}
	
		
}

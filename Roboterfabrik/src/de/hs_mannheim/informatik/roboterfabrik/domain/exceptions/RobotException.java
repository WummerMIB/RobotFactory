package de.hs_mannheim.informatik.roboterfabrik.domain.exceptions;

public class RobotException extends Exception {
	
	/**
	 * Wirft eine RobotException
	 */
	public RobotException() {		
	}
	/**
	 * 
	 * @param message Möglichkeit zum beschreiben des Fehlers.
	 */
	public  RobotException(String message){
		super(message);
	}

	
	
	
}

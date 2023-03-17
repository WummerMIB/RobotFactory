package de.hs_mannheim.informatik.roboterfabrik.domain;

import java.util.ArrayList;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotMagicValueException;

public abstract class BaseRobot implements Robot{
	protected int id;
	protected String name;
	protected boolean schalter = false;
	protected int blackBox;
	/**
	 * Konstruktor des BaseRobot
	 * @param name Name des Roboter
	 * @param id Eindeutige Identifikation des Roboter mit einer Zahl
	 */
	BaseRobot(String name, int id){
		this.id = id;
		this.name = name;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public int getId() {
		return this.id;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public String getName() {
		return this.name;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public void triggerPowerSwitch() {
		if (schalter == false) {
			schalter = true;
			return;
		}

		if (schalter == true) {
			schalter = false;
			return;
		}
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public boolean isPowerOn() {
		return schalter;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public RobotException getLastException() {

		if (blackBox == 1) {
			return new RobotMagicValueException();
		}
		else if (blackBox == 2) {
			return new RobotIllegalStateException();
		}
		return null;
		
	}
	/**
	 * @see RobotInstructions
	 */
	@Override
	public abstract String speak(int[] zahlen) throws RobotException;
	
	/**
	 * @see RobotInstructions
	 */
	@Override
	public abstract int[] think(int[] zahlen) throws RobotException;
	
}

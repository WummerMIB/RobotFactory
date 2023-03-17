package de.hs_mannheim.informatik.roboterfabrik.domain;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;

public class Nexus6 extends BaseRobot {
	
	private static volatile Nexus6 nexusInstance;
	
	/**
	 * 
	 * @param name Standardmäßig: Pris (Name des Roboter)
	 * @param id Standardmäßig: 19281982 (eindeutige Identifikation des Roboter)
	 */
	private Nexus6(String name, int id) {
		super(name, id);
	}
	/**
	 * 
	 * @return instance des Nexus6 Roboter man kann nur eine instance des Roboter erstellen
	 */
	public static Nexus6 getInstance() {
		Nexus6 instance = nexusInstance;
		if(instance == null) {
			synchronized (Nexus6.class) {
				instance = nexusInstance;
				if(instance == null) {
					nexusInstance = instance = new Nexus6("Pris", 19281982);
				}
			}
		}
		return instance;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public int getId() {
		return super.id;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public String getName() {
		return super.name;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public void triggerPowerSwitch() {	
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public boolean isPowerOn() {
		return false;
	}
	/**
	 * @see RobotControl
	 */
	@Override
	public RobotException getLastException() {
		return new RobotIllegalStateException();
	}
	/**
	 * @see RobotInstruction
	 */
	@Override
	public String speak(int[] zahlen) throws RobotException {
		throw new RobotIllegalStateException();
	}
	/**
	 * @see RobotInstruction
	 */
	@Override
	public int[] think(int[] zahlen) throws RobotException {
		throw new RobotIllegalStateException();
	}

}

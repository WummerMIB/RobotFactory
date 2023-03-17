package de.hs_mannheim.informatik.roboterfabrik.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;

class UnitTest {

	@Test
	void BaseRobotTest() throws RobotException {
		
		RobotFactory rf = new RobotFactory();
		
		BaseRobot bs = rf.erstelleRoboter("Megatron", RobotType.C3PO);
		BaseRobot bs2 = rf.erstelleRoboter("Ironman", RobotType.C3PO);
		
		bs.triggerPowerSwitch();
		
		int[] liste = {3, 6, 2, 1, 5, 4};
		
		String ergebnisC3PO = "6;5;4;3;2;1";
		
		BaseRobot r2d2 = rf.erstelleRoboter("Bumbelbee", RobotType.R2D2);
		
		assertFalse(r2d2.isPowerOn());
		r2d2.triggerPowerSwitch();
		
		String bumbelbee = r2d2.speak(r2d2.think(liste));
		String megatron =bs.speak(bs.think(liste));
		
		assertNotEquals(ergebnisC3PO ,bumbelbee);
		assertEquals(ergebnisC3PO, megatron);
		assertNotEquals(bumbelbee, megatron);
		String ergebnisR2D2 = "1,2,3,4,5,6";
		assertEquals(ergebnisR2D2, bumbelbee);
		assertNotEquals(bs.getId(), bs2.getId());
		System.out.println(bs.getId() + " : " +bs2.getId());
		assertTrue(bs.getId()>=10000);
		assertFalse(bs.getId()<=10000);
	}

}

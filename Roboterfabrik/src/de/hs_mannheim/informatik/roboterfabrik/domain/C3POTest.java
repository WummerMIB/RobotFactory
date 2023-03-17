package de.hs_mannheim.informatik.roboterfabrik.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotMagicValueException;

class C3POTest {

	@Test
	void basicTest() {
		C3PO c3 = new C3PO("TestC3PO", 1);
		assertEquals(1, c3.getId());
		assertEquals("TestC3PO", c3.getName());
	}
	
	@Test
	void c3POThinkAndSpeakTest() throws RobotException {
		C3PO c3 = new C3PO("TestC3PO", 1);
		c3.triggerPowerSwitch();
		int[] arr = {3,4,5,1,2};
		String erwartung = "5;4;3;2;1";
		assertEquals(erwartung, c3.speak(arr));
	}
	
	@Test
	void c3POExceptionTest() {
		RobotFactory rf = new RobotFactory();
		C3PO c1 = new C3PO("Test", 19999);
		C3PO c2 = (C3PO) rf.erstelleRoboter("Test", RobotType.C3PO);
		int[] list = { 42 };
		Assertions.assertThrows(RobotIllegalStateException.class, () -> c1.think(list));
		//Assertions.assertThrows(RobotIllegalStateException.class, () -> r2.getLastException());
		c1.triggerPowerSwitch();
		Assertions.assertThrows(RobotMagicValueException.class, () -> c1.think(list));
		
		
		Assertions.assertThrows(RobotIllegalStateException.class, () -> c2.think(list));
		//Assertions.assertThrows(RobotIllegalStateException.class, () -> r2.getLastException());
		c2.triggerPowerSwitch();
		Assertions.assertThrows(RobotMagicValueException.class, () -> c2.think(list));
	}

}

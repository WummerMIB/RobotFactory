package de.hs_mannheim.informatik.roboterfabrik.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;
import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotMagicValueException;


// erster Fehler letzte Zahl ist immer noch kommer 1,2,3, sollte sein 1,2,3


class R2D2Test {

	@Test
	void r2D2BasicTest() {
		R2D2 r2 = new R2D2("Test", 2);
		assertEquals("Test", r2.getName());
		assertEquals(2, r2.getId());
	}
	
	@Test
	void r2D2ThinkSpeakTest() throws RobotException {
		R2D2 r2 = new R2D2("Test", 2);
		r2.triggerPowerSwitch();
		int[] testList = {1,2,3,4,5};
		int[] toSortList = {3,2,5,4,1};
		String speak = "1,2,3,4,5";
		assertTrue(Arrays.equals(testList, r2.think(toSortList)));
		assertEquals(speak, r2.speak(toSortList));
	}

	@Test
	void r2D2ExceptionTest() {
		RobotFactory rf = new RobotFactory();
		R2D2 r2 = (R2D2) rf.erstelleRoboter("Bob", RobotType.R2D2);
		R2D2 r1 = new R2D2("test", 1);
		int[] list = { 42 };
		Assertions.assertThrows(RobotIllegalStateException.class, () -> r2.think(list));
		assertEquals(RobotIllegalStateException.class, r2.getLastException().getClass());
		r2.triggerPowerSwitch();
		Assertions.assertThrows(RobotMagicValueException.class, () -> r2.think(list));
		assertEquals(RobotMagicValueException.class, r2.getLastException().getClass());
		
		Assertions.assertThrows(RobotIllegalStateException.class, () -> r1.think(list));
		//Assertions.assertThrows(RobotIllegalStateException.class, () -> r2.getLastException());
		r1.triggerPowerSwitch();
		Assertions.assertThrows(RobotMagicValueException.class, () -> r1.think(list));
	}
}

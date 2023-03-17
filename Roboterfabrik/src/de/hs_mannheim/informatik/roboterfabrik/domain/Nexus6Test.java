package de.hs_mannheim.informatik.roboterfabrik.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.hs_mannheim.informatik.roboterfabrik.domain.exceptions.RobotIllegalStateException;

class Nexus6Test {

	@Test
	void basicTest() {
		Nexus6 ne = Nexus6.getInstance();
		Nexus6 ne2 = Nexus6.getInstance();
		assertFalse(ne.isPowerOn());
		ne.triggerPowerSwitch();
		assertFalse(ne.isPowerOn());
		assertEquals(ne.getName(), "Pris");
		assertEquals(ne.getId(), 19281982);
		assertEquals(ne, ne2);
	}

	@Test
	void excebtionTest() {
		Nexus6 ne = Nexus6.getInstance();
		int[] list = {2,5};
		Assertions.assertThrows(RobotIllegalStateException.class, () -> ne.think(list));
		Assertions.assertThrows(RobotIllegalStateException.class, () -> ne.speak(list));
	}
}

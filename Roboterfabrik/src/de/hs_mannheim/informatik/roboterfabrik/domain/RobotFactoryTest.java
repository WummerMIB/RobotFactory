package de.hs_mannheim.informatik.roboterfabrik.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class RobotFactoryTest {

	@Test
	void BasicTest() {
		HashMap<Integer, R2D2> mapR2 = new HashMap<>();
		HashMap<Integer, C3PO> mapC3P = new HashMap<>();
		RobotFactory rf = new RobotFactory();
		//Test
		for(int i = 0; i<10000;i++) {
			R2D2 r2 = (R2D2) rf.erstelleRoboter("Test"+i, RobotType.R2D2);
			C3PO c3 = (C3PO) rf.erstelleRoboter("TestC3PO"+i, RobotType.C3PO);
			mapR2.put(i, r2);
			mapC3P.put(i, c3);
			assertTrue(mapR2.get(i).getId()<10000);
			assertFalse(mapR2.get(i).getId()>=10000);
			assertEquals(mapR2.get(i).getName(), "Test"+i);
			assertTrue(mapC3P.get(i).getId()<20000 || mapC3P.get(i).getId()>9999);
			assertFalse(mapC3P.get(i).getId()==20000 || mapC3P.get(i).getId()<9999);
			assertEquals(mapC3P.get(i).getName(), "TestC3PO"+i);
		}		
	}

}

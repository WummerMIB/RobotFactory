package de.hs_mannheim.informatik.roboterfabrik.domain;

import java.util.ArrayList;

public class RobotFactory {
	private Nexus6 nexus;

	
	/**
	 * Konstruktor, erstellt ein Objekt von RobotFactory
	 * füllt die ArrayList R2D2id mit Zahlen zwischen 0-9999 und C3POid mit Zahlen 10000-19999.
	 * in jeder Factory existiert ein kaputter Nexus6 Roboter.
	 **/
	public RobotFactory() {
		füllen();
		this.nexus = Nexus6.getInstance();
	}
	/**
	 * ArrayListen zum vergeben der einzigartigen IDs der Robotertypen.
	 */
	private ArrayList<Integer> R2D2id = new ArrayList<>();
	private ArrayList<Integer> C3POid = new ArrayList<>();


	/**
	 * füllt beide ID Listen der beiden Robotertypen auf.
	 */

	private void füllen() {
		for (int i = 0; i < 10000; i++) {
			R2D2id.add(i);
			C3POid.add(i + 10000);
		}
	}


	public String test() {
		return nexus.getName();
	}


	/**
	 * Entnimmt eine ID aus der Liste und l�scht diese nachdem ein Roboter mit eben jener ID produziert wurde.
	 * @param liste Eine Liste bestehend aus eindeutigen Identifikationen in Form einer Zahl. 
	 * @return Eine eindeutige Identifikation in Form einer Zahl oder eine Abbruchssequenz wenn keine ID mehr verf�gbar ist. 
	 */

	private int IDZuweisen(ArrayList<Integer> liste) {
		if (liste.size() == 0)
			return (Integer) null;
		int index = (int) (Math.random() * liste.size());

		int help = liste.get(index);
		liste.remove(index);
		return help;

	}
	/**
	 * Zum "produzieren" des Roboter (entweder C3PO oder R2D2)
	 * @param name Den Name des Roboters angeben.
	 * @param type Typ des Roboters angeben.
	 * @return Roboter von Typ R2D2 oder C3PO 
	 */
	public BaseRobot erstelleRoboter(String name, RobotType type) {
		if (type.equals(RobotType.C3PO)) {

			int id = IDZuweisen(C3POid);
			C3PO c3po = new C3PO(name, id);
			return c3po;

		}

		else if (type.equals(RobotType.R2D2)) {
			int id = IDZuweisen(R2D2id);
			R2D2 r2d2 = new R2D2(name, id);
			return r2d2;
		}

		else
			return null;

	}

}

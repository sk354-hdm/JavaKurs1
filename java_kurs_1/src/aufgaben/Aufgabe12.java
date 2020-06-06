package aufgaben;

import komponenten.KlickKnopf;
import tools.StandardAnwendung;


public class Aufgabe12 extends StandardAnwendung {

	public static void main  (String[]a) {
		starteAnwendung();
		}
	
	
	public Aufgabe12 () {
		
	super ("Aufgabe 12", 300, 150);
	KlickKnopf objekt = new KlickKnopf();
	this.add(objekt);
	
	}
	
	
}

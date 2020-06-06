package aufgaben;

import java.awt.BorderLayout;

import komponenten.ZufallsFarbKnopf;
import tools.StandardAnwendung;

public class Aufgabe15 extends StandardAnwendung{
	
	public static void main (String [] a) {
		starteAnwendung();
	}
	
	public Aufgabe15() {
		
		super("Aufgabe 15", 500,400);
		
		this.add(new ZufallsFarbKnopf(this ));
	
	}

}

package aufgaben;

import javax.swing.JButton;
import komponenten.KlickReaktion;
import tools.StandardAnwendung;



public class Aufgabe11 extends StandardAnwendung {

	public static void main (String[] a) {
		starteAnwendung();
	}
	
	public Aufgabe11() {
		
		super("Aufgabe 11", 300,300);
		
		JButton knopf = new JButton("Nicht klicken!");
		this.add(knopf);
		knopf.addActionListener(new KlickReaktion());
	}
}

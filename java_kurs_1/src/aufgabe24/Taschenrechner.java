package aufgabe24;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import tools.StandardAnwendung;

public class Taschenrechner extends StandardAnwendung{
	
	Anzeige anzeige = new Anzeige();
	
	
	public static void main (String []a) {
		starteAnwendung();
	}
	
	public Taschenrechner() {
		
		super("Taschenrechner",600,400);
		this.setLayout(new BorderLayout());
		this.add(this.anzeige, BorderLayout.NORTH);
		JPanel tastenFeld = new JPanel();
		tastenFeld.setLayout(new GridLayout(4,5));

		tastenFeld.add(new Ziffer("7", anzeige));
		tastenFeld.add(new Ziffer("8", anzeige));
		tastenFeld.add(new Ziffer("9", anzeige));
		tastenFeld.add(new Ziffer("+", anzeige));
		tastenFeld.add(new Wurzel("SQRT", anzeige));
		tastenFeld.add(new Ziffer("4", anzeige));
		tastenFeld.add(new Ziffer("5", anzeige));
		tastenFeld.add(new Ziffer("6", anzeige));
		tastenFeld.add(new Ziffer("-", anzeige));
		tastenFeld.add(new Kehrwert("1/x", anzeige));
		tastenFeld.add(new Ziffer("1", anzeige));
		tastenFeld.add(new Ziffer("2", anzeige));
		tastenFeld.add(new Ziffer("3", anzeige));
		tastenFeld.add(new Ziffer("*", anzeige));
		tastenFeld.add(new PlusMinus("+-", anzeige));
		tastenFeld.add(new Clear("C", anzeige));
		tastenFeld.add(new Ziffer("0", anzeige));
		tastenFeld.add(new Ziffer(".", anzeige));
		tastenFeld.add(new Ziffer("/", anzeige));
		tastenFeld.add(new Ziffer("=", anzeige));
	
		
		this.add(tastenFeld,BorderLayout.CENTER);
	}


}

package aufgaben;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tools.StandardAnwendung;

public class Aufgabe8 extends StandardAnwendung{
	
	public static void main (String [] a) {
		starteAnwendung();
	}
		
		public Aufgabe8() {
			super("Aufgabe 8", 300, 150);

			JLabel name = new JLabel("Name");
			this.add(name);
			JTextField eingabe = new JTextField(12);
			this.add(eingabe);
			JCheckBox senden = new JCheckBox("Bitte senden Sie mir Informationen zu.");
			this.add(senden);
			JButton knopf = new JButton("Anfrage abschicken");
			this.add(knopf);
		}
		
	}


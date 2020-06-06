package aufgaben;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tools.StandardAnwendung;

public class Aufgabe7 extends StandardAnwendung {
	
		 public static void main(String[] a){
		 starteAnwendung();
		 }
		 
		 public Aufgabe7(){
		 super("Aufgabe 7", 200, 150);
		 
		 JLabel Reisezielbutton = new JLabel ("Reiseziel");
		 this.add(Reisezielbutton);
		 
		 JTextField eingabeFeld = new JTextField (12);
		 this.add(eingabeFeld);
		 
		 JButton knopf = new JButton("Anfrage abschicken");
		 this.add(knopf);
		 }

}

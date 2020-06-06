package aufgaben;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;

import komponenten.FarbKnopf;
import tools.StandardAnwendung;

public class Aufgabe13 extends StandardAnwendung {
	public static void main (String[]a) {
		starteAnwendung();
	}
	
	public Aufgabe13() {
		
		
		super("Aufgabe 13", 300, 150);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e) {}
 
		this.add(new FarbKnopf("Rot",Color.RED,this));
		this.add(new FarbKnopf("Grün",Color.GREEN,this));
		this.add(new FarbKnopf("Blau",Color.BLUE,this));
		this.add(new FarbKnopf("GELB",Color.YELLOW,this));
		this.add(new FarbKnopf("Orange",Color.ORANGE,this));
		this.add(new FarbKnopf("Pink",Color.PINK,this));
		
		
		
	}
	
}

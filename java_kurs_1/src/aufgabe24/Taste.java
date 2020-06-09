package aufgabe24;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Taste extends JButton implements ActionListener {
	
	protected Anzeige anzeige;
	protected static boolean neueEingabe;
	
	public Taste (String wert, Anzeige anzeige) {
		super(wert);
		this.anzeige = anzeige;
		this.addActionListener(this);
		
	}

}

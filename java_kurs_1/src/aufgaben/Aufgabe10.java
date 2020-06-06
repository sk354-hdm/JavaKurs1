package aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.StandardAnwendung;

public class Aufgabe10 extends StandardAnwendung {
	
	public static void main (String[]a) {
		starteAnwendung();
	}
	
	public Aufgabe10 () {
		
		super("Aufgabe 10", 300,150);
		this.setLayout(new BorderLayout());
		
		this.add(farbigesPanel(Color.RED,"NORTH"), BorderLayout.NORTH);
		this.add(farbigesPanel(Color.GREEN,"CENTER"), BorderLayout.CENTER);
		this.add(farbigesPanel(Color.ORANGE,"SOUTH"), BorderLayout.SOUTH);
		this.add(farbigesPanel(Color.YELLOW,"WEST"), BorderLayout.WEST);
		this.add(farbigesPanel(Color.PINK,"EAST"), BorderLayout.EAST);
	}

	
	private  JPanel farbigesPanel (Color farbe, String atext) {
		
		JPanel panel = new JPanel ();
		panel.setBackground(farbe);
		
		JLabel text = new JLabel(atext);
		panel.add(text);
		
		return panel;
	}
}

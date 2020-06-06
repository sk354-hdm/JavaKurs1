package aufgaben;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import tools.StandardAnwendung;

public class Testklasse extends StandardAnwendung implements ActionListener{
	
	Timer tick = new Timer(1000, this);
	Random zufall = new Random();
	int r,g,b;
	JPanel panel;
	
	
	public static void main (String[]a) {
		
		starteAnwendung();
	
	}
	
	public Testklasse() {
		super("Aufgabentest",250,250);
		tick.addActionListener(this);
		tick.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		r = zufall.nextInt(255);
		g = zufall.nextInt(255);
		b = zufall.nextInt(255);
		super.setBackground(new Color(r,g,b));
		
	}
}
	


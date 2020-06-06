package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import tools.Klang;
import tools.Spiel;

public class KlangFigur extends SpielFigur {
	
	private Klang klang;
	boolean istHalbton;
	
	public KlangFigur (boolean istHalbton, String SoundDatei, double xC, double yC, Spiel spiel) {
		super(yC, yC, 30, 60, spiel);
		klang = new Klang(SoundDatei);
		this.istHalbton = istHalbton;
		if(istHalbton) {
			klang.setRate(16/15);
			this.width = 20;
			this.height = 80;
		}
	}
	
	public void mousePressed (MouseEvent e) {
		if(this.contains(e.getPoint())){
				klang.play();
				}
	}
		
	public void zeichne (Graphics2D g) {
		super.zeichne(g);
		g.setBackground(Color.white);
		
	}
	public void play() {
		klang.play();
	}

}

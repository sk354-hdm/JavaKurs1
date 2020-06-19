package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import tools.Klang;
import tools.Spiel;

public class ZufallsFigur extends SpielFigur{
	
	Random zufall = new Random();
	
	Klang klickSound = new Klang("/sound/blip.mp3");
	
	Ellipse2D.Double kugel;
	
	Color farbe;
	
	public ZufallsFigur(double xC, double yC, Spiel spiel) {
		super(xC, yC, 30, 30, spiel);
		kugel = new Ellipse2D.Double(xC,yC,30, 30);
		klickSound.play();
		farbe = new Color(zufall.nextInt(200),zufall.nextInt(200),zufall.nextInt(200));
		
		int max_speed = 5 ;
		bewegung.x = zufall.nextDouble()*2*max_speed - max_speed;
		bewegung.y = zufall.nextDouble()*2*max_speed - max_speed;
		this.setRandReaktion(RAND_ABPRALLEN, null); 
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void zeichne (Graphics2D g) {
		kugel.setFrame(this);
		g.setColor(farbe);
		g.fill(kugel);
	}

}

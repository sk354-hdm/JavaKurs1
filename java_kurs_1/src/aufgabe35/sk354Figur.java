package aufgabe35;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import Figuren.SpielFigur;
import tools.Spiel;

public class sk354Figur extends SpielFigur{
	
	private AffineTransform transform = new AffineTransform();
	
	private Ellipse2D globe = new Ellipse2D.Double(100,100,400,400),
					innerglobe = new Ellipse2D.Double(100,100, 300, 400),
					innerglobe2 = new Ellipse2D.Double(100, 100,400,300);
	
	
	
	public sk354Figur(double xC, double yC, Spiel spiel) {
		super(spiel.getHeight()/2, spiel.getWidth()/2, 40, 40, spiel);
		
	}
	
	public void zeichne(Graphics2D g) {
		AffineTransform merk = g.getTransform(); 
		transform.setToTranslation(this.getCenterX(), this.getCenterY());
		g.setTransform(transform);
		g.scale(1, 1);
		g.setColor(Color.BLUE);
		g.fill(globe);
		g.setColor(Color.WHITE);
		g.draw(innerglobe);
		g.draw(innerglobe2);
		g.setTransform(merk);
	}
	
	

}

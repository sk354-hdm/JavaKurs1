package aufgabe35;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import Figuren.SpielFigur;
import tools.Spiel;

public class sk354Figur extends SpielFigur{
	
	private AffineTransform transform = new AffineTransform();
	
	private Ellipse2D globe = new Ellipse2D.Double(100,100,400,400),
					outerglobe = new Ellipse2D.Double(100,100, 400, 400),
					innerglobe = new Ellipse2D.Double(250,100, 100, 400),
					innerglobe1 = new Ellipse2D.Double(150,100, 300, 400),
					innerglobe2 = new Ellipse2D.Double(100, 250,400,100),
					innerglobe3 = new Ellipse2D.Double(100, 150,400,300);
	
	
	
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
		g.draw(outerglobe);
		g.draw(innerglobe);
		g.draw(innerglobe1);
		g.draw(innerglobe2);
		g.draw(innerglobe3);
		g.setTransform(merk);
	}
	
	

}

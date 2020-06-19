package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.Timer;

import tools.Klang;
import tools.Spiel;

public class ZielFigur extends SpielFigur implements ActionListener{
	
	private boolean getroffen;
	private int animationsL�nge;
	private Klang trefferKlang;
	private Timer tick;
	private Random zufall;
		
	public ZielFigur(double xC, double yC, Spiel spiel) {
		super(xC, yC, 40, 40, spiel);
		this.setBewegung(1, 0);
		animationsL�nge = 25;
		trefferKlang = new Klang("/sound/boing.mp3"); //Platzhalter f�r die Sounddatei.
		tick = new Timer(3000,this);
		;
		
	}
	
	public void mousePressed (MouseEvent e) {
		Point mausPos = spiel.getMousePosition();
		if(mausPos != null && this.contains(e.getPoint())) {
			getroffen = true;
			trefferKlang.play();
			tick.start();
		}
	}
	
	public void zeichne (Graphics2D g) {
		g.setColor(Color.cyan);
		if(animationsL�nge > 0) {
		g.fill(this);
		}
	}
	public void bewege() {
		super.bewege();
		if(getroffen) {
			this.width = this.width/1.5;
			this.height =this.height/1.5;
			animationsL�nge--;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		reset();
	}
	
	public void reset () {
		tick.stop();
		animationsL�nge = 25;
		this.width = this.height =40;
		this.x = 20;
		getroffen = false;
		tick.setInitialDelay(2000 + zufall.nextInt(4000)); //ab hier stimmt irgendwas nicht? die Figur wird resettet, aber die Position ist immer die Selbe
		this.y = zufall.nextInt(spiel.getHeight()-51)+10;
		if (y > spiel.getHeight()/2) {
			this.setBewegung(1, zufall.nextInt(10));
		}else {
			this.setBewegung(1, -zufall.nextInt(10));
		}
		
		
	}
	
}

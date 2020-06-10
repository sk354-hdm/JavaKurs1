package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.Timer;

import tools.Klang;
import tools.Spiel;

public class ZielFigur extends SpielFigur implements ActionListener{
	
	private boolean getroffen;
	private int animationsLšnge;
	private Klang trefferKlang;
	private Timer tick;
	private Random zufall;
		
	public ZielFigur(double xC, double yC, Spiel spiel) {
		super(xC, yC, 40, 40, spiel);
		this.setBewegung(1, 0);
		animationsLšnge = 25;
		trefferKlang = new Klang("/sound/boing.mp3");
		tick = new Timer(3000,this);
		
		
	}
	
	public void mousePressed (MouseEvent e) {
		if(this.contains(e.getPoint())) {
			getroffen = true;
			trefferKlang.play();
			tick.start();
		}
	}
	
	public void zeichne (Graphics2D g) {
		g.setColor(Color.cyan);
		if(animationsLšnge > 0) {
		g.fill(this);
		}
	}
	public void bewege() {
		super.bewege();
		if(getroffen) {
			this.width = this.width/1.5;
			this.height =this.height/1.5;
			animationsLšnge--;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		reset();
	}
	
	public void reset () {
		tick.stop();
		animationsLšnge = 25;
		this.width = this.height =40;
		this.x = 20;
		getroffen = false;
		tick.setInitialDelay(2000 + zufall.nextInt(4000));
		this.y = zufall.nextInt(spiel.getHeight()-51)+10;
		if (y > spiel.getHeight()/2) {
			this.setBewegung(1, zufall.nextInt(10));
		}else {
			this.setBewegung(1, -zufall.nextInt(10));
		}
		
		
	}
	
}

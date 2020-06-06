package aufgaben;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Figuren.PlaySymbol;
import komponenten.TimerStartKnopf;
import komponenten.TimerStopKnopf;
import tools.StandardAnwendung;

public class Aufgabe18 extends StandardAnwendung implements ActionListener{
	
	private int xPos = 10;
	private PlaySymbol play = new PlaySymbol();
	
	public static void main (String [] a) {
		starteAnwendung();
	}
	
	public Aufgabe18() {
		super("Aufgabe 18",500,500);
		setBackground(Color.YELLOW);
		Timer tick = new Timer(40,this);
		TimerStartKnopf start = new TimerStartKnopf(tick);
		this.add(start);
		TimerStopKnopf stop = new TimerStopKnopf(tick);
		this.add(stop);
	}
	
	@Override
	public void zeichne(Graphics2D g) {
		g.fillOval(xPos, 50, 50, 50);
		xPos = (xPos+1) % this.getWidth();
		play.zeichne(g, xPos, 150);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		xPos = (xPos +1) % this.getWidth();
		this.repaint();
	}
}

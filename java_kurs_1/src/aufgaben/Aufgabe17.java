package aufgaben;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import komponenten.TimerStartKnopf;
import komponenten.TimerStopKnopf;
import tools.StandardAnwendung;

public class Aufgabe17 extends StandardAnwendung implements ActionListener{
	
	public static void main (String [] a) {
		starteAnwendung();
	}
	
	private int xPos = 40;
	Random zufall = new Random();
	
	public Aufgabe17() {
		super("Aufgabe 17", 500,500);
		this.setBackground(Color.black);
		Timer tick = new Timer(10,this);
		Random zufall = new Random();
		tick.start();
		TimerStartKnopf start = new TimerStartKnopf(tick);
		this.add(start);
		TimerStopKnopf stop = new TimerStopKnopf(tick);
		this.add(stop);
		}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Color farbe = new Color(zufall.nextInt(256),zufall.nextInt(256),zufall.nextInt(256));
		this.setBackground(farbe);
		this.repaint();
		
	}
	

}

package aufgaben;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import Figuren.DragAndDropFigur;
import Figuren.MausOverFarbeFigur;
import Figuren.MausOverHellerFigur;
import Figuren.SpielFigur;
import tools.Spiel;

public class Aufgabe22 extends Spiel implements ActionListener{
	
	SpielFigur figur1;
	MausOverFarbeFigur figur2;
	MausOverHellerFigur figur3;
	DragAndDropFigur figur4;
	
	public static void main(String[]args){
		starteAnwendung();
	}
	
	public Aufgabe22() {
		super("Aufgabe 22", 500,500);

		}

	
	
	@Override
	protected void initialisiere() {
		figur1 = new SpielFigur(40,40,40, 40, this);
		figur2 = new MausOverFarbeFigur(40, 100, this);
		figur3 = new MausOverHellerFigur(40, 150, Color.RED, this);
		figur4 = new DragAndDropFigur(40,200,this);
	}

	
	@Override
	protected void neuerSpielstand() {
		figur1.bewege();
		figur2.bewege();
		figur3.bewege();
		figur4.bewege();
		}

	
	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		figur1.zeichne(g);
		figur2.zeichne(g);
		figur3.zeichne(g);
		figur4.zeichne(g);
		
	}

}

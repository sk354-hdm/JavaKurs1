package aufgaben;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import tools.StandardAnwendung;

public class Aufgabe6 extends StandardAnwendung {
	
		 public static void main(String[] a){
		 starteAnwendung();
		 }
		 
		 public Aufgabe6(){
		 super("Aufgabe 6", 500, 400);
		 this.setBackground(Color.RED);
		 this.add(new JLabel("Hier nicht klicken: "));
		 JButton knopf = new JButton("Klick doch mal");
		 this.add(knopf);
		 }
		 
		}



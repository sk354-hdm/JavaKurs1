package aufgabe14;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tools.StandardAnwendung;

public class Taschenrechner extends StandardAnwendung{
	
	public static void main (String []a) {
		starteAnwendung();
	}
	
	public Taschenrechner() {
		super("Taschenrechner",600,400);
		this.setLayout(new BorderLayout());
		JTextField anzeige = new JTextField();
		this.add(anzeige, BorderLayout.NORTH);
		JPanel tastenFeld = new JPanel();
		tastenFeld.setLayout(new GridLayout(4,5));
		
		tastenFeld.add(new JButton("7"));
		tastenFeld.add(new JButton("8"));
		tastenFeld.add(new JButton("9"));
		tastenFeld.add(new JButton("+"));
		tastenFeld.add(new JButton("SQRT"));
		tastenFeld.add(new JButton("4"));
		tastenFeld.add(new JButton("5"));
		tastenFeld.add(new JButton("6"));
		tastenFeld.add(new JButton("-"));
		tastenFeld.add(new JButton("1/x"));
		tastenFeld.add(new JButton("1"));
		tastenFeld.add(new JButton("2"));
		tastenFeld.add(new JButton("3"));
		tastenFeld.add(new JButton("*"));
		tastenFeld.add(new JButton("+-"));
		tastenFeld.add(new JButton("C"));
		tastenFeld.add(new JButton("0"));
		tastenFeld.add(new JButton("."));
		tastenFeld.add(new JButton("/"));
		tastenFeld.add(new JButton("="));
		
		this.add(tastenFeld,BorderLayout.CENTER);
	}


}

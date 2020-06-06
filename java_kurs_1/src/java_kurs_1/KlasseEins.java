package java_kurs_1;

import java.awt.*;
import javax.swing.*;

public class KlasseEins {
	public static void main (String[] args) {
		JFrame fenster = new JFrame ("Aufgabe3");
		fenster .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster .setSize(600,450);
		JPanel p = new JPanel();
		p.setBackground(Color.green);
		JButton knopf = new JButton ("Do not push");
		p.add(knopf);
		fenster.add(p);
		fenster .setVisible(true);
			}
}

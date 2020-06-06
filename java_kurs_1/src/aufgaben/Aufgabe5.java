package aufgaben;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class Aufgabe5 extends JPanel{
	
	public Aufgabe5() {
		int a,b;
		a = 100;
		b = a;
		this.setBackground(Color.RED);
		JButton knopf = new JButton("Please push");
		this.add(knopf);
		JCheckBox box01 = new JCheckBox("01");
		this.add(box01);
		JRadioButton radio01 = new JRadioButton("Hallo Umbi");
		this.add(radio01);
		JSlider slider01 = new JSlider(0,100,50);
		this.add(slider01);
		JTextArea text01 = new JTextArea(10,10);
		text01.isMaximumSizeSet();
		this.add(text01);
		
	}




	public static void main (String [] a) {
		JFrame fenster = new JFrame ("Aufgabe 5");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(500,400);
		Aufgabe5 panel = new Aufgabe5();
		fenster.add(panel);
		fenster.setVisible(true);
}
}

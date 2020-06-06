package aufgaben;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aufgabe4 extends JPanel{
	
	public Aufgabe4() {
	
this.setBackground(Color.BLUE);
JButton knopf = new JButton("Do not push");
this.add(knopf);
}

	
public static void main(String [] a) {
	JFrame fenster = new JFrame("Aufgabe 4");
	fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenster.setSize(500,400);
	Aufgabe4 panel = new Aufgabe4();
	fenster.add(panel);
	fenster.setVisible(true);
	}
}




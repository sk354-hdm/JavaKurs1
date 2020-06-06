package aufgaben;

import java.awt.GridLayout;

import javax.swing.JButton;

import tools.StandardAnwendung;

public class Aufgabe9 extends StandardAnwendung{
	public static void main (String [] a) {
	starteAnwendung();
}
		
	
	public Aufgabe9() {
		super("Aufgabe 9",300,150);
		this.setLayout(new GridLayout(4,3));
		
		JButton eins = Button("1");
		this.add(eins);
		JButton zwei = Button("2");
		this.add(zwei);
		JButton drei = Button("3");
		this.add(drei);
		JButton vier = Button("4");
		this.add(vier);
		JButton fünf = Button("5");
		this.add(fünf);
		JButton sechs = Button("6");
		this.add(sechs);
		JButton sieben = Button("7");
		this.add(sieben);
		JButton acht = Button("8");
		this.add(acht);
		JButton neun = Button("9");
		this.add(neun);
		JButton stern = Button("*");
		this.add(stern);
		JButton nul = Button("0");
		this.add(nul);
		JButton raute = Button ("#");
		this.add(raute);
		
		this.fenster.setResizable(false);
		
		}
	
	public JButton Button (String a) {
		JButton knopf = new JButton(a);
		return knopf;
		}

}

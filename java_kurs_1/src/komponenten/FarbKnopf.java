package komponenten;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FarbKnopf extends JButton implements ActionListener {
	
	
	private Color farbe;
	private JPanel panel;
	Random zufall = new Random();


	public FarbKnopf (String titel,Color farbe, JPanel panel) {
		
		super(titel);
		
		this.farbe = farbe;
		this.panel = panel;
		
		this.addActionListener(this);
		this.setBackground(farbe);
		
		}
		
	
	
	public void actionPerformed(ActionEvent e) {
		
		int r,g,b;
		r = zufall.nextInt(256);
		g = zufall.nextInt(256);
		b = zufall.nextInt(256);
		panel.setBackground(new Color(r,g,b));
		
	}

}

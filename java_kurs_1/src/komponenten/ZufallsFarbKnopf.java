package komponenten;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ZufallsFarbKnopf extends JButton implements ActionListener {
	
	private JPanel panel;
	private Random zufall;
	

	public ZufallsFarbKnopf (JPanel panel){
			
			super ("Zufällige Farbe");
			
			this.panel = panel;
			
			this.addActionListener(this);
			
			this.zufall = new Random();
					
			}

	
	public void actionPerformed(ActionEvent e) {
		
		int rot = zufall.nextInt(255);
		int gruen = zufall.nextInt(255);
		int blau = zufall.nextInt(255);
		
		Color farbe = new Color (rot,gruen,blau);
		panel.setBackground(farbe);
		this.addActionListener(this);
	}
}
	
	
	
	
	



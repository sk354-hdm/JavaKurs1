package aufgabe24;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Anzeige extends JTextField {
	
	public Anzeige() {
		super();
		this.setText("0");
		this.setHorizontalAlignment(RIGHT);
		this.setEditable(false);
		this.setBackground(Color.white);
	}
	
	public void zifferEingeben(String ziffer) {
		this.setText(this.getText() + ziffer);
	}
	
	public double getWert() {
		if("".equals(this.getText())){
			return 0.0;
			}
		return Double.parseDouble(this.getText());
	}
	
}

package aufgabe24;

import java.awt.event.ActionEvent;

public class Ziffer extends Taste {
	
	public Ziffer(String wert, Anzeige anzeige) {
	super(wert, anzeige);
	
	
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( Taste.neueEingabe) {
			anzeige.setText("");
			Taste.neueEingabe = false;
			}
		anzeige.zifferEingeben(this.getText());
	}

}

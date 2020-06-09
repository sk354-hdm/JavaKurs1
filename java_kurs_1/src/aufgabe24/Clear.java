package aufgabe24;

import java.awt.event.ActionEvent;

public class Clear extends Taste {
	
	public Clear(String wert, Anzeige anzeige) {
		super(wert, anzeige);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setText("0");
		
	}
	
	

}

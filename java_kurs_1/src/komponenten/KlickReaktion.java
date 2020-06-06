package komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class KlickReaktion implements ActionListener {
	
	int count = 0;

	public void actionPerformed(ActionEvent e) {
		count++;
		JOptionPane.showMessageDialog(null, "Du hast " + count + " Mal geklickt.");
	}
}

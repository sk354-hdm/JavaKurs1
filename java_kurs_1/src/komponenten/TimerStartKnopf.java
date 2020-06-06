package komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class TimerStartKnopf extends JButton implements ActionListener{
	
	public Timer tick = new Timer(100,this);
	
	public TimerStartKnopf(Timer tick) {
		super("START");
		this.tick = tick;
		this.addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e) {
		tick.start();
	}

}

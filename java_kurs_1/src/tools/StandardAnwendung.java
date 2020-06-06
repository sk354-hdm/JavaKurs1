package tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public abstract class StandardAnwendung extends JPanel {
	
	protected JFrame fenster;      

	protected static void starteAnwendung(){		
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		String hauptKlasseName = trace[trace.length-1].getClassName();
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Class hauptKlasse = Class.forName(hauptKlasseName);
					StandardAnwendung app = (StandardAnwendung)hauptKlasse.getConstructor().newInstance();
				} catch (NoSuchMethodException e){
					JOptionPane.showMessageDialog(null, "<html>Ihre Klasse <strong>"+hauptKlasseName+
							                            "</strong> hat keinen öffentlichen Standardkonstruktor,"+
							                            "\n deshalb kann die Anwendung nicht gestartet werden!", 
							                            "Bittte korrigieren Sie Ihr Programm",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected StandardAnwendung(String titel, int b, int h){
		this.fenster = new JFrame(titel);	
		this.fenster.setSize(b, h);
		this.fenster.getContentPane().add(this);
		this.fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenster.setVisible(true);
	}
	
	public void zeichne(Graphics2D g) {		
	
	}	

	public final void paintComponent(Graphics g) { 
		super.paintComponent(g);                  
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		AffineTransform merk = g2.getTransform();
		this.zeichne(g2);
		g2.setTransform(merk);
	}
	
	public final void paint(Graphics g) { 
		super.paint(g);                   
	}
}
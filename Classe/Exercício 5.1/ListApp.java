import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		
	this.addKeyListener (
	      new KeyAdapter() {
		    public void keyPressed (KeyEvent evt) {
			if(evt.getKeyChar() == 'r') {
			         int x = rand.nextInt(350);
                                 int y = rand.nextInt(350);
                                 int w = rand.nextInt(50);
                                 int h = rand.nextInt(50);
				 int r = rand.nextInt(256);
				 int g = rand.nextInt(256);
				 int b = rand.nextInt(256);
				 int drawR = rand.nextInt(256);
				 int drawG = rand.nextInt(256);
				 int drawB = rand.nextInt(256);
                                 rs.add(new Rect(x, y, w, h, r, g, b, drawR, drawG, drawB));
				 repaint();
		         }
			 else if(evt.getKeyChar() == 'e') {
			         int x = rand.nextInt(350);
                                 int y = rand.nextInt(350);
                                 int w = rand.nextInt(50);
                                 int h = rand.nextInt(50);
	                         int r = rand.nextInt(256);
				 int g = rand.nextInt(256);
				 int b = rand.nextInt(256);
				 int drawR = rand.nextInt(256);
				 int drawG = rand.nextInt(256);
				 int drawB = rand.nextInt(256);
                                 es.add(new Ellipse(x, y, w, h, r, g, b, drawR, drawG, drawB));
				 repaint();
		         }	
	            }
	      }
	);

        this.setTitle("Lista de Retangulos");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }
	for (Ellipse e: this.es) {
	    e.paint(g);
	}
    }
}

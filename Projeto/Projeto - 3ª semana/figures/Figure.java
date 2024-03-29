package figures;

import java.awt.*;
import java.awt.event.*;

public abstract class Figure {
    public int x, y, w, h;
    public int r, g, b;
    public int drawR, drawG, drawB;
	
    public void zoom (int dw, int dh){
	    this.w += dw;
	    this.h += dh;
		
    }
	
    public void mover (int dx, int dy){
	    this.x += dx;
	    this.y += dy;
		
    }
	
    public void mudarCorContorno(int c1, int c2, int c3){
	    this.drawR = c1;
	    this.drawG = c2;
	    this.drawB = c3;
    }

    public void mudarCorFundo(int c1, int c2, int c3){
                this.r = c1;
		this.g = c2;
		this.b = c3;
    }	
	
    public abstract void paint (Graphics g);
}

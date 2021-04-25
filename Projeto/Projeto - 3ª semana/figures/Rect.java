package figures;

import java.awt.*;
import java.awt.event.*;

public class Rect extends Figure {
	Rectangle rect;
	
	public Rect (int x, int y, int w, int h, int r, int g, int b, int drawR, int drawG, int drawB) {
	    this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.r = r;
		this.g = g;
		this.b = b;
		this.drawR = drawR;
		this.drawG = drawG;
		this.drawB = drawB;
		this.rect = new Rectangle(this.x, this.y, this.w, this.h);
	}
	
	public void print() {
	    System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
	}
	
	public boolean contains(MouseEvent evt){
	    if(this.rect.contains(evt.getPoint())){
			    return true; 
		}else{
		   return false;
		}
	}
	
	public void paint (Graphics g) {
	    Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fillRect(this.x,this.y, this.w,this.h);
		g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
        g2d.drawRect(this.x, this.y, this.w, this.h);		
	}
}
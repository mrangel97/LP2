package figures;

import java.awt.*;

public class Arc extends Figure {
	int w, h, startAngle, arcAngle;
	
	public Arc (int x, int y, int w, int h, int startAngle, int arcAngle, int r, int g, int b, int drawR, int drawG, int drawB) {
	        this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
		this.r = r;
		this.g = g;
		this.b = b;
		this.drawR = drawR;
		this.drawG = drawG;
		this.drawB = drawB;
	}
	
	public void print() {
	    System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
	}
	
	public void paint (Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fillArc(this.x, this.y, this.w, this.h, this.startAngle, this.arcAngle);
		g2d.setColor(new Color(this.drawR, this.drawG, this.drawB));
                g2d.drawArc(this.x, this.y, this.w, this.h, this.startAngle, this.arcAngle);		
	}
}

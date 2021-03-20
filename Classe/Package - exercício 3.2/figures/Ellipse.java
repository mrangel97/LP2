package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse {
    int x, y;
    int w, h;
	private Color ef, ec;

    public Ellipse (int x, int y, int w, int h, Color ef, Color ec) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.ef = ef;
		this.ec = ec;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.ec);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		g2d.setColor(this.ef);
		g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}

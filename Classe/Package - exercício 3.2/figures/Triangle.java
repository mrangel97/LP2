package figures;

import java.awt.*;

public class Triangle {
    private int x, y;
    private int w, h;
    private Color lc;

    public Triangle (int x, int y, int w, int h, Color lc) {
        this.x = x;
        this.y = y;
        this.w = w;
	this.h = h;
        this.lc = lc;
    }

    private void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.lc);
        g2d.drawLine(this.x, this.y, this.w, this.h);
	g2d.setColor(this.lc);
	g2d.drawLine(this.x, this.y, this.w, this.h);
	g2d.setColor(this.lc);
	g2d.drawLine(this.x, this.y, this.w, this.h);
    }
}

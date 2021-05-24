import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
	    public int idx;
		private Figure fig;
		
		public Button(int idx, Figure fig) {
		   this.idx = idx;
		   this.fig = fig;
		   this.fig.x = 3+20;
	       this.fig.y = 3+20+idx*30;
	       this.fig.w = 30-3*2;
	       this.fig.h = 30-3*2; 
		}
        
		public boolean clicked(int x, int y){
		    return(20<=x && x<=20+30 && 20+this.idx*30<=y && y<=20+this.idx*30+30);
		}
		
		public void paint(Graphics g, boolean focused) {
			Graphics g2d = (Graphics2D) g;
		    if(focused) {
               g2d.setColor(Color.gray);
			}
            else {
               g2d.setColor(Color.cyan);
			}
            
			g2d.fillRect(20, 20+this.idx*30, 30, 30);
			g2d.setColor(Color.black);		
            g2d.drawRect(30, 20+this.idx*30, 30, 30);
            this.fig.paint(g, false);			
		}
}
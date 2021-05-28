import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Button> buts = new ArrayList<Button>();
	Figure focus = null;
	Button but_focus = null;
	int indice;
    Random rand = new Random();

    ListFrame () {
        try {   // Leitura do arquivo proj.bin
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();
		} catch(Exception x) {
		    System.out.println("ERRO!");
		}	
		
		this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					try {    // Escrita no arquivo proj.bin
					    FileOutputStream f = new FileOutputStream("proj.bin");
						ObjectOutputStream o = new ObjectOutputStream(f);
						o.writeObject(figs);
						o.flush();
						o.close();
					} catch (Exception x) {
					}	
                    System.exit(0);
                }
            }
        );
		
		setFocusTraversalKeysEnabled(false);
		
		buts.add(new Button(1, new Rect(0,0,0,0,0,0,0,0,0,0)));
	    buts.add(new Button(2, new Ellipse(0,0,0,0,0,0,0,0,0,0)));
	    buts.add(new Button(3, new Arc(0,0,0,0,180,250,0,0,0,0,0,0,0)));
	    buts.add(new Button(4, new Oval(0,0,0,0,0,0,0,0,0,0)));
		
		this.addMouseListener (
		    new MouseAdapter() {
			    public void mousePressed (MouseEvent evt) { 
				   Point pos = new Point(getMousePosition());
                   focus = null; 
                   but_focus = null;				   
				   for (Figure fig: figs){
				        if(fig.clicked(pos.x, pos.y))     
                        {
                            focus = fig;
                            figs.remove(fig);
                            figs.add(fig);
                            repaint();
                            break;
                        }
                        else
                        {
                            focus = null;
                            repaint();
                        }					
				    }
					
					for (Button but: buts) {
		               if (but.clicked(pos.x,pos.y)) {
			                but_focus = but;
			                repaint();
			                break;
			            }
		            }
					// Quando um dos botões ganha foco, é guardado o índice para saber qual a figura referente ao botão clicado
					if (but_focus != null) {
						if (but_focus.idx == 1) {
							indice = 1;
						} 
						else if (but_focus.idx == 2) {
						    indice = 2;
						}
						else if (but_focus.idx == 3) {
							indice = 3;
						}
						else if (but_focus.idx == 4) {
							indice = 4;
						}
						repaint();
					}
					// Quando está sem foco o botão e a figura, é feito, clicando no mouse, a figura referente ao último botão clicado
					if ((but_focus == null) && (focus == null)) {
						if (indice == 1) {
							figs.add(new Rect(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							indice = 0;
						} 
						else if (indice == 2) {
							figs.add(new Ellipse(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							indice = 0;
						}
						else if (indice == 3) {
							figs.add(new Arc(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50), rand.nextInt(280),rand.nextInt(280), rand.nextInt(3),0,0,0,0,0,0));
							indice = 0;
						}
						else if (indice == 4) {
							figs.add(new Oval(pos.x,pos.y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
							indice = 0;
						}
						repaint();
					}
				}
			}
		);
		
		this.addMouseMotionListener (
		    new MouseMotionAdapter() {
			    public void mouseDragged (MouseEvent evt) {         
				    Point pos = new Point(getMousePosition()); 
                    if (focus != null){
                       focus.mover(pos.x-focus.x, pos.y-focus.y);
					   repaint();
					}					
				}
			}
		);
		

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
					Point pos = new Point(getMousePosition());
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
					int start = rand.nextInt(350);
					int extent = rand.nextInt(350);
					int type = rand.nextInt(3);
					// Criação das figuras
                    if (evt.getKeyChar() == 'r') {
                        Rect r1 = new Rect(pos.x,pos.y, w,h, r, g, b, drawR, drawG, drawB);
                        figs.add(r1);
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(pos.x,pos.y, w,h, r, g, b, drawR, drawG, drawB));
                    } else if (evt.getKeyChar() == 'o') {
					    figs.add(new Oval(pos.x, pos.y, w, h, r, g, b, drawR, drawG, drawB));
					} else if (evt.getKeyChar() == 'a') {
					    figs.add(new Arc(pos.x, pos.y, w, h, start, extent, type, r, g, b, drawR, drawG, drawB));
					// Deletar a figura que estiver focada
					} else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                            figs.remove(focus);
                            focus = null;
							repaint();
                    // Movimento das figuras através dos teclados UP, DOWN, LEFT, RIGHT
					} else if(evt.getKeyCode() == KeyEvent.VK_UP){
				                if(focus != null){
                                   focus.mover(0,-1);								   
					            }								 
					} else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
					            if(focus != null){
                                   focus.mover(0,1);
								}
					} else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
					            if(focus != null){
                                   focus.mover(-1,0);
								}
					} else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
					            if(focus != null){
                                   focus.mover(1,0);
								}
					// Redimensionamento da figura focada (aumentar e diminuir de tamanho)
					} else if(evt.getKeyChar() == '+'){
					        for (Figure fig: figs){
				                if(focus == fig){
                                   fig.zoom(1,1);							   
					            }
				            }
					
					} else if(evt.getKeyChar() == '-'){
					        for (Figure fig: figs){
				                if(focus == fig){
                                   fig.zoom(-1,-1);								   
					            }
				            }
					// Mudar as cores de fundo
					} else if(evt.getKeyChar() == '1'){
					        if(focus!=null){
							   focus.mudarCorFundo(255,0,0);  // vermelho
							}	
					} else if(evt.getKeyChar() == '2'){
					        if(focus!=null){
							   focus.mudarCorFundo(0,255,0);  // verde
							}
                    } else if(evt.getKeyChar() == '3'){
					        if(focus!=null){
							   focus.mudarCorFundo(0,0,255);  // azul
							}	
                    } else if(evt.getKeyChar() == '4'){
					        if(focus!=null){
							   focus.mudarCorFundo(255,255,0); // amarelo
							}	
					// Mudar as cores de contorno
                    } else if(evt.getKeyChar() == '5'){
					        if(focus!=null){
							   focus.mudarCorContorno(255,0,0);  // vermelho
							}	
					} else if(evt.getKeyChar() == '6'){
					        if(focus!=null){
							   focus.mudarCorContorno(0,255,0);  // verde
							}
                    } else if(evt.getKeyChar() == '7'){
					        if(focus!=null){
							   focus.mudarCorContorno(0,0,255);  // azul
							}	
                    } else if(evt.getKeyChar() == '8'){
					        if(focus!=null){
							   focus.mudarCorContorno(255,255,0);  // amarelo
							}
                    // Mudança de foco da figura 							
                    } else if(evt.getKeyCode() == KeyEvent.VK_TAB){
                            for (Figure fig: figs) {
                                if (focus != fig) {
                                    focus = fig;
                                    figs.remove(fig);
                                    figs.add(fig);
                                    break;
                                }
                            }    
					}						
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
        for (Figure fig: this.figs) {
            fig.paint(g, false);
        }
		
		if(focus != null){
		    focus.paint(g, true);
		}
		
		for(Button but: this.buts) {
		    but.paint(g, but == but_focus);
		}	
    }
}

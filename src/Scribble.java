import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Graphics;
import java.util.Scanner;

public class Scribble extends JPanel{
	private int lastX = 0;
	private int lastY = 0;
	public Color couleur = Color.BLACK;
	private Point []tab;
	int i = 0;


	public Scribble(){
		this.addMouseMotionListener(new MouseMotionListener(){

			public void mouseDragged(MouseEvent e) {
				Graphics gc;
				gc = getGraphics();
				gc.setColor(couleur);
				gc.drawLine(lastX, lastY, e.getX(), e.getY());
				lastX = e.getX();
				lastY = e.getY();
				//tab[i] = new Point(lastX, lastY);
				i++;
			}
			public void mouseMoved(MouseEvent e) {
				lastX = e.getX();
				lastY = e.getY();
			}
		});

		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				Graphics gc;
				gc = getGraphics();
				char c = e.getKeyChar();

				switch (c){
				case 'r' :
					System.out.println("Coucou");
					changeCouleur(Color.RED);
					break;
				case 'b' :
					changeCouleur(Color.BLUE);
					break;
				case 'v' :
					changeCouleur(Color.GREEN);
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});}

	public void paintComponent (Graphics g){
		super.paintComponent(g);

	}
	
	
	
	public void changeCouleur(Color e){
		this.couleur = e;
	}

}


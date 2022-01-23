/**
 * VIVEK BOJJA 
 *  ID: 999901375
 * Course: MCIS 5103 (Advance Programming Concepts)  Section: 029
 */


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski {
	// Main method
	public static void main(String[] args) {
		new Sierpinski();
	}
	// constructor
	public Sierpinski() {
		JFrame gui = new JFrame();
		gui.setTitle("Sierpinski triangle");
		gui.setSize(new Dimension(1024, 768));
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pane = gui.getContentPane();
		DrawTriangle drawTriangle = new DrawTriangle();
		pane.add(drawTriangle);
		gui.setVisible(true);
	}
}

class DrawTriangle extends JPanel {

	public DrawTriangle() {
		setBackground(Color.white);
	}
	/*
	*@param g of Graphics
	*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Random rndm = new Random();
		//initialization
		int x = 512;
		int y = 382;
		int x1 = 512;
		int y1 = 109;
		int x2 = 146;
		int y2 = 654;
		int x3 = 876;
		int y3 = 654;

		Point current = new Point(x, y);
		Point vertex1 = new Point(x1, y1);
		Point vertex2 = new Point(x2, y2);
		Point vertex3 = new Point(x3, y3);

		g.setColor(Color.BLACK);

		g.drawLine(vertex1.x, vertex1.y, vertex1.x, vertex1.y);
		g.drawLine(vertex2.x, vertex2.y, vertex2.x, vertex2.y);
		g.drawLine(vertex3.x, vertex3.y, vertex3.x, vertex3.y);

		Point[] pts = { vertex1, vertex2, vertex3 };
		for (int i = 0; i < 50000; i++) {
			g.drawLine(current.x, current.y, current.x, current.y);
			current = midpoint(current, pts[rndm.nextInt(3)]);
			
		}
		g.drawString("Sierpinski Triangle", 462, 484);
	}
	/*
	*@param c and t of point
	*/
	public Point midpoint(Point c, Point t) {
		int dx = c.x - t.x;
		int dy = c.y - t.y;
		/*
		*@return new point
		*/
		return new Point((Math.round(c.x - dx / 2)), Math.round(c.y - dy / 2));
	}
}
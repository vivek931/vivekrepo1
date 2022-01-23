/**
    VIVEK BOJJA
 * ID: 999901375
 * Course: MCIS 5103 (Advance Programming Concepts)  Section: 029
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class RandomTriangles extends JPanel {
	/*
	*@param g of Graphics
	*/
	public void paint(Graphics g) {
		super.paintComponent(g);

		for (int j = 0; j < 500; j++) {
			Graphics2D g2d = (Graphics2D) g;

			float strokeThickness = 2.0f;

			BasicStroke stroke = new BasicStroke(strokeThickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2d.setStroke(stroke);

			Random randGen = new Random();
			int curHeight = this.getHeight();
			int curWidth = this.getWidth();

			int[] x = new int[30];
			int[] y = new int[30];

			for (int i = 0; i < 3; i++) {
				x[i] = randGen.nextInt(curWidth);
				y[i] = randGen.nextInt(curHeight);
			}

			for (int t = 0; t < 5; t++) {
				g2d.fillPolygon(x, y, 3);
				g2d.setColor(new Color(randGen.nextInt(256), randGen.nextInt(256), randGen.nextInt(256)));
			}
		}
	}

}

public class ColorTriangles {
	// main method
	public static void main(String[] args) {
		new ColorTriangles();
	}
	// constructor
	ColorTriangles() {
		// new JFrame object
		JFrame frame = new JFrame("Triangles");
		//RandomTrains are added to the frame
		frame.add(new RandomTriangles());

		frame.setSize(1000, 700);
		frame.setVisible(true);
	}

}
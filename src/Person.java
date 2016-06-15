import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Person extends JPanel {

	private int numleft=6;

	public void paintComponent(Graphics page) {
		int x = 300;
		int y = 100;
	
		super.paintComponent(page);
		
		//Next 4 rectangles set hanging platform
		page.setColor(Color.BLACK);
		page.fillRect(x-120, y-40, 10, 325);
		
		page.setColor(Color.BLACK);
		page.fillRect(x-120, y-40, 150, 10);
		
		page.setColor(Color.BLACK);
		page.fillRect(x+20, y-40, 10, 50);
		
		page.setColor(Color.BLACK);
		page.fillRect(x-165, y+275, 100, 10);

		if (numleft <=5){
			page.setColor(Color.BLUE);
			page.fillOval(x, y, 50, 50);
		}

		if (numleft <= 4){
			page.setColor(Color.yellow);
			page.fillRect(x, y+50, 50, 75);
		}

		if (numleft <= 3){
			page.setColor(Color.green);
			page.fillRect(x-70, y+50, 70, 20);
		}

		if (numleft <= 2){
			page.setColor(Color.red);
			page.fillRect(x+50, y+50, 70, 20);
		}

		if (numleft <= 1){
			page.setColor(Color.cyan);
			page.fillRect(x-0, y+125, 20, 125);
		}

		if (numleft <= 0){
			page.setColor(Color.magenta);
			page.fillRect(x+29, y+125, 20, 125);
		}
	}

	public int getNumLeft(){
		return numleft;
	}

	public void reset(){
		numleft = 6;
		repaint();
	}

	public void showNext(){
		numleft -= 1;
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Person");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new Person();
		panel.setPreferredSize(new Dimension(650,1000));

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}

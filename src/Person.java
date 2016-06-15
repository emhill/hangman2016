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

//	public Person(){
//		this.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				showNext();
//			}
//		});
//	}

	public void paintComponent(Graphics page) {


		int x = 100;
		int y = 150;
		
		super.paintComponent(page);
		
	

		if (numleft <=5){
			page.setColor(Color.BLUE);
			page.fillOval(x, y, 180, 180);
		}

		if (numleft <= 4){
			page.setColor(Color.yellow);
			page.fillRect(x, y+180, 190, 250);
		}

		if (numleft <= 3){
			page.setColor(Color.green);
			page.fillRect(x-200, y+185, 200, 90);
		}

		if (numleft <= 2){
			page.setColor(Color.red);
			page.fillRect(x+190, y+185, 200, 90);
		}

		if (numleft <= 1){
			page.setColor(Color.cyan);
			page.fillRect(x, y+430, 85, 250);
		}

		if (numleft <= 0){
			page.setColor(Color.magenta);
			page.fillRect(x+105, y+430, 85, 250);
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
		panel.setPreferredSize(new Dimension(1000,1000));

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}

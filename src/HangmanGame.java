import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;



public class HangmanGame extends JFrame {

	//fields for Person, AlphabetPanel, etc
	private Person p;
	private AlphabetPanel ap;
	private RandomString rs;
	private GuessPhrasePanel gp;
	private Text t; // this one should be removed after
					// creating the other panels
	
	public HangmanGame()  {
		super("Hangman Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// setup the panels
		// You should initialize each one & 
		// set its size, like I've done with this
		// Text panel (which you should delete after
		// you create your own panels)
		Person p = new Person();
		AlphabetPanel ap = new AlphabetPanel();
		RandomString rs = new RandomString("");
		GuessPhrasePanel gp = new GuessPhrasePanel("reveals FullPhrase!");
		gp.setPreferredSize(new Dimension (640, 420));
		Text t = new Text("Hello, world!");
		t.hideUnderline();
		t.setPreferredSize(new Dimension(650, 50));
		
		super.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		// the last step is to add each panel
		// to the content pane so it can be displayed
		//super.getContentPane().add(p);
		//super.getContentPane().add(ap);
		//super.getContentPane().add(rs);
		//super.getContentPane().add(gp);
		super.getContentPane().add(t);
		super.pack();
		super.setVisible(true);
	}
	
//	public void GuessPhrasePanel(char Letter){
//		gp.result = AlphabetPanel.getResult(Letter);
//	}
//	
	public void playAgain() {
		
		
	}
	
	public void reset(){
		
	}
	
	public void procesLeter(){
		
	}
	
	public static void main(String[] args) {
		new HangmanGame();
	}

}

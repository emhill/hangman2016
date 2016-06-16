import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A GUI version of the Hangman Game. The user tries to guess letter in a
 * secret word and loses it after 6 guesses that are not in the word. The user
 * guesses a letter by clicking a button whose text is that letter.
 */

public class HangmanGame extends JFrame {
	// fields for Person, AlphabetPanel, etc
	private Person p; // the central panel of the GUI, where things are drawn.
	private AlphabetPanel ap; // An Object holding the list of possible words that can be used in the game.
	private RandomString rs; 
	private GuessPhrasePanel gp; // A String containing all the letters that the user has guessed so far.
	private Text t;    
	private Text win;  // If the user WIN the game "Spelled all the correct letters"
	private Text lose; // If the user LOSE the game "if number of wrong letters exceeds the limit"

	/**
	 * This constructor that creates the main panel, which is represented 
	 * by this class. It makes all the JOption, Box layout and sub panels and adds
	 * them to the main panel.
	 */
	
	public HangmanGame() {
		super("Hangman Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
		
		p = new Person();
		p.setPreferredSize(new Dimension(650, 500));
		ap = new AlphabetPanel();
		rs = new RandomString("guess_phrases.txt");
		gp = new GuessPhrasePanel(rs.next());
		gp.setPreferredSize(new Dimension(640, 100));
		
		t = new Text("Reveal Full Phrase: Enter / New Game: SpaceBar");
		t.hideUnderline();
		t.setPreferredSize(new Dimension(650, 50));
		
		win = new Text("You win!");
		win.hideUnderline();
		win.setPreferredSize(new Dimension(650, 50));
		win.hideText();
		
		lose = new Text("You lose!");
		lose.hideUnderline();
		lose.setPreferredSize(new Dimension(650, 50));
		lose.hideText();

		super.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		super.getContentPane().add(ap);
		super.getContentPane().add(p);
		super.getContentPane().add(gp);
		super.getContentPane().add(win);
		super.getContentPane().add(lose);
		super.getContentPane().add(t);
		super.pack();
		super.setVisible(true);

		this.setFocusable(true); // enables frame to listen to key events
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				processLetter(c);
				System.out.println("Key Listener");
			}
		});
	}
	
	/**
	 * This method will reset the alphabetical order back its state
	 * It picks a new secret word, initialize all the variables that record the state of the game.
	 */
	
	public void reset() {
		p.reset();
		gp.setPhrase(rs.next());
		ap.reset();
		win.hideText();
		lose.hideText();
	}
	/**
	 *JOPtionpane to prompt user Confirmation.
	 *This method should be called any time a game ends i.e. "win or lose"
	 */
	public void playAgain() {
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to play again?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			System.out.println("No button clicked");
			System.exit(0);
		} else if (response == JOptionPane.YES_OPTION) {
			System.out.println("Yes button clicked");
			this.reset();
		} else if (response == JOptionPane.CLOSED_OPTION) {
			System.out.println("JOption closed");
		}
	}
	
	//This method makes the game work properly
	//Processes the letter that is pressed and goes through method
	private void processLetter(char c) {
		c = Character.toUpperCase(c);
		if (c >= 'A' && c <= 'Z') {
			if (gp.hasLetter(c) == true) {
				gp.revealLetter(c);
				ap.setLetterColor(c, Color.GREEN);
				if (gp.isFullPhraseRevealed() == true) {
					win.showText();
					playAgain();
				}
			} else if (p.getNumLeft() > 0) {
				if (!ap.hasLetterBeenSeen(c)) {
				p.showNext();
				ap.setLetterColor(c, Color.RED);
					if (p.getNumLeft() == 0) {
						lose.showText();
						playAgain();
					}
				}
			}
		} else if (KeyEvent.VK_ENTER == c) {
			gp.revealFullPhrase();
			lose.showText();
			p.showNext();
			p.showNext();
			p.showNext();
			p.showNext();
			p.showNext();
			p.showNext();
			playAgain();
		} else if (KeyEvent.VK_SPACE == c) {
			reset();
		} 
	}
	
	/**
	 * This main program make it possible to run this class as an application.
	 * The main routine creates a frame,sets it to contain panel of type
	 * Hangman, and shows the frame in the center of the screen.
	 **/
	public static void main(String[] args) {
		new HangmanGame();
	}

}

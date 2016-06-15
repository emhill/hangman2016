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

public class HangmanGame extends JFrame {
	// fields for Person, AlphabetPanel, etc
	private Person p;
	private AlphabetPanel ap;
	private RandomString rs;
	private GuessPhrasePanel gp;
	private Text t;
	private Text win;
	private Text lose;

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
	
	public void reset() {
		p.reset();
		gp.setPhrase(rs.next());
		ap.reset();
		win.hideText();
		lose.hideText();
	}
	
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
	
	private void processLetter(char c) {
		c = Character.toUpperCase(c);
		if (c >= 'A' && c <= 'Z') {
			if (gp.hasLetter(c) == true) {
				gp.revealLetter(c);
				ap.setLetterColor(c, Color.GREEN);
				if (gp.isFullPhraseRevealed() == true) {
					win.showText();
					playAgain();
				} else if (p.getNumLeft() <= 0) {
					
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
		} else if (KeyEvent.VK_SPACE == c) {
			reset();
		} else if (KeyEvent.VK_OPEN_BRACKET == c) {
			playAgain();
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

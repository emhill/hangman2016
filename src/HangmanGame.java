import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class HangmanGame extends JFrame {
	// fields for Person, AlphabetPanel, etc
	private Person p;
	private AlphabetPanel ap;
	private RandomString rs;
	private GuessPhrasePanel gp;
	private String word;

	public HangmanGame() {
		super("Hangman Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
		
		Person p = new Person();
		AlphabetPanel ap = new AlphabetPanel();
		RandomString rs = new RandomString("");
		GuessPhrasePanel gp = new GuessPhrasePanel(rs.next());
		gp.setPreferredSize(new Dimension(640, 500));

		 Text t = new Text("Reveal Full Phrase: Enter / New Game: SpaceBar");
		 t.hideUnderline();
		 t.setPreferredSize(new Dimension(650, 50));

		super.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		super.getContentPane().add(p);
		super.getContentPane().add(ap);
		super.getContentPane().add(gp);
		super.getContentPane().add(t);
		super.pack();
		super.setVisible(true);

		this.setFocusable(true); // enables frame to listen to key events
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				c = Character.toUpperCase(c);
				if (c >= 'A' && c <= 'Z') {
					if (gp.hasLetter(c) == true) {
						gp.revealLetter(c);
						ap.setLetterColor(c, Color.GREEN);
						if (gp.isFullPhraseRevealed()) {
							Text t = new Text("Full Phrase Revealed!");
							t.hideUnderline();
							t.setPreferredSize(new Dimension(650, 50));
						} else if (p.getNumLeft() <= 0) {
							Text t = new Text("You lose!");
							t.hideUnderline();
							t.setPreferredSize(new Dimension(650, 50));
						}
					} else if (p.getNumLeft() > 0) {
						// if (!ap.hasLetterBeenSeen(c)) {
						p.showNext();
						ap.setLetterColor(c, Color.RED);
						if (p.getNumLeft() == 0) {
							wantToRestart();
						}
					}
				} else if (KeyEvent.VK_ENTER == c) {
					gp.revealFullPhrase();
				} else if (KeyEvent.VK_SPACE == c) {
					p.reset();
					gp.setPhrase(rs.next());
					ap.reset();
				}
				System.out.println("Key Listener");
			}
		});
	}

	private void wantToRestart() {

	}

	public void reset() {
		p.reset();
		gp.setPhrase(rs.next());
		ap.reset();
	}

	/**
	 * This main program make it possible to run this class as an application.
	 * The main routine creates a frame,sets it to contain panel of type
	 * Hangman, and shows the frame in the center of the screen.
	 **/
	public static void main(String[] args) {
		new HangmanGame();
		JFrame frame = new JFrame("Hangman");// The frame, with "Hangman" in the
												// title bar.
		HangmanGame frame1 = new HangmanGame();// the main frame for the window.
		frame.getContentPane();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End of the
																// program if
																// the user
																// closes the
																// frame.
		// System.out.println("Click Yes to Restart");

		frame1.pack(); // Sets the size of the frame based on the preferred
						// sizes of what it contains.
		frame1.setVisible(true); // Make the frame visible on the screen.
	}

}

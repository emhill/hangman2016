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

	public HangmanGame() {
		super("Hangman Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setFocusable(true); // enables frame to listen to key events
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				System.out.println("Key Listener");
			}
		});

		Person p = new Person();
		AlphabetPanel ap = new AlphabetPanel();
		RandomString rs = new RandomString("");
		GuessPhrasePanel gp = new GuessPhrasePanel("reveals FullPhrase!");
		gp.setPreferredSize(new Dimension(640, 420));

		Text t = new Text("Hello, world!");
		t.hideUnderline();
		t.setPreferredSize(new Dimension(650, 50));

		super.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		super.getContentPane().add(p);
		// super.getContentPane().add(ap);
		// super.getContentPane().add(rs);
		super.getContentPane().add(gp);
		super.getContentPane().add(t);
		super.pack();
		super.setVisible(true);
	}

	public void processLetter(char c) {
		if (c >= 'A' && c <= 'Z') {
			if (gp.hasLetter(c) == true) {
				gp.revealLetter(c);
				//ap.setLetterColor(Color.GREEN);
				if (gp.isFullPhraseRevealed()) {
					wantToRestart();
				}
			} else if (p.getNumLeft() > 0) {
				//if (!ap.hadLetterBeenSeen(c)) {
					p.showNext();
					//ap.setLetterColor(Color.RED);
					if (p.getNumLeft() == 0) {
						wantToRestart();
					}
				}
			}// else {
				//wantToRestart();
			}
//		} else if (KeyEvent.VK_ENTER == c) {
//			gp.revealFullPhrase();
//		} else if (KeyEvent.VK_SPACE == c) {
//			reset();
//		}
//	}

	private void wantToRestart() {

	}

	public void reset() {
		p.reset();
		// gp.setGuessPhrase(rs.next());
		ap.reset();
	}

	public static void main(String[] args) {
		new HangmanGame();
		HangmanGame frame = new HangmanGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Click Yes to Restart");

		frame.pack();
		frame.setVisible(true);
	}

}

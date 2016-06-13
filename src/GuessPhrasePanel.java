import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


public class GuessPhrasePanel extends JPanel {
	private String guessPhrase;
	
	public GuessPhrasePanel(String guessPhrase){
		this.guessPhrase=guessPhrase;
		this.setPhrase(guessPhrase);
		
	}
	
	/*sets a new phrase to this GuessPhrase object,
	gets rid of old phrase parts and creates new ones
	*/
	public void setPhrase(String guessPhrase){

		for (char ch: guessPhrase.toCharArray()){
			Text t = new Text(Character.toString(ch));
			t.setUnderlineColor(Color.black);
			t.showUnderline();
			t.hideText();
			this.add(t);
		}   

		
	}

	//returns whether or not a specified letter is in the phrase
	public boolean hasLetter (char c){
		return false;
	}
	//reveals or shows a specified letter
	public void revealLetter(char c){
		
	}
	//returns whether or not the full phrase has been revealed
	public boolean isFullPhraseRevealed(){
		return false;
	}
	//reveals the full phrase
	public String revealFullPhrase(){
		return guessPhrase;
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame ();
		JPanel panel = new GuessPhrasePanel("hello");
		frame.getContentPane().add(panel);
		frame.pack();
	    frame.setVisible(true);
		
	}

}

import javax.swing.JPanel;

public class GuessPhrasePanel extends JPanel {
	private String guessPhrase;
	
	public GuessPhrasePanel(String guessPhrase){
		this.guessPhrase=guessPhrase;
	}
	/*sets a new phrase to this GuessPhrase object,
	gets rid of old phrase parts and creates new ones
	*/
	public void setPhase(String phrase){
		this.guessPhrase=phrase;
		
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
		// TODO Auto-generated method stub

	}

}

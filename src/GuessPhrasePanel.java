import javax.swing.JPanel;

public class GuessPhrasePanel extends JPanel {
	private String guessPhrase;
	
	public GuessPhrasePanel(String guessPhrase){
		this.guessPhrase=guessPhrase;
	}
	public void setPhase(String phrase){
		this.guessPhrase=phrase;
		
	}
	public boolean hasLetter (char c){
		return false;
	}
	public void revealLetter(char c){
		
	}
	public boolean isFullPhraseRevealed(){
		return false;
	}
	public String revealFullPhrase(){
		return guessPhrase;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

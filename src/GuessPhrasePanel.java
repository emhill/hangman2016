import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;


public class GuessPhrasePanel extends JPanel {
	private String guessPhrase;
	private ArrayList<Text>list=new ArrayList();

	public GuessPhrasePanel(String guessPhrase){
		this.guessPhrase=guessPhrase;
		this.setPhrase(guessPhrase);		
	}

	private void initializeLetters(){
		this.removeAll();
		this.updateUI();
		this.revalidate();
	}

	/*sets a new phrase to this GuessPhrase object,
gets rid of old phrase parts and creates new ones
	 */
	public void setPhrase(String guessPhrase){
		this.initializeLetters();

		for (char ch: guessPhrase.toCharArray()){
			Text t = new Text(Character.toString(ch));
			t.setUnderlineColor(Color.black);
			if (ch == ' '  ){
				t.hideUnderline();
			}
			else{
				t.showUnderline();
				t.hideText();
			}
			this.add(t);
			list.add(t);
		}
	}   

	//returns whether or not a specified letter is in the phrase
	public boolean hasLetter (char c){
		for (Text t: list)
			if (t.getText().equalsIgnoreCase(Character.toString(c)))
					return true;

			return false;

	}
	//reveals or shows a specified letter
	public void revealLetter(char c){
//		for (int n=0; )
//			this.getComponent(n){
//
//			if (ch == c){
//				t.showText();
//				t.hideUnderline();	
//			}
		
	}


//	returns whether or not the full phrase has been revealed
	public boolean isFullPhraseRevealed(){
		return false;
	}
	//reveals the full phrase
	public String revealFullPhrase(){
		return guessPhrase;
	}


	public static void main(String[] args) {
		JFrame frame = new JFrame ();
		GuessPhrasePanel phrase = new GuessPhrasePanel("Random String");
		//		phrase.revealLetter('a');
		System.out.println(phrase.hasLetter('A'));
		System.out.println(phrase.hasLetter('z'));
		JPanel panel = phrase;

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);


	}

}


//public void revealLetter(char c){
//	for (char ch: guessPhrase.toCharArray()){
//	Text t = new Text(Character.toString(ch));
//	if (ch == c){
//		t.showText();
//		t.hideUnderline();	
//	}

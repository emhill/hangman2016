import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.*;



public class AlphabetPanel extends JPanel {
	
	
	
	public boolean beenSeen;
	public boolean vowel;
	public Color LetterColor;
	
	public static char [] alpha  = {'A','B','C','D','E','F','G','H',
	'I','J','K','L','M','N','O','P','Q','R','S',
	'T','U','V','W','X','Y','Z'};
	
	
	public static char [] vowels  = {'A','E','I','O','U'};
	public String Letters, letter, letter1;
	public int num;
	public int x;
	public char c;
	
		
	public AlphabetPanel(){
		

		
		for( c = 'A'; c <= 'Z'; c++){
			letter = Character.toString(c);
			Text c = new Text(letter);
			c.showText();	
			c.hideUnderline();
			this.add(c);
		}
		
		
		
	}
		
		

		
		
		public void reset(){
			Component c = this.getComponent(3);
			c.setBackground(Color.RED);
			repaint();
			}
		
		
				
		public void setLetterColor(String Letters){
			int i;
			LetterColor = Color.RED;
			for(i=0; 1 < vowels.length; i++){
					if(Letters.contains(String.valueOf(vowels[i]))) {
						LetterColor = Color.GREEN;
					}
			}
			num = (Letters.charAt(0) - 'A');
			x = num;
			repaint();
		}

		
		
		public Color getLetterColor(){
			
			return LetterColor;
		}
		
		public boolean hasLetterBeenSeen(){
		
			return beenSeen;
		}
			
		public boolean isVowel(){
			
			return vowel;
			
		}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AlphabetPanel AP = new AlphabetPanel();
		
		
		
		JFrame frame = new JFrame("ALPHABET PANEL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JPanel AlphabetPanel = new JPanel();				
		AP.setPreferredSize (new Dimension (700,50)) ;
		
		frame.getContentPane().add(AlphabetPanel);
		frame.pack();
		frame.setVisible(true);
		
	}
}

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
	
	
	public Color color;
	
	
	
//	int n = 1;
//	
//	char[] Char_Array = new char[n]; 
	
	
	
	
	
	
	
	
		
	public AlphabetPanel(){
		

		
		for( c = 'A'; c <= 'Z'; c++){
			letter = Character.toString(c);
			Text c = new Text(letter);
			c.setLetterColor(Color.black);
			c.showText();	
			c.hideUnderline();
			this.add(c);
		}
		
	}

	// make second array
	//2 arrays
	
	
		
		public void reset(){
			Component c = this.getComponent(3);
			c.setBackground(Color.RED);
			repaint();
			}
		
		
				
//		public void setLetterColor(String Letter){// char c, Color color
//			int i;
//			LetterColor = Color.RED;
//			for(i=0; 1 < vowels.length; i++){
//					if(Letters.contains(String.valueOf(vowels[i]))) {
//						LetterColor = Color.GREEN;
//					}
//			}
//			num = (Letters.charAt(0) - 'A');
//			x = num;
//			repaint();
//		}

		
		int n = 1;
	
		char[] Char_Array = new char[n]; 
		
		
		
		
		
			//Color color = Color.blue;
		
		
		
		public AlphabetPanel(Color color){
			this.color = color;
		}
		
		
		public void setLetterColor(char c, Color color){
			
			
			
			for (int i = 0; i < Char_Array.length; i++){
				
				Char_Array [i] = c;
				
			}
			System.out.print(c);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public Color getLetterColor(){// char c: return Color
			
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
		
		frame.getContentPane().add(AP);
		frame.pack();
		frame.setVisible(true);
		
		int i = 0;

		
		for(i=0; i < vowels.length; i++){
			
			AP.setLetterColor(vowels[i], Color.blue);
			
			}
		
		
		
		
		//.setLetterColor('A',Color.blue);
		
		AP.setLetterColor('A',Color.blue);

		
		
		
	}
	}
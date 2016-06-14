import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.*;



public class AlphabetPanel extends JPanel {
	

	public boolean beenSeen;
	public boolean vowel;
	public Color LetterColor;
	
	//public static char [] alpha  = {'A','B','C','D','E','F','G','H',
	//'I','J','K','L','M','N','O','P','Q','R','S',
	//'T','U','V','W','X','Y','Z'};
	
	private ArrayList<Text> list;
	
	
	
	
	public static char [] vowels  = {'A','E','I','O','U'};
	public String Letters, letter, letter1;
	public int num, x;
	
	public char c;
	
	
	public Color color;

	

	
		
	public AlphabetPanel(){
		list = new ArrayList<Text>();
		for( c = 'A'; c <= 'Z'; c++){			//Create a character c that will loop from  "A" to "Z"
			
			

			letter = Character.toString(c);		//Create a string letter that is equal to  "A" to "Z" 
			Text c = new Text(letter);			//Create a text object c(A to Z) that has a label letter(A to Z)
												
			c.setLetterColor(Color.black);		//Set the object letter color
			c.showText();						//Make the object visable
			c.hideUnderline();					//Remove any underlines from the object
			
			list.add(c);						//add the object to the arraylist 
			
			
			
			this.add(c);						//add the object to the Alphabet panel
		}
		
	}


	
		
		public void reset(){
			Component c = this.getComponent(3);
			c.setBackground(Color.RED);
			repaint();
			}
		
		

		
		

		
		public void setLetterColor(char c, Color color){
			//a = 65
			
			//cost = list.get(i).getPrice();
			
			for(int i = 0; i < list.size(); i++){
	
			list.get(c - 65).setLetterColor(color);
			}
			
			//System.out.println((int)c);
		}

		

		
		public Color getLetterColor(char c){// char c: return Color
			
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
		
		
		AP.setLetterColor('A',Color.blue);
		AP.setLetterColor('D',Color.red);
		
	}
	}
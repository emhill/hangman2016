import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.*;



public class AlphabetPanel extends JPanel {
	

	public boolean beenSeen;
	public boolean vowel;
	public Color LetterColor;
	private ArrayList<Text> list;
	public String Letters, letter, letter1;
	public int num, x, i;
	public char c;
	public Color color;
	

	
	
		
	public AlphabetPanel(){
		list = new ArrayList<Text>();
		for( c = 'A'; c <= 'Z'; c++){           //Create a character c that will loop from  "A" to "Z" 
			
			letter = Character.toString(c);     //Create a string letter that is equal to  "A" to "Z" 
			Text c = new Text(letter); 			//Create a text object c(A to Z) that has a label letter(A to Z)
			c.setLetterColor(Color.black);		//Set the object letter color
			c.showText();						//Make the object visable
			c.hideUnderline();					//Remove any underlines from the object
			
			list.add(c);						//add the object to the arraylist 
						
			this.add(c);						//add the object to the Alphabet panel
		}
		
	}

			
		public void reset(){
			for(int i = 0; 1 < 26; i++){
				list.get(i).setLetterColor(Color.BLACK);		//get the object (i) from the arraylist and set its letter color 
			}}
		
		
		
		public void setLetterColor(char c){
			//A = 65
			
			list.get(c - 65).setLetterColor(Color.RED);
			if(isVowel(c) == true){		
				list.get(c - 65).setLetterColor(Color.GREEN);
			}
			}

		
		public Color getLetterColor(char c){// char c: return Color
			Color Letc = list.get(c - 65).getLetterColor();
			return Letc;
		}
		
		public boolean hasLetterBeenSeen(char c){ //Color color
			beenSeen = false;
			if(getLetterColor(c).equals (Color.MAGENTA)){
				beenSeen = true;
		}
			return beenSeen;
		}
		
			
		public boolean isVowel(char c ){
			vowel = false;
			
				if(list.get(c - 65).equals (list.get(0))){
					vowel = true;}
				else if (list.get(c - 65).equals (list.get(4))){
					vowel = true;}
				else if (list.get(c - 65).equals (list.get(8))){
					vowel = true;}
				else if (list.get(c - 65).equals (list.get(14))){
					vowel = true;}
				else if (list.get(c - 65).equals (list.get(20))){
					vowel = true;}
								
							
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
		
		
		
		Scanner scnr = new Scanner(System.in);
		
		
		System.out.print("Enter a char: ");
		char x = 0;
			//while (x!= '/'){
			while (x!= ){
				x = scnr.next().charAt(0);
				char fUpper = Character.toUpperCase(x);
				AP.setLetterColor(fUpper);
				}
		
		
		scnr.close();
//		.setLetterColor('A',Color.blue);
		
//		AP.setLetterColor('A',Color.blue);
//		AP.setLetterColor('D',Color.red);
//		AP.reset();
	}
	}
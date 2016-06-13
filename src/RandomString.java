import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomString {

	public RandomString(String filename){
		
	}
	
	public String next(){
		return "Test";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lines = new ArrayList<String>();

		Scanner s;
		try {
			s = new Scanner( new File("guess_phrases.txt"));
			while (s.hasNext()){
				   String line = s.nextLine(); // get input
				   System.out.println(line);   // print line
				   lines.add(line);            // add line to array list

				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

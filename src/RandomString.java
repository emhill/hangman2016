import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomString {

	private String filename;
	private ArrayList<String>lines;
	private ArrayList<String>used;

	public RandomString(String filename){
		this.filename = filename;
		lines = new ArrayList<String>();
		used = new ArrayList<String>();

		Scanner s;
		try {
			s = new Scanner( new File("guess_phrases.txt"));
			while (s.hasNext()){
				String line = s.nextLine(); // get input
				lines.add(line);            // add line to array list

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String next(){
		if(lines.isEmpty()){
			lines = used;
		}
		Random generator = new Random();
		int num1;
		num1 = generator.nextInt(lines.size());
		used.add(lines.get(num1));
		String a = lines.get(num1);
		lines.remove(num1);
		return a;

	}


	public static void main(String[] args) {
		RandomString a = new RandomString("guess_phrases.txt");
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.next());
	}

}
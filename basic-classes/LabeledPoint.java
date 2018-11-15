/**
 *  Program #4a
 *  This program creates a new class called LabeledPoint.
 *  Users can give their point a coordinate and a name.
 *  CS108-2
 *  10-18-16
 *  @author  Joseph Tinglof
 */
import java.util.Scanner;

public class LabeledPoint {
	private int x; 
	private int y;
	private String label;

	//constructor for the Labeled Point
	public LabeledPoint(int x, int y, String label){
		this.x = x;
		this.y = y;
		this.label = label;
	}

	//Method for printing out all data about a point.
	@Override
	public String toString(){
		return this.x + " " + this.y + " " + this.label;
		
	}

	public static void main(String[] args) {
		System.out.println("Program 4, Joseph Tinglof, masc0752");
		Scanner radar = new Scanner(System.in);
		
		System.out.println("Please enter the X, the Y and the label of the point.");
		String label = radar.nextLine();
		int x = radar.nextInt();
		int y = radar.nextInt();
		
		LabeledPoint newCord = new LabeledPoint(x, y, label);
		System.out.println(newCord);
	}

}


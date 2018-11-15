/**
 *  Program #4c
 *  This program creates a subclass of the Rectangle class 
 *  with the ability to calculate area and perimeter. 
 *  CS108-2
 *  10-18-16
 *  @author  Joseph Tinglof
 */
import java.awt.Rectangle;
import java.util.Scanner;

public class BetterRectangle extends Rectangle{
	public int recArea;
	public int recPerimeter;
	
	//Constructor for the improved rectangle
	public BetterRectangle(int x, int y, int width, int height){
		this.setLocation(x, y);
		this.setSize(width, height);
	}
	
	//Calculates and returns the parameter of the rectangle.
	public int getPerimeter(){
		recArea = (int) ((2*getWidth()) + (2*getHeight()));
		return recArea;
		
	}
	
	//Calculates and returns the parameter of the rectangle.
	public int getArea(){
		recPerimeter = (int) (getWidth() * getHeight());
		return recPerimeter;
	}

	public static void main(String[] args) {
		System.out.println("Program 4, Joseph Tinglof, masc0752");
		Scanner radar = new Scanner(System.in);
		
		System.out.println("Please enter the X, the Y, the width and the height of the rectangle.");
		int x = radar.nextInt();
		int y = radar.nextInt();
		int width = radar.nextInt();
		int height = radar.nextInt();
		
		BetterRectangle shape = new BetterRectangle(x, y, width, height);
		System.out.println("Area of " + width + " and " + height + " is " + shape.getArea());
		System.out.println("Perimeter of " + width + " and " + height + " is " + shape.getPerimeter());
		System.out.println(shape.getLocation());
	}
}
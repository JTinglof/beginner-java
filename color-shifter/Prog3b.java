import java.util.Scanner;

/**
 *  This program will take a image and return copies color shifted
 *  to appear grey, blue, red and green.
 *  10-4-16
 *  @author  Joseph Tinglof
 */
public class Prog3b {

	public static void main(String[] args) {
		System.out.println("Program 3, Joseph Tinglof, masc0752");
		
		Scanner scan = new Scanner(System.in);
		ImageConverter ic = new ImageConverter();
		int x=30,y=30;	// test pixel values
		
		//user sends name of file
		String filename = scan.next();
		
		//program processes if file is found and is a jpg
		if (ic.readImage(filename) < 0)
			System.exit(1);
		ic.test(x, y);
		//Execute greyscale method
		ic.toGrayscale();
		ic.test(x,y);
		//outputs new imagine file
		if (ic.writeImage() < 0)
			System.exit(1);
		
		//reads imagine back into buffer
		if (ic.readImage(filename) < 0)
			System.exit(1);
		//creates the red imagine
		ic.toRed();
		ic.test(x,y);
		//outputs new imagine file
		if (ic.writeImage() < 0)
			System.exit(1);

		//same process to reread, blue-shift and create new image
		if (ic.readImage(filename) < 0)
			System.exit(1);
		ic.toBlue();
		ic.test(x,y);
		if (ic.writeImage() < 0)
			System.exit(1);

		//creates the green image
		if (ic.readImage(filename) < 0)
			System.exit(1);
		ic.toGreen(); 
		ic.test(x,y);
		if (ic.writeImage() < 0)
			System.exit(1);

	}

}

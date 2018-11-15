/**
 *  Program #3
 *  This program will take a image and return copies color shifted
 *  to appear grey, blue, red and green.
 *  CS108-2
 *  10-4-16
 *  @author  Joseph Tinglof
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * class ImageConverter for jpg
 * TODO:  description
 * Methods can return negative value if read/write fail. 
 * Does not call System.exit().
 */
public class ImageConverter {
	// Private instance variables
	private BufferedImage img = null;
	private String baseFile = "";
	private String color = "";
	private String ext = "jpg";
	
	/**
	 * Read image file into buffer
	 * @param String name of local image file
	 * @return int success=0, failure=-1
	 */
	public int readImage(String filename) {
		File pic = new File(filename);
		try {
			if (!pic.exists())
				throw new IOException("Cannot find" + pic);	
			if (pic.canRead()) {
				img = ImageIO.read(pic);
				baseFile = filename.substring(0,filename.lastIndexOf('.'));
			}
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return -1;
		}
		return 0;
	}
	/**
	 * Replace each img pixel with its R+G+B average
	 */
	public void toGrayscale() {
		for (int y = 0; y < getHeight(); ++y ) {
			for (int x = 0; x < getWidth(); ++x ) {
				int p = img.getRGB(x, y);
				
				int t = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;
				
				int avg = (r + g + b) / 3;
				
				// replace RGB with average value
				p = (t<<24) | (avg<<16) | (avg<<8) | avg;
				
				// update pixel
				img.setRGB(x, y, p);
				
				setColor("Grayscale");
			}
		}
	}
	/**
	 * Replace each img pixel with only its Red component
	 * leaving transparency intact
	 */
	public void toRed() {
		for (int y = 0; y < getHeight(); ++y ) {
			for (int x = 0; x < getWidth(); ++x ) {
				int p = img.getRGB(x, y);
				
				int t = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = 0;
				int b = 0;
				
				// replace RGB with only red value
				p = (t<<24) | (r<<16) | g | b;
				
				// update pixel
				img.setRGB(x, y, p);
				
				//for file name later
				setColor("Red");
			}
		}		
	}
	/**
	 * Replace each img pixel with only its Green component
	 * leaving transparency intact
	 */
	public void toGreen() {
		for (int y = 0; y < getHeight(); ++y ) {
			for (int x = 0; x < getWidth(); ++x ) {
				int p = img.getRGB(x, y);
				
				int t = (p>>24)&0xff;
				int r = 0;
				int g = (p>>8)&0xff;
				int b = 0;
				
				
				// replace RGB with only green value
				p = (t<<24) | r | (g<<8) | b;
				
				// updates pixel
				img.setRGB(x, y, p);
				
				//for file name later
				setColor("Green");
			}
		}
	}
	/**
	 * Replace each img pixel with only its Blue component
	 * leaving transparency intact
	 */
	public void toBlue() {
		for (int y = 0; y < getHeight(); ++y ) {
			for (int x = 0; x < getWidth(); ++x ) {
				int p = img.getRGB(x, y);
				
				int t = (p>>24)&0xff;
				int r = 0;
				int g = 0;
				int b = p&0xff;
				
				// replace RGB with only blue value
				p = (t<<24) | r | g | b;
				
				// update pixel
				img.setRGB(x, y, p);
				
				// file name for later
				setColor("Blue");
			}
		}
	}
	/**
	 * Create new file from current img buffer. Adds current value of 
	 *    color variable to sourceFile name.
	 *    Example: myImageFile.jpg --> myImageFileGrayscale.jpg
	 * @return int success=0, failure=-1
	 */
	public int writeImage() {
		File writeOut = new File(appendColorToOutput());
		try {
			ImageIO.write(img, ext, writeOut);
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return(-1);
		}	
		return 0;
	}
	
	// Helper methods
	
	/**
	 * Append filename with color inserted before .jpg
	 * @return String modified filename
	 */
	private String appendColorToOutput() {
		return baseFile + "Grayscale" + "." + ext;
	}
	/**
	 * Get img y dimension
	 * @return int height
	 */
	private int getHeight(){
		return img.getHeight();
	}
	/**
	 * Get img x dimension
	 * @return int width
	 */
	private int getWidth() {
		return img.getWidth();
	}
	/**
	 * Update private color variable
	 * @param String c color name to append to sourceFile
	 */
	private void setColor(String c) {
		color = c;
	}
	/*
	 * Output the value of img(x,y) pixel
	 */
	public void test(int x, int y) {
		int p = img.getRGB(x, y);
		int r = (p>>16)&0xff;
		int g = (p>>8)&0xff;
		int b = p&0xff;
		System.out.println("RGB: " + r + ":" + g + ":" + b);
	}	
}

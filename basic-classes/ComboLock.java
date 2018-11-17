/**
 *  This program will simulate a combination lock.
 *  CS108-2
 *  @author  Joseph Tinglof
 */
import java.util.Scanner;

public class ComboLock {
	private int currentNumber = 0; 
	boolean tumbler1 = false; 
	boolean tumbler2 = false; 
	boolean tumbler3 = false; 
	int code1; 
	int code2; 
	int code3; 
	int turn = 0; 
	
	//constructor for the lock
	public ComboLock (int code1, int code2, int code3){
		this.code1 = code1; 
		this.code2 = code2; 
		this.code3 = code3; 
	}
	
	//Method for reseting the code in the lock
	public void reset (){
		currentNumber = 0;
		tumbler1 = false; 
		tumbler2 = false; 
		tumbler3 = false; 
		turn = 0; 
	}
	
	//will move the lock the desired clicks to the left 
	public void turnLeft (int clicks){
		currentNumber = currentNumber - clicks;
		turn++; 
		if (currentNumber < 0){
			currentNumber = currentNumber + 40; 
		}
		if(currentNumber == this.code2){
			tumbler2 = true;
		}
	}
	
	//will move the lock the desired clicks to the right
	public void turnRight (int clicks){
		currentNumber = (clicks + currentNumber)%40; 
		turn++; 
		if(turn == 1){
			if(currentNumber == this.code1){
				tumbler1 = true;
			}
		}
		else if (turn == 3){
			if(currentNumber == this.code3){
				tumbler3 = true;
			}
		}
		
	}
	
	//Once the user enters the correct combination the lock's open state is
	//set to true.
	public boolean open (){
		if (tumbler1 == true && tumbler2 == true && tumbler3 == true){
			return true;
		}
		else{
			return false; 
		}
	}

	public static void main(String[] args){
		
		System.out.println("Program 3, Joseph Tinglof, masc0752");
		
		Scanner radar = new Scanner(System.in); 
		int clicks = 0; 
		
		System.out.println("Input new locker combo");
		int code1 = radar.nextInt(); 
		int code2 = radar.nextInt(); 
		int code3 = radar.nextInt();  
		ComboLock lock = new ComboLock(code1, code2, code3);  
		
		while (!lock.open()){
			System.out.println("Ready to be opened");
			System.out.println("Turn right: ");
			clicks = radar.nextInt();
			lock.turnRight(clicks); 
			System.out.println("Turn left: ");
			clicks = radar.nextInt(); 
			lock.turnLeft(clicks);
			System.out.println("Turn right: ");
			clicks = radar.nextInt(); 
			lock.turnRight(clicks);
			if (lock.open()){
				System.out.println("OPEN");
			}
			else{
				System.out.println("RESET");
				lock.reset();
			}
		}	
	}
}

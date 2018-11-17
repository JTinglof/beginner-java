
/**
 *  This program displays how voters ranked the importance of five issues
 *  on a scale of 1 to 10. It also displays the averages of the answers. 
 *  9-13-16
 *  @author  Joseph Tinglof
 */

public class Prog1c {

	public static void main(String[] args) {
		String[] topics = new String[5]; 
		int[][] responses = new int[5][10]; 
		double[] average = new double[5];
		int i = 0;
		int j = 0;
		
		topics[0] = "Global warming"; topics[1] = "Minimun wage"; //Initializes the 5 voter topics
		topics[2] = "Goverment spending"; topics[3] = "Social Security reform";
		topics[4] = "Immigration reform";
		
		responses[0][0] = 0; responses[0][1] = 200; responses[0][2] = 700; //Initializes the sum of the 
		responses[0][3] = 300; responses[0][4] = 100; responses[0][5] = 0; //voter's answers
		responses[0][6] = 800; responses[0][7] = 1400; responses[0][8] = 300;
		responses[0][9] = 200; 
		
		responses[1][0] = 600; responses[1][1] = 700; responses[1][2] = 2300;
		responses[1][3] = 0; responses[1][4] = 0; responses[1][5] = 0;
		responses[1][6] = 100; responses[1][7] = 300; responses[1][8] = 0;
		responses[1][9] = 0;
		
		responses[2][0] = 100; responses[2][1] = 300; responses[2][2] = 900;
		responses[2][3] = 100; responses[2][4] = 1600; responses[2][5] = 500;
		responses[2][6] = 400; responses[2][7] = 0; responses[2][8] = 100;
		responses[2][9] = 0;
		
		responses[3][0] = 2200; responses[3][1] = 0; responses[3][2] = 0;
		responses[3][3] = 0; responses[3][4] = 0; responses[3][5] = 0;
		responses[3][6] = 0; responses[3][7] = 0; responses[3][8] = 0;
		responses[3][9] = 1800;
		
		responses[4][0] = 400; responses[4][1] = 400; responses[4][2] = 400;
		responses[4][3] = 400; responses[4][4] = 400; responses[4][5] = 400;
		responses[4][6] = 400; responses[4][7] = 400; responses[4][8] = 400;
		responses[4][9] = 400;
		
		average[0] = 6.425; average[1] = 3.0; average[2] = 4.625; //Initializes the averages of the 
		average[3] = 5.05; average[4] = 5.5;                      // voter ranking
		
		
		System.out.println("Program 1, Joseph Tinglof, masc0752");
		
		System.out.print("                       ");
		for(i = 1; i < 11; i++){
			System.out.printf(" %4d", i);
		}
		System.out.printf("\n\n");
		
		for(i = 0; i < 5; i++){                     //Prints a chart displaying how many voters 
			System.out.printf("%23s", topics[i]);   //ranked each issue at each level as well as the
			for(j = 0; j < 10; j++){                //average of the answer.
				System.out.printf("%5d", responses[i][j]);
			}
			System.out.printf("   %f", average[i]);
			System.out.printf("\n\n");
		}
		
		
	}

}

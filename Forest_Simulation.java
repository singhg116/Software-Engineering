import java.util.*;

/*
 		Guriqbal Singh | Singhg@duq.edu | Assignment 1:
		Lost In the Woods Simulation:
		- Forest_Simulation.java
		- This program was coded utilizing the eclipse IDE
		- Software Engineering COSC 445W-01 Spring 2021
		- Date Completed: February 8th, 2021 | Submitted February 14th, 2021

	*   This program runs a simulation of two individuals wandering in the forest. The purpose
	    of the program is to discover if and how long it will take for the two individuals to
	    find each other. The forest is represented by a rectangular grid that is (A) units wide
	    and (B) units Tall. (A) & (B) will be defined by the user running the program.
	    The program will call two people, (Pat) & (Chris). (Pat) will begin in the upper left corner
	    of the grid and (Chris) will begin in the lower right corner of the grid. (Pat) & (Chris) will
	    move from one cell to another cell in the grid simultaneously and the time units will
	    increment by 1 for each step taken. Both individuals will move randomly choosing a direction
	    and the program will continue the simulation until either (Pat) and (Chris) end up finding
	    each other or the individuals do not end up meeting after 1 million time units have occurred.

	*


*/
public class Forest_Simulation {			//start


	 public static class Coordinate {			//this will create and store x and y
		 										//coordinates and allow us to obtain chris and pats locations
	        public int x;
	        public int y;

	        public Coordinate(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }

	static Scanner sc = new Scanner(System.in);			//this will allow for user input in any method
	public static int A, B;								//static int x-y
    public static Coordinate chris ,pat;				//declare chris and pat statically


    public static void main(String[] args) {			//main method
		//   public int x;
	    //   public int y;	didnt work
		//public Coordinate pat;

		System.out.println("This program runs a simulation of two individuals wandering in the forest. The purpose \n"
				+ "	    of the program is to discover if and how long it will take for the two individuals to \n"
				+ "	    find each other. The forest is represented by a rectangular grid that is (A) units wide \n"
				+ "	    and (B) units Tall. (A) & (B) will be defined by the user running the program. \n"
				+ "	    The program will call two people, (Pat) & (Chris). (Pat) will begin in the upper left corner\n"
				+ "	    of the grid and (Chris) will begin in the lower right corner of the grid. (Pat) & (Chris) will\n"
				+ "	    move from one cell to another cell in the grid simultaneously and the time units will \n"
				+ "	    increment by 1 for each step taken. Both individuals will move randomly choosing a direction \n"
				+ "	    and the program will continue the simulation until either (Pat) and (Chris) end up finding \n"
				+ "	    each other or the individuals do not end up meeting after 1 million time units have occurred. ");
		UserInput();									//call for UserInput
	}
	/****************************************************************************************/
	public static void UserInput() {					/*this method will ask the user to enter
														the value for A and B */
											            //declaring variables A and B
		//int pat, chris;
		System.out.println("\nThe forest is represented by a rectangular "
				+ "grid that is (A) units wide and (B) units tall. ");


		System.out.print("\nEnter the integer value for (A) that is greater than 1 and less than 51: ");
		 A = sc.nextInt();
		 while(A<2 || A>50) {
			 System.out.print("Enter a value between 1 and 51: ");
			 A = sc.nextInt();
		 }

		System.out.print("\nEnter the integer value for (B) that is greater than 1 and less than 51: ");
		 B = sc.nextInt();
		 while(B<2 || B>50) {
			 System.out.print("Enter a value between 1 and 51: ");
			 B = sc.nextInt();
		 }
		System.out.println("\nThe values you entered for (A) and (B) are: " + A + " & " + B);
		System.out.println("----------------------------------------------------------------------");

		Player();			//call the player class to get start coordinates for chris and pat

		for (int i = 0; i < 1000000; i++) {		/* for loop runs through 1 million time units until chris and pat equal each other
		 									       and then prints the result. */
            System.out.println("---------");
            chris = points(chris);	//send chris and pat to the points method and obtain new coordinates
            pat = points(pat);
            printCoordinates();
            if(chris.x==pat.x && chris.y ==pat.y) {
            	System.out.println("The program lasted " + i + " time units");
            	break;		//break program once chris == pat;
            }

        }
	}
	/*********************************************************************************************/
	public static void Player() {		/* This method creates the starting coordinates for pat and chris */
		chris = new Coordinate(A - 1, B - 1);		//bottom right of the grid
		pat =  new Coordinate(0, 0);				//upperleft corner of the grid

        printCoordinates();			//call this method to print the starting coordinates
	}
	  /*****************************************************************************************/
	  public static Coordinate points(Coordinate player) {		//read in pat and chris as the (player)
		  	//method gets the random directions both chris and pat go towards until

		  // This will be a number from 0 (inclusive) to 8 (exclusive).
	        int randomDirection = (int) (Math.random() * 8);

	        Integer[] coordinates = Direction[randomDirection];

	      // obtain new x and y coordinates when chris and pat are pushed through this method
	       int newX = Math.min(Math.max(player.x + coordinates[0], 0), A - 1);
	       int newY = Math.min(Math.max(player.y + coordinates[1], 0), B - 1);
	       System.out.println(newX + newY);
	       return new Coordinate(newX, newY);			//return x,y -- x and y coordinates update accordingly to pat and chris

	    }
	  /**************************************************************************/
	  public static Integer[][] Direction ={

			   // N(1)	//W(2)	//S(3) //E(4) //NE(5) //NW(6)  //SE(7)  //SW(8)
		        {0, -1},{1, 0},{-1, 0},{0, 1},{1, -1},{-1, -1},{1, 1},{-1, 1}
	  };

	  /*************************************************************************/
	  public static void printCoordinates() {		/*method prints out the coordinates for chris and pat when called */
	        System.out.println("Chris is at (" + chris.x + ", " + chris.y + ") " +
	                           "and Pat is at (" + pat.x + ", " + pat.y + ")");
}

}

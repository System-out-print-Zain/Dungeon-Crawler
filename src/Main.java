/*      Zain Mustafa
 * Tuesday, November 9th, 2021
 *         ICS4C1
 *    Mr. Parchimowicz
 *      Assignment 2
 *       Main class
 *  This is the driver class
 *  Rooms are declared and 
 *  instantiated. This is 
 *  where user input is taken
 *  and passed into the 
 *  appropriate methods.
 */


import java.util.Scanner; // importing the scanner class

public class Main {
	public static Scanner uIn = new Scanner(System.in); // Scanner object is declared here

	public static void main(String[] args) {
		titleScreen(); // the title screen method is run here and the entire program is set into action
	}
	
	public static void titleScreen() {
		
		Title.printTitle(); // Run the static method in the title class
		System.out.println("Enter Y to start.");
		
		String gameS = uIn.nextLine();
		
		if(gameS.equals("Y") == false) { // If anything other than Y is entered, this method is run again
			titleScreen();
		}
		movement(); // Run the movement method when Y is clicked.
	}
		
	public static void movement() {
		
		//Set initially to 0.
		int nextRoom = 0;
		//Declaring an array
		Room room[] = new Room[28];
		
		// Room: IdNum, (float) northExit,(double) southExit, (long) eastExit, (int)westExit; possibly: weapon.
		// BossRoom: Same as room.
		// SpecialRoom: Same as room, with (short) topDownExit as the last parameter
		room[0] = new SpecialRoom(0, 1F, 17D, 14L, 22, (short)27);
		room[27] = new SpecialRoom(27, (short)0, true);
		room[1] = new Room(1, 2F, 0D);
		room[2] = new Room(2, 1D, 3L);
		room[3] = new Room(3, 4D, 2);
		room[4] = new Room(4, 3F, 5L);
		room[5] = new Room(5, 6L, 4);
		room[6] = new Room(6, 7D, 5);
		room[7] = new Room(7, 6F, 8D, 26L);
		room[8] = new Room(8, 7F, 9D);	
		room[9] = new Room(9, 8F, 10);
		room[10] = new Room(10, 11D, 9L, 12);
		room[11] = new BossRoom(11, 10F);
		room[12] = new Room(12, 13F, 15D, 10L);
		room[13] = new Room(13, 14F, 12D, 17);
		room[14] = new Room(14, 13D, 0);
		room[15] = new Room(15, 12F, 16D, 18);
		room[16] = new BossRoom(16, 15F);
		room[17] = new Room(17, 0F, 13L, 21);
		room[18] = new Room(18, 19F, 15L);
		room[19] = new Room(19, 18D, 20);
		room[20] = new Room(20, 21F, 19L);
		room[21] = new Room(21, 22F, 20D, 17L);
		room[22] = new Room(22, 21D, 0L, 23);
		room[23] = new Room(23, 24F, 22L, 25);
		room[24] = new BossRoom(24, 23D);
		room[25] = new BossRoom(25, 23L);
		room[26] = new Room(26, 7, true); // This room contains the sword
		
		String choice = "Begin game!";
		System.out.println(choice);
		
		while(choice.equals("Q") == false) { // Runs until the user quits(Q)
			room[nextRoom].drawRoom('X'); // Draws out the 0th room
		    choice = uIn.nextLine(); // Prompts user input and stores it.
			nextRoom = room[nextRoom].navigate(choice);// Sets nextRoom equal to the return value of navigate for choice so that 
			//when it loops back through, the proper room is drawn out
		}
		
		titleScreen(); // Run title screen again if the while loop ends.
	}
}










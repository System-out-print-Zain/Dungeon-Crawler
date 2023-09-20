/*      Zain Mustafa
 * Tuesday, November 9th, 2021
 *         ICS4C1
 *    Mr. Parchimowicz
 *      Assignment 2
 *       Room class
 * This is the master class
 * of the bossRoom and the
 * specialRoom. Contains the
 * drawRoom and navigate method
 * methods which are the essence of
 * the program.
 */

public class Room {
	
	// These are public and static because they are not subject to a specific object
	public static boolean sword; 
	public static boolean goldCoin;
    public static int gems;
	
    //boolean variable that dictates whether an object contains a sword
	private boolean swordInRoom;
	
	// Dictate whether or not an exit is open. They are protected because we wish for subclasses to be able to access them
	protected boolean north;
	protected boolean south;
	protected boolean east;
	protected boolean west;
	
	protected int idNum;
	//Specifies the idNums of the rooms above, below, east, and west of a particular room.
	protected int northExit;
	protected int southExit;
	protected int eastExit;
	protected int westExit; 
	
	// We let northExit be specified by a float value; southExit by a double; eastExit by a long; westExit by an integer.
	Room(int idNum, float northExit, double southExit, long eastExit, int westExit, boolean weapon){ // We may enter "true" in the constructor when we wish for there to be a weapon inside
		this(idNum, northExit, southExit, eastExit, westExit);
		this.swordInRoom = weapon;
	}
	
	Room(int idNum, float northExit, double southExit, long eastExit, int westExit){ // Constructor: Takes the number values values
		this.idNum = idNum;
		this.northExit = (int)northExit;  // Changes the types of the inputs to int and assigns them to the objects variables
		this.southExit = (int)southExit;
		this.eastExit = (int)eastExit;
		this.westExit = westExit;
		
		// Sets the boolean variables values accordingly.
		if(idNum != this.northExit) {
			this.north = true;
		}else {
			this.north = false;
		}
		
		if(idNum != this.southExit) {
			this.south = true;
		}else {
			this.south = false;
		}
		
		if(idNum != this.eastExit) {
			this.east = true;
		}else {
			this.east = false;
		}
		
		if(idNum != this.westExit) {
			this.west = true;
		}else {
			this.west = false;
		}
		
	}
	//Constructor overloading
	Room(int idNum, float northExit, double southExit, long eastExit){
		this(idNum, northExit, southExit, eastExit, idNum);
	}
	Room(int idNum, float northExit, double southExit, int westExit){
		this(idNum, northExit, southExit, idNum, westExit);
	}
	Room(int idNum, float northExit, long eastExit, int westExit){
		this(idNum, northExit, idNum, eastExit, westExit);
	}
	Room(int idNum, double southExit, long eastExit, int westExit){
		this(idNum, idNum, southExit, eastExit, westExit);
	}
	
	Room(int idNum, float northExit, double southExit){
		this(idNum, northExit, southExit, idNum, idNum);
	}
	Room(int idNum, long eastExit, int westExit){
		this(idNum, idNum, idNum, eastExit, westExit);
	}
	Room(int idNum, float northExit, int westExit){
		this(idNum, northExit, idNum, idNum, westExit);
	}
	Room(int idNum, float northExit, long eastExit){
		this(idNum, northExit, idNum, eastExit, idNum);
	}
	Room(int idNum, double southExit, long eastExit){
		this(idNum, idNum, southExit, eastExit, idNum);
	}
	Room(int idNum, double southExit, int westExit){
		this(idNum, idNum, southExit, idNum, westExit);
	}
	
	// one way rooms may contain a sword.
	Room(int idNum, float northExit, boolean weapon){
		this(idNum, northExit, idNum, idNum, idNum);
		this.swordInRoom = weapon; 
	}
	Room(int idNum, double southExit, boolean weapon){
		this(idNum, idNum, southExit, idNum, idNum);
		this.swordInRoom = weapon;
	}
	Room(int idNum, long eastExit, boolean weapon){
		this(idNum, idNum, idNum, eastExit, idNum);
		this.swordInRoom = weapon;
	}
	Room(int idNum, int westExit, boolean weapon){
		this(idNum, idNum, idNum, idNum, westExit);
		this.swordInRoom = weapon;
	}


	
	public void drawRoom(char x) {
		System.out.println("Choose a direction: N, S, E, or W. Press I to open inventory. Enter Q to quit"); // Prints this every time the player enters a room
		if(this.swordInRoom) { // If there is a sword in the room
			System.out.println("You have found a sword");
			sword = true; // The value of the public static variable is set to true
			this.swordInRoom = false; // the room no longer contains a sword
		}
		//The following if statements determine which room corresponds to the values of the room object
		if(this.north && this.south && this.east && this.west) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "        "+x+"          \r\n"
					+ "                 \r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.north == false && this.south && this.east && this.west) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "                 \r\n"
					+ "        "+x+"          \r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.south == false && this.north && this.east && this.west){
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "                 \r\n"
					+ "        "+x+"          \r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.east == false && this.north && this.south && this.west) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "        "+x+"  ||||||\r\n"      
					+ "           ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.west == false && this.north && this.south && this.east) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "|||||| "+x+"          \r\n"
					+ "||||||           \r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.north == false && this.south == false && this.east && this.west) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "        "+x+"          \r\n"
					+ "                 \r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.north == false && this.east == false && this.west && this.south) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "           ||||||\r\n"      
					+ "        "+x+"  ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.north == false && this.west == false && this.south && this.east) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "||||||           \r\n"
					+ "|||||| "+x+"          \r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.south == false && this.east == false && this.west && this.north) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "        "+x+"  ||||||\r\n"      
					+ "           ||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.south == false && this.west == false && this.east && this.north) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "|||||| "+x+"         \r\n"
					+ "||||||           \r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.east == false && this.west == false && this.south && this.north) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "|||||| "+x+"   ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.north == false && this.south == false && this.east == false && this.west) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "       "+x+"   ||||||\r\n"      
					+ "           ||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.south == false && this.east == false && this.west == false && this.north) {
			System.out.println(
					  "======     ======\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
		}
		if(this.north == false && this.east == false && this.west == false && this.south) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "||||||     ||||||\r\n"
					+ "======     ======");
		}
		if(this.east && this.north == false && this.south == false && this.west == false) {
			System.out.println(
					  "=================\r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "||||||           \r\n"
					+ "||||||           \r\n"
					+ "|||||||||||||||||\r\n"
					+ "|||||||||||||||||\r\n"
					+ "=================");
			
		}
		
	}
	
	//This function is the power house of the program.
	public int navigate(String l) { // the value that the user inputs will be passed as the String l parameter in the main class
		if(l.equals("N")) { // If the user enters N (north)
			
			return this.northExit; // the function returns the northExit value of the object
			//and this results in the room to the north of this one being printed in the next iteration of the while loop in the main class
			// The same principle holds for the other statements.		
		}else if(l.equals("S")) {
			
			return this.southExit;
			
		}else if(l.equals("E")) {
			
			return this.eastExit;
			
		}else if(l.equals("W")) {
			
			return this.westExit;
			
		}else if(l.equals("I")) {
			
			System.out.println("Sword: " + sword + ". Gems: " + gems +". Golden coin: " + goldCoin + ".");
			return this.idNum;
			
		}else {
			
			return this.idNum; // If the user inputs anything other than the options. the function returns the idNum of the room
			
		}
	}
	
}




















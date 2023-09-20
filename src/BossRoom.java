/*      Zain Mustafa
 * Tuesday, November 9th, 2021
 *         ICS4C1
 *    Mr. Parchimowicz
 *      Assignment 2
 *       BossRoom class
 * In an inheritance relationship
 * with the Room class. Polymorphism
 * is used in order to get the bossRooms
 * in the game to behave differently from
 * other rooms.
 */
public class BossRoom extends Room {
		
		private boolean monsterDefeated = false; // In every bossRoom, the monster is undefeated initially.
		
		//We want boss rooms to have only one opening, so this is all the constructors we need
		BossRoom(int idNum, float northExit){
			super(idNum, northExit, idNum, idNum, idNum);
		}
		BossRoom(int idNum, double southExit){
			super(idNum, idNum, southExit, idNum, idNum);
		}
		BossRoom(int idNum, long eastExit){
			super(idNum, idNum, idNum, eastExit, idNum);
		}
		BossRoom(int idNum, int westExit){
			super(idNum, idNum, idNum, idNum, westExit);
		}
		
		public void drawRoom(char x) { // this drawRoom method overrides the one in the Room class
			System.out.println("Boss Room!"
					+ " Press F to fight the monster. Press E to exit. Press I to open inventory");
			// Draw the appropriate room
			if(this.north == false && this.south == false && this.east == false && this.west) {
				System.out.println(
						  "=================\r\n"
						+ "<> <> <> <> <> <>\r\n"
						+ "            ***||\r\n"
						+ " "+x+"            *||\r\n"      
						+ "              *||\r\n"
						+ "            ***||\r\n"
						+ "<> <> <> <> <> <>\r\n"
						+ "=================");
			}
			if(this.south == false && this.east == false && this.west == false && this.north) {
				System.out.println(
						  "======     ======\r\n"
						+ "^^      "+x+"      ^^\r\n"
						+ "^^             ^^\r\n"
						+ "^^*           *^^\r\n"
						+ "^^**         **^^\r\n"
						+ "^^*************^^\r\n"
						+ "^^|||||||||||||^^\r\n"
						+ "=================");
			}
			if(this.north == false && this.east == false && this.west == false && this.south) {
				System.out.println(
						  "=================\r\n"
						+ "^^|||||||||||||^^\r\n"
						+ "^^*************^^\r\n"
						+ "^^**         **^^\r\n"
						+ "^^*           *^^\r\n"
						+ "^^             ^^\r\n"
						+ "^^**    "+x+"    **^^\r\n"
						+ "======     ======");
			}
			if(this.east && this.north == false && this.south == false && this.west == false) {
				System.out.println(
						  "=================\r\n"
						+ "<> <> <> <> <> <>\r\n"
						+ "||***            \r\n"
						+ "||*          "+x+"    \r\n"
						+ "||*              \r\n"
						+ "||***            \r\n"
						+ "<> <> <> <> <> <>\r\n"
						+ "=================");
				
			}
		}
		// A function that locates and returns the exit that is open for a particular bossRoom
		//This is used in the navigate method below.
		private int locateExit() {
			int exit = 0;
			int[] possExits = {this.northExit, this.southExit, this.eastExit, this.westExit};
			for(int i=0; i<4; i++) {
				if(this.idNum != possExits[i]) {
					exit = possExits[i];
				}
			}
			return exit; // Returns the Exit that is open	
		}
		
		public int navigate(String l) {// Overrides the navigate function in the Room class
			if(l.equals("E")) { // E to exit
				return locateExit(); // this causes the player to leave the room
			}else if(l.equals("F")) { // F to fight
				
				if(this.monsterDefeated == false) {
					
					if(sword) {
						
						System.out.println("You have defeated it. You have obtained one gem");
						this.monsterDefeated = true;
						gems++;
						if(gems == 4) {
							System.out.println("Upon obtaining the fourth gem, you hear a rumbling sound somewhere in the distance...");
							SpecialRoom.nextPhase = true; // The rooms declared as SpecialRoom take on their second form
						}
						
					}else {
						
						System.out.println("The monster is unphased when you hit it with your fists...");
					}
					
				}else {
					System.out.println("The monster is already defeated");
				}
				
				return this.idNum;
				
			}else if(l.equals("I")) {
				
				return super.navigate(l); // Runs the parent function in the super class
				
			}else {
				
				return idNum; // If anything else is entered, the player should stay in the same room
				
			}
		}
}


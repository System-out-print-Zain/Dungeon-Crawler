/*      Zain Mustafa
 * Tuesday, November 9th, 2021
 *         ICS4C1
 *    Mr. Parchimowicz
 *      Assignment 2
 *    SpecialRoom class
 *  Is a subclass of the room
 *  class. This class defines
 *  a specialRoom object that
 *  adds a third dimension to
 *  navigation (up/down). These
 *  rooms allow the player to search
 *  for treasure.  
 */
public class SpecialRoom extends Room {
	
	// We only want these rooms to take the form of a specialRoom when all 4 gems are collected.
	//Once the user reenters the room, it looks different and gives a message.
	//We therefore add the following variable, which must be public because the bossRoom must access it.
	public static boolean nextPhase = false;
	
	private boolean treasure;
	private int topDownExit;
	
	// We will use the type short to indicate a top down exit.
	SpecialRoom(int idNum, float northExit, double southExit, long eastExit, int westExit, short topDownExit) {
		super(idNum, northExit, southExit, eastExit, westExit);
		this.topDownExit = (int)topDownExit;
		
	}
	//A special room only having a top/down exit may contain treasure
	SpecialRoom(int idNum, short topDownExit, boolean treasure){
		this(idNum, idNum, idNum, idNum, idNum, topDownExit);
		this.treasure = treasure;
	}
	
	public void drawRoom(char x) {
		if(gems != 4) {
			super.drawRoom(x); // Runs the drawRoom method of the super class (Room).
		}else {
			if(nextPhase) {
				System.out.println("The room has changed. There is a ladder hanging out of a trapdoor on the ceiling.");
				nextPhase = false;
			}
			System.out.println("Press C to use the ladder. Press S to search for treasure. Press I to open inventory. Enter Q to quit");
			if(this.north && this.south && this.east && this.west && gems == 4) {
				System.out.println(
				  "======     ======\r\n"
				+ "%%%%%%     %%%%%%\r\n"
				+ "%%%           %%%\r\n"
				+ "        "+x+"          \r\n"
				+ "                 \r\n"
				+ "%%%           %%%\r\n"
				+ "%%%%%%     %%%%%%\r\n"
				+ "======     ======"
						);
		    }
			if(this.east == false && this.north == false && this.south == false && this.west == false) {
				System.out.println(
						  "=================\r\n"
						+ "%%%%%%%%%%%%%%%%%\r\n"
						+ "%%%  _        %%%\r\n"
						+ "%%  | | "+x+"      %%       \r\n"
						+ "%%  |_|        %%\r\n"
						+ "%%%           %%%\r\n"
						+ "%%%%%%%%%%%%%%%%%\r\n"
						+ "================="
					     );
			}
		}

	}
	public int navigate(String l) {
		if(gems != 4) { // behaves as a regular room
			return super.navigate(l);
		}else { // once the gems are all collected, there are extra actions that the user may perform
			if(l.equals("C")) {
				return this.topDownExit;
			}else if(l.equals("S")) {
				if(this.treasure && goldCoin == false) {
					System.out.println("You have found a golden coin!");
					goldCoin = true;
					return this.idNum;
				}else {
					System.out.println("There is nothing to be found in this room");
					return this.idNum;
				}
			}else {
				return super.navigate(l);
			}
		}
	}
		
}
	


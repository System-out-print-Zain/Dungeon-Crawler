/*      Zain Mustafa
 * Tuesday, November 9th, 2021
 *         ICS4C1
 *    Mr. Parchimowicz
 *      Assignment 2
 *       Title class
 * This is where the printTitle
 * method is located. A bufferedReader
 * object reads from the text file Title.txt
 * and prints it out.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Title {
	
	public static void printTitle() {
		String line;
		try { // try allows the code herein to be tested for errors while it is running
		    BufferedReader read = new BufferedReader(new FileReader("Title.txt"));
		    
		    while( (line = read.readLine()) != null) {
		    	System.out.println(line);
		    }
		    
		    read.close();
		} catch (IOException e) { // If an error occurs, this catch statement is run 
			e.printStackTrace(); 
		}

	}
	
}


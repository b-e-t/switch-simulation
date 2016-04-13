import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class: Assignment2
 * Purpose: Contains method main, opens and reads from a file, handles any errors
 * Author: Brian Thompson
 * Date: February 20, 2016
 * Data: fileIn: Scanner - load a file through Scanner
 * Methods: main
 */
public class Assignment2 {
	public static void main(String[] args){
		Switch switchModel = new Switch();
		String file;
		Scanner input = new Scanner(System.in);
		boolean badFrame = false;
		
		System.out.print("Enter a file name to read: ");
		file = input.nextLine();
				
		try(Scanner inFile = new Scanner(new File(file))){
			
			while(inFile.hasNextLine()){
				Frame f = new Frame();
				if(f.readFrame(inFile)){
					switchModel.processFrame(f);
				}//end if frame OK
			}//end while
		}catch(FileNotFoundException e){
			System.out.println("The file was not found.");
			badFrame = true;
		}//end try/catch to open file
		catch(NoSuchElementException e){
			System.out.println("Unable to process frame. Exiting.");
			badFrame = true;
		}
		finally{
			input.close();
		}//end finally - close scanner
		if(!badFrame){
			switchModel.displayTable();
		}
	}//end main
}// end class Assignment1

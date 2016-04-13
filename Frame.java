import java.util.Scanner;

/**
 * Class:	Frame
 * Purpose:	this class will model a frame
 * Author:	Brian Thompson
 * Date:	February 20, 2016
 * Data:	portCode - String object to hold port code
 * 			destination - MACAddress object to hold destination
 * 			source - MACAddress object to hold source
 * 			frameData - String object to hold frame data
 * Methods:	defaultConstructor() - Initialize portCode, destination, source, frameData to null
 * 			readFrame(Scanner) - Read a frame from Scanner and return boolean on if data was good or not
 * 			getPortCode():String - Return portCode
 * 			getDestination():MACAddress - Return destination
 * 			getSource():MACAddress - Return source
 * 			getFrameData():String - Return frameData
 * 			toString():String - Return all frame information
 */


public class Frame {
	
	/*FIELDS*/
	private String portCode;
	private MACAddress destination;
	private MACAddress source;
	private String frameData;
	

	/*DEFAULT CONSRUCTOR*/
	public Frame(){
		portCode = new String();
		destination = new MACAddress();
		source = new MACAddress();
		frameData = new String();
	}//end default constructor
	
	/*METHOD TO READ A FRAME FROM THE SCANNER*/
	public boolean readFrame(Scanner in){
		portCode = in.next();
		if(destination.readAddress(in)==false){
			return false;
		}
		if(source.readAddress(in)==false){
			return false;
		}
		frameData = in.next();
		return true;
	}//end readFrame
	
	/*METHOD TO GET A PORT CODE AND RETURN A STRING*/
	public String getPortCode(){
		return portCode;
	}//end getPortCode
	
	/*METHOD TO GET A DESTINATION AND RETURN A MACAddress*/
	public MACAddress getDestination(){
		return destination;
	}//end getDestination
	
	/*METHOD TO GET A SOURCE AND RETURN A MACAddress*/
	public MACAddress getSource(){
		return source;
	}//end getSource
	
	/*METHOD TO GET FRAME DATA AND RETURN A STRING*/
	public String getFrameData(){
		return frameData;
	}//end getFrameData
	
	/*METHOD TO RETURN ALL FRAME INFORMATION AS A STRING*/
	public String toString(){
		String s = new String(portCode +" " +destination.toString()
			+" " +source.toString() +" " +frameData);
		return s;
	}//end toString

}//end class Frame

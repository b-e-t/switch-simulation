/**
 * Class:	SwitchEntry
 * Purpose:	this class models a single entry in the Cam Table
 * Author:	Brian Thompson
 * Date:	February 20, 2016
 * Data:	address: MACAddress object to hold source address
 * 			portCode: String object to hold the port code
 * Methods:	defaultConstructor() - Initialize address, portCode to null
 * 			initialConstructor(MACAddress, String) - Initialize address, portCode using passed parameters
 * 			addEntry() - Pass info to update current object
 * 			toString() - Display this entry to a String
 * 			isEqual(MACAddress): boolean - Compare parameter MACAddress to current entry and return true/false
 * 			compare(String): int - Compare Strings to find if they are high, low, or equal
 * 			getAddress(): MACAddress - Return MACAddress
 * 			getPortCode(): String - Return portCode
 */

public class SwitchEntry {

	/*FIELDS*/
	private MACAddress address;
	private String portCode;
	
	/**DEFAULT CONSTRUCTOR*/
	public SwitchEntry(){
		address = new MACAddress();
		portCode = new String();
	}//end default constructor
	
	/**TWO PARAMETER CONSTRUCTOR*/
	public SwitchEntry(MACAddress address, String portCode){
		this.address = address;
		this.portCode = portCode;
	}//end two parameter constructor
	
	/**METHOD TO ADD A SWITCH ENTRY*/
	public void addEntry(MACAddress address, String portCode){
		this.address = address;
		this.portCode = portCode;
	}//end addEntry
	
	/**METHOD TO COMPARE MACADDRESSES*/
	public boolean isEqual(MACAddress address){
		return this.address.isEqual(address);
	}//end isEqual
	
	/**METHOD TO COMPARE IF A MACADDRESS(STRING) HAS A HIGHER OR LOWER VALUE*/
	public int compare(String address){
		return address.compareToIgnoreCase(this.address.toString());
	}//end compare
	
	/**METHOD TO GET MACADDRESS*/
	public MACAddress getMACAddress(){
		return address;
	}//end getMACAddress
	
	/**METHOD TO GET PORT CODE*/
	public String getPortCode(){
		return portCode;
	}//end getPortCode
	
	/**METHOD TO PRINT ENTRY TO A STRING*/
	public String toString(){
		String toS = new String("Address: " +address.toString() +" port " +portCode);
		return toS;
	}//end toString
	
	
}//end class SwitchEntry

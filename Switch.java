import java.util.ArrayList;

/**
 * Class:	Switch
 * Purpose:	this class models an array of SwitchEntry to make up the Cam Table
 * Author:	Brian Thompson
 * Date:	February 20, 2016
 * Data:	camTable: ArrayList of SwitchEntry
 * Methods:	defaultConstructor() - Initialize camTable
 * 			displayTable() - Display all entries in camTable
 * 			processFrame(Frame) - Look for source (no? add, display message) (yes? move on)
 * 								- Look for destination (no? flood all ports) (yes? display message)
 * 			binarySearch(MACAddress): int - search for an address in camTable return -1 if found, or index to insert at if not found
 * 			binaryIndex(MACAddress): int - search for MACAddress, if found return index, if not found return -1
 */

public class Switch {

	/*FIELDS*/
	private ArrayList<SwitchEntry> camTable;
	
	/**DEFAULT CONSTRUCTOR*/
	public Switch(){
		camTable = new ArrayList<SwitchEntry>();
	}//end default constructor
	
	/**METHOD TO DISPLAY CURRENT CAM TABLE*/
	public void displayTable(){
		System.out.println("\nCam Table is :");
		for(int i=0; i<camTable.size(); i++){
			System.out.println("[" +i +"]" +camTable.get(i));
		}//end loop through array and print entries
	}//end displayTable
	
	/**METHOD TO PROCESS FRAME TO CAM TABLE*/
	public void processFrame(Frame f){
		
			if(camTable.size()==0){
				System.out.println("Adding "+f.getSource()+" to camTable");
				camTable.add(new SwitchEntry(f.getSource(), f.getPortCode()));
			}//end if empty table
			
			else if(binarySearch(f.getSource())>-1){
				System.out.println("Adding "+f.getSource()+" to camTable");
				camTable.add(binarySearch(f.getSource()), new SwitchEntry(f.getSource(), f.getPortCode()));
			}//end if source not in camTable

			if(binarySearch(f.getDestination())==-1){
				System.out.println("Sending frame with data " +f.getFrameData()
					+" from \n" +f.getSource() +" to " +f.getDestination()
					+" \nout port " +camTable.get(binaryIndex(f.getDestination())).getPortCode() +"\n");
			}//end if destination in camTable
			else{
				System.out.println("Flooding frame with data "
						+f.getFrameData() +" from \n" +f.getSource()
						+" to " +f.getDestination() +" \nout all ports\n");
			}//end if destination not in camTable
	}//end processFrame
	
	/**METHOD TO SEARCH FOR AN ADDRESS IN CAM TABLE, RETURN -1 IF FOUND, OR INDEX TO INSERT AT IF NOT FOUND*/
	public int binarySearch(MACAddress address){
		int index = 0;
		int high = camTable.size()-1;
		int low = 0;
		int mid = (low+high+1)/2;
		
		do{
			if(camTable.get(mid).compare(address.toString())==0){
				index = -1;
			}//end if MACAddress in camTable
			
			else if(camTable.get(mid).compare(address.toString())<0){
				high = mid-1;
				index = high+1;
			}//end if MACAddress lower than mid
			
			else{
				low = mid+1;
				index = low;
			}//end if MACAddress higher than mid
			
			mid = (low+high+1)/2;
		}while(low<=high && index>-1);
		return index;
	}//end binarySearch
	
	/**METHOD TO RETURN INDEX IF MACADDRESS IS FOUND, ELSE RETURN -1*/
	public int binaryIndex(MACAddress address){
		int index = -1;
		int high = camTable.size()-1;
		int low = 0;
		int mid = (low+high+1)/2;
		
		do{
			if(camTable.get(mid).compare(address.toString())==0){
				return mid;
			}//end if MACAddress in camTable
			
			else if(camTable.get(mid).compare(address.toString())<0){
				high = mid-1;
			}//end if MACAddress lower than mid
			
			else{
				low = mid+1;
			}//end if MACAddress higher than mid
			
			mid = (low+high+1)/2;
		}while(low<=high);
		return index;
	}//end binaryIndex
}//end class Switch

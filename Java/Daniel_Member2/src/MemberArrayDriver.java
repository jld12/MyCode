/**Programmer: Jennifer Daniel
 * Class/Section: CIT260-01
 * 
 * This is a drive program to accept a file of member information and use it to create an
 * array of member objects. It also has the option of displaying all, active, or inactive members.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MemberArrayDriver {
public static void main(String[] args) throws IOException{
	

	Member member;
	File inputFile = new File("members.csv");
	Scanner getInputFile = new Scanner(inputFile);
	int memberCount = getInputFile.nextInt();
	getInputFile.nextLine();
	
	
	// These ArrayLists will contain our members.
	ArrayList<Member> memberArray = new ArrayList<Member>(memberCount);
	ArrayList<Member> inactiveMembers = new ArrayList<Member>(memberCount);
	ArrayList<Member> activeMembers = new ArrayList<Member>(memberCount);
	
	
	// This loop will read the data file and split the file into lines. Next, it will
	// split the lines based on the commas. Finally, it will use the remaining data to
	// create arrays filled with Member objects.
	for(int i = 0; i < memberCount; i++){
		String temp = new String(getInputFile.nextLine());
		String[] tempArray = temp.split(",");
		char gender = tempArray[3].charAt(0);
		
		if(tempArray[2].equals("1")){
			
			tempArray[2] = "Active";
			if(tempArray.length < 6){
				member = new Member(tempArray[0], tempArray[1], tempArray[2], tempArray[4], gender);
				memberArray.add(member);
				activeMembers.add(member); }
			else {
				member = new Member(tempArray[0], tempArray[1], tempArray[2], tempArray[4], gender, new ImageIcon(tempArray[5]));
				memberArray.add(member); 
				activeMembers.add(member); }
			
			 }
		else {
			tempArray[2] = "Inactive";
			if(tempArray.length < 6){
				member = new Member(tempArray[0], tempArray[1], tempArray[2], tempArray[4], gender);
				memberArray.add(member);
				inactiveMembers.add(member); }
			else {
				member = new Member(tempArray[0], tempArray[1], tempArray[2], tempArray[4], gender, new ImageIcon(tempArray[5]));
				memberArray.add(member); 
				inactiveMembers.add(member); }
			
			 }
			
		
			}
	
	// Will display all members.
	//showAllMembers(memberArray);
	
	// Will display inactive members.
	  showAllMembers(inactiveMembers);
	
	// Will display active members.
	//showAllMembers(activeMembers);
	
	
	getInputFile.close();


}




/**
 * This method will allow the user to display either all of the members, only the active, or only the
 * inactive, depending on the ArrayList provided.
 * 
 * @param a		ArrayList containing the desired members to be displayed.
 */
public static void showAllMembers(ArrayList<Member> a){
	for(int i = 0; i < a.size(); i++){
		JOptionPane.showMessageDialog(null, a.get(i).toString(), null, JOptionPane.PLAIN_MESSAGE, a.get(i).getPicture());
	}
}

}


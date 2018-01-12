/**Programmer: Jennifer Daniel
 * Class/Section: CIT260-01
 * 
 * This is a simple driver program to test the 'Member' class. It tests all four constructors.
 */


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MemberDriver {
	public static void main(String[] args){
		
		ImageIcon newMemberPic = new ImageIcon("Pic.jpg");
		Member newMember = new Member("Daniel", "Jennifer", "Active", "jld12@pct.edu", 'F', newMemberPic);
		
		Member newMember2 = new Member("Erikson", "Leif", "Inactive", "lerikson@pct.edu", 'M');
		
		ImageIcon newMemberPic3 = new ImageIcon("Pic2.jpg");
		Member newMember3 = new Member("McFurrypaws", "Kitteh", "Active", 'F', newMemberPic3);
		
		Member newMember4 = new Member("Poe", "Edgar Allen", "Inactive", 'M');
		
		
		
		
		JOptionPane.showMessageDialog(null, newMember.toString(), "Member Info: " + newMember.getFullName(), 
				JOptionPane.PLAIN_MESSAGE, newMember.getPicture());
		JOptionPane.showMessageDialog(null, newMember2.toString(), "Member Info: " + newMember2.getFullName(), 
				JOptionPane.PLAIN_MESSAGE, newMember2.getPicture());
		JOptionPane.showMessageDialog(null, newMember3.toString(), "Member Info: " + newMember3.getFullName(), 
				JOptionPane.PLAIN_MESSAGE, newMember3.getPicture());
		JOptionPane.showMessageDialog(null, newMember4.toString(), "Member Info: " + newMember4.getFullName(), 
				JOptionPane.PLAIN_MESSAGE, newMember4.getPicture());
		
		
		
	}
}

/**Programmer: Jennifer Daniel
 * Class/Section: CIT260-01
 * 
 * This is a program that creates a 'Member' class. It has various constructors, and
 * methods to either change or retrieve the values for the Member's information. It contains
 * an overwrite for the toString method, which will print out the Member's info and picture.
 */


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Member {

	// Data members.
	private String lastName, firstName, type, email;
	private char gender;
	private ImageIcon picture;
	
	
	
	// Method Members.
	
	// Constructors.
	
	/**
	 * This is the full constructor. It accepts the maximum number of parameters and
	 * instantiates a Member object.
	 * 
	 * @param last		The member's last name.
	 * @param first		The member's first name.
	 * @param ty		The member's type ("inactive" or "active").
	 * @param em		The member's email.
	 * @param gen		The member's gender ('F' or 'M').
	 * @param pic		The member's picture.
	 */
	public Member(String first, String last, String ty, String em, char gen, ImageIcon pic){
		lastName = last; firstName = first; type = ty; email = em; gender = gen; picture = pic;
	}
	
	
	/**
	 * This constructor accepts all the parameters except the picture, then instantiates
	 * a Member object.
	 * 
	 * @param last		The member's last name.
	 * @param first		The mamber's first name.
	 * @param ty		The member's type ("inactive" or "active").
	 * @param em		The member's email.
	 * @param gen		The member's gender ('F' or 'M').
	 */
	public Member(String first, String last, String ty, String em, char gen){
		lastName = last; firstName = first; type = ty; email = em; gender = gen;
	}
	
	
	/**
	 * This constructor accepts all the parameters except the email, then instantiates
	 * a Member object.
	 * 
	 * @param last		The member's last name.
	 * @param first		The member's first name.
	 * @param ty		The member's type ("inactive" or "active").
	 * @param gen		The member's gender ('F' or 'M').
	 * @param pic		The member's picture.
	 */
	public Member(String first, String last, String ty, char gen, ImageIcon pic){
		lastName = last; firstName = first; type = ty; gender = gen; picture = pic; email = "No email registered";
	}
	
	
	/**
	 * This constructor accepts all the parameters except the picture and email, then instantiates
	 * a Member object.
	 * 
	 * @param last		The member's last name.
	 * @param first		The member's first name.
	 * @param ty		The member's type ("inactive" or "active").
	 * @param gen		The member's gender ('F' or 'M').
	 */
	public Member(String first, String last, String ty, char gen){
		lastName = last; firstName = first; type = ty; gender = gen; email = "No email registered";
	}
	
	
	
	// Mutators.
	
	/**
	 * This method resets the Member's last name.
	 * 
	 * @param last		The Member's new last name.
	 */
	public void setLastName(String last){
		lastName = last;		
	}
	
	
	/**
	 * This method resets the Member's first name.
	 * 
	 * @param first		The Member's new first name.
	 */
	public void setFirstName(String first){
		firstName = first;
	}
	
	
	/**
	 * This method resets the Member's type- "Inactive" or "Active".
	 * 
	 * @param ty	The Member's new type.
	 */
	public void setType(String ty){
		type = ty;
	}
	
	
	/**
	 * This method resets the Member's email.
	 * 
	 * @param em	The Member's new email.
	 */
	public void setEmail(String em){
		email = em;
	}
	
	
	// Note: I know this method probably won't get used much, but
	// some people do change their gender.
	/**
	 * This method resets the MEmber's gender- 'F' or 'M'.
	 * 
	 * @param gen	The Member's new gender.
	 */
	public void setGender(char gen){
		gender = gen;
	}
	
	
	/**
	 * This method accepts an ImageIcon object and resets
	 * the Member's picture.
	 * 
	 * @param pic		The Member's new picture.
	 */
	public void setPicture(ImageIcon pic){
		picture = pic;
	}
	
	
	// Getter(s).
	
	/**
	 * This method returns only the Member's last name.
	 * 
	 * @return lastName		The Member's last name.
	 */
	public String getLastName(){
		return lastName;
	}
	
	
	/**
	 * This method returns only the Member's first name.
	 * 
	 * @return firstName		The Member's first name.
	 */
	public String getFirstName(){
		return firstName;
	}
	
	
	/**
	 * This method returns both the first and last name of the Member.
	 * 
	 * @return fullName		The full name of the Member.
	 */
	public String getFullName(){
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	
	/**
	 * This method returns the Member's type.
	 * 
	 * @return type		The Member's type.
	 */
	public String getType(){
		return type;
	}
	
	
	/**
	 * This method returns the Member's email.
	 * 
	 * @return email		The Member's email.
	 */
	public String getEmail(){
		return email;
	}
	
	
	/**
	 * This method returns the Member's gender.
	 * 
	 * @return gender		The Member's gender.
	 */
	public char getGender(){
		return gender;
	}
	
	
	/**
	 * This method returns the Member's picture.
	 * 
	 * @return picture		The Member's picture.
	 */
	public ImageIcon getPicture(){
		return picture;
	}

	
	
	
	
	// toString method.
	
	/**
	 * This is the overwrite of the toString method. It prints out a member's information
	 * and, if applicable, picture.
	 * 
	 * @return
	 */
	public String toString(){
		String message = "";
		message += "Name: " + this.getFullName();
		message += "\nGender: " + this.getGender();
		message += "\nEmail: " + this.getEmail();
		message += "\nMember Type: " + this.getType();
	
		return message;
	}
	
}

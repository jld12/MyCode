// Note to professor: I went off of the book's description of Pig Latin,
// which is that any word, regardless of what letter it starts with, is
// appended with "ay". I have provided a version of the Pig
// Latin translation in case you wanted the version that takes into consideration
// whether or not the word begins with a vowel. The alternate version is
// called 'messageToPigLatinAlt'.

/**
 * Program: Assignment 3 | Pig Latin Translator, Message Hider
 * Programmer: Jennifer Daniel
 * Class: CIT260-25, B. Golshan
 * 
 * Problem Statement:
 * This program:
 * 		1. Creates and fills a 2D array with random characters, then prints the array.
 * 		2. Prepares a message, translates it to Pig Latin, and prints it.
 * 		3. Embeds the message in the 2D array and prints the array.
 * 		4. Extracts the message and prints out the original message.
 */

import java.util.Random;
import java.util.Scanner;



public class DanielAssignment3Driver {
	public static void main(String[] args){
				
		final int ROWS = 8; final int COLS = 8;
		
		//1. Create and fill a 2D Array with random characters.
		char[][] random = new char[8][8];
		fillArrayRandom(random);
		
		//2. Print the 2D Array.
		System.out.print("The original array of random characters: \n");
		printArray(random);
		
		//3. Prepare a message.
		String message = "she sells seashells by the seashore";
		
		//4. Translate the message into Pig Latin and print it.
		System.out.print("\nThe message in Pig Latin: \n");
		System.out.println(messageToPigLatin(message));
		
		//5. Call the method built in step 2 to hide the message in the 2D Array.
		int startRow = 1; int startCol = 1;
		int deltaRow = 2; int deltaCol = 2;
		messageHider(random, message, startRow, startCol, deltaRow, deltaCol, ROWS, COLS);
		
		//6. Print the 2D Array.
		System.out.print("\nThe array with the message embedded: \n");
		printArray(random);
		
		//7. Use the method in step 3 to extract the message from the Array.
		message = extractMessage(random, message, startRow, startCol, deltaRow, deltaCol, ROWS, COLS);
		
		//8. Print out the extracted message.
		System.out.print("\nThe original message: \n");
		System.out.println(message);
	}
	
	
	
	/**
	 * This method will accept a String message and hide the message inside of an
	 * array filled with random characters.
	 * 
	 * @param A		The two dimensional array that the message will be hidden in.
	 * @param m		The message to be hidden inside the array.
	 * @param r		The starting row of the message.
	 * @param c		The starting column of the message.
	 * @param dr	Number of rows between consecutive characters.
	 * @param dc	Number of columns between consecutive characters.
	 * @param nr	The number of rows in the 2D array.
	 * @param nc	The number of columns in the 2D array.
	 * @return	array
	 */
	public static char[][] messageHider(char[][] A, String m, int r, int c, int dr, int dc, int nr, int nc){
		
		String message = m;
		char[][] array = A;
		int delRow = dr; int delCol = dc;
		int row = r; int col = c;
		
		
		for(int i = 0; i < message.length(); i++){
			
			char character = message.charAt(i);
			
			array[row][col] = character;
			
			row = (row + delRow); 
			if(row > nr) { row = (row - nr); }
			col = (col + delCol);
			if(col > nc) { col = (col - nc); }  
			
		}
		
		return array;
	}
	
	
	/**
	 * This method extracts an embedded message from a 2D Array.
	 * 
	 * @param A		The two dimensional array that the message will be hidden in.
	 * @param m		The message to be hidden inside the array.
	 * @param r		The starting row of the message.
	 * @param c		The starting column of the message.
	 * @param dr	Number of rows between consecutive characters.
	 * @param dc	Number of columns between consecutive characters.
	 * @param nr	The number of rows in the 2D array.
	 * @param nc	The number of columns in the 2D array.
	 * @return	message		The extracted message.
	 */
	public static String extractMessage(char[][] A, String m, int r, int c, int dr, int dc, int nr, int nc){
	
	int row = r; int col = c;
	int delRow = dr; int delCol = dc;
	String message = "";
	
	for(int i = 0; i < m.length(); i++){
		char character = m.charAt(i);
		
		
			message += character;
		row = (row + delRow);
		col = (col + delCol);
		
		if(row >= nr) row = (row - nr);
		if(col >= nc) col = (col - nc);
		
	}
	return message;
	
	
}
	
	
	
	/**
	 * This method fills an array with random chars.
	 * 
	 * @param A		The array to be filled.
	 */
	public static void fillArrayRandom(char[][] A){
		
		for(int r = 0; r < A.length; r++){	
			for(int c = 0; c < A[r].length; c++){
				A[r][c] = randomCharacter();
			}
		}
	}
	
	/**
	 * This method prints the contents of an array of chars.
	 * 
	 * @param A		The array to be printed.
	 */
	public static void printArray(char[][] A){
		
		for(int r = 0; r < A.length; r++){
			for(int c = 0; c < A[r].length; c++){
				System.out.print(A[r][c] + "\t");
			
			} 
				System.out.printf("\n");
		}
		
	}
	
	/**
	 * This method generates a random letter from the English alphabet.
	 * 
	 * @return character		A randomly generated letter.
	 */
	public static char randomCharacter(){
		
		char character = ' ';
		
		Random randomGen = new Random();
		character = (char)(randomGen.nextInt(26) + 'a');

		return character;
	}
	
	/**
	 * This method converts a String message to Pig Latin.
	 * 
	 * @param message	The message to be translated to Pig Latin.
	 * @return translation		The message translation.
	 */
	public static String messageToPigLatin(String message){
		
		message = message.toLowerCase();
		Scanner getMessage = new Scanner (message);
		
		String translation = "";
		
		while (getMessage.hasNext()){
			translation += wordPigLatin(getMessage.next());
			translation += " ";
		}
		
		getMessage.close();
		return translation;		
		
	}

	/**
	 * This method translates a single word to Pig Latin.
	 * 
	 * @param word		The single word to be translated.
	 * @return translation		The word's translation.
	 */
	public static String wordPigLatin(String word){
		
		String translation = "";
		
		translation = word.substring(1) + word.charAt(0) + "ay";
		
		return translation;
		
	}
	
	
	// Note: Methods below are for the alternate version of Pig Latin,
	// where whether or not words begin with a vowel is considered.
	
	/**
	 * This method translates a message to Pig Latin and takes into account
	 * whether or not the first letter starts with a vowel or not.
	 * 
	 * @param message	The message to be translated.
	 * @return translation		The message translation.
	 */
	public static String messageToPigLatinAlt(String message){
		
		message = message.toLowerCase();
		Scanner getMessage = new Scanner (message);
		
		String translation = "";
		
		while (getMessage.hasNext()){
			translation += wordPigLatinAlt(getMessage.next());
			translation += " ";
		}
		
		getMessage.close();
		return translation;		
		
	}
	
	/**
	 * This method translates a single word to Pig Latin and takes into
	 * account whether or not the first letter starts with a vowel or not.
	 * 
	 * @param word	The word to be translated.
	 * @return translation		The word's translation.
	 */
	public static String wordPigLatinAlt(String word){
		
		String translation = "";
		
		if(beginsWithVowel(word)){
			translation += word;
			translation += "yay";
		}
		else{
			translation = word.substring(1) + word.charAt(0) + "ay";
		}
		
		return translation;
		
	}
	
	/**
	 * This method determines whether or not a word begins with a vowel.
	 * 
	 * @param word	The word to be examined.
	 * @return
	 */
	public static boolean beginsWithVowel(String word){
		
		boolean begins = false;
		
		char firstLetter = word.charAt(0);
		
		if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i'
				|| firstLetter == 'o' || firstLetter == 'u'){
			begins = true;
		}
		
		return begins;
		
	}
	
	
	
	
	
}


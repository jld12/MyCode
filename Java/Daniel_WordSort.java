// Programmer	: Jennifer Daniel
// Program		: Input Sorter
// Purpose		: This program will sort input based on word length and output the sorted text.
// Date			: 25 October 2017

import java.util.Arrays;
import java.util.Scanner;

public class Daniel_WordSort {

	public static void main(String[] args) {
		
		// Create a scanner to accept input from the user.
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter text and store that text in a String.
		System.out.println("Please enter text that you would like to be sorted.");
		String inputString = input.nextLine();
		
		// If the user did not enter text, prompt them to do so, then save the new input.
		// Loops until the user enters something into the console.
		while (inputString.isEmpty()) {
			System.out.println("No text was entered. Please enter text to be sorted.");
			inputString = input.nextLine();
		}
		
		// Remove all special characters, including punctuation, from the String.
		inputString = inputString.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
		
		// If removing special characters resulted in an empty String, alert the user.
		if (inputString.isEmpty()) {
			System.out.println("Your input was all special characters. Please rerun the program and try again.");
		} else {
		
			// Split the words in the String and store in an array of Strings.
			String[] wordArray = inputString.split(" ");
			
			// Sort the contents of the array of words by the words' length.
			Arrays.sort(wordArray, (a, b)->Integer.compare(a.length(), b.length()));
			
			// Print out the contents of the array. This will display the sorted words in a horizontal line.
			System.out.print("Sorted input: ");
			for(int i = 0; i < wordArray.length; i++) {
				System.out.print(wordArray[i] + " ");
			}
		
		}
		
		// Close the scanner.
		input.close();
		
	}
	
}

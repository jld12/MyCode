/**
 * Programmer: 	Jennifer Daniel
 * Course:		Secure Software Development
 * Program:		Buffer Overflow Program 1
 */

import java.util.Scanner;

public class Daniel_Overflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		char[] charArray = new char[150];
		
		System.out.println("====================");
		System.out.println("Jennifer Daniel");
		System.out.println("====================");
		System.out.println();
		
		
		// Receiving input.
		
		System.out.println("Enter a series of characters 10 times.");
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		String input3 = scanner.nextLine();
		String input4 = scanner.nextLine();
		String input5 = scanner.nextLine();
		String input6 = scanner.nextLine();
		String input7 = scanner.nextLine();
		String input8 = scanner.nextLine();
		String input9 = scanner.nextLine();
		String input10 = scanner.nextLine();

		System.out.println();
		
		// Placing input in array.
		
		for (int i = 0;i < input1.length(); i++){
		    charArray[90+i] = input1.charAt(i);
		}
		charArray[90 + input1.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input2.length(); i++){
		    charArray[80+i] = input2.charAt(i);
		}
		charArray[80 + input2.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input3.length(); i++){
		    charArray[70+i] = input3.charAt(i);
		}
		charArray[70 + input3.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input4.length(); i++){
		    charArray[60+i] = input4.charAt(i);
		}
		charArray[60 + input4.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input5.length(); i++){
		    charArray[50+i] = input5.charAt(i);
		}
		charArray[50 + input5.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input6.length(); i++){
		    charArray[40+i] = input6.charAt(i);
		}
		charArray[40 + input6.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input7.length(); i++){
		    charArray[30+i] = input7.charAt(i);
		}
		charArray[30 + input7.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input8.length(); i++){
		    charArray[20+i] = input8.charAt(i);
		}
		charArray[20 + input8.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input9.length(); i++){
		    charArray[10+i] = input9.charAt(i);
		}
		charArray[10 + input9.length()] = ' ';
		
		////////////////////////////////////////////
		
		for (int i = 0;i < input10.length(); i++){
		    charArray[0+i] = input10.charAt(i);
		}
		charArray[0 + input10.length()] = ' ';
		
		////////////////////////////////////////////
		
		System.out.println("====================");
		
		// Printing input.
		
		System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[90+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[80+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[70+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[60+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[50+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[40+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[30+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[20+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[10+i] + " ");
		} System.out.println();
		
		for(int i = 0; i < 10; i++){
			System.out.print(charArray[0+i] + " ");
		} 
		
		System.out.println();
		System.out.println();
		
		System.out.println("====================");
		System.out.println();
		System.out.println("Program completed.");
	}

}

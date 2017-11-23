// Programmer: Jennifer Daniel
// Program: Sim (Assignment 3)
// Date: 29 October 2017
// Purpose: This file has the main class for the project. It creates the stock and investors, and starts the investors.
// It also declares important values for the project.

import java.io.IOException;

public class DanielSim {

	public static void main(String[] args) throws IOException {
	
	// Values for testing the project:
		// 3 investors running 10 transactions, starting with 10k each.
	final int NUMBEROFINVESTORS = 3;
	final int NUMBEROFTRANSACTIONS = 10;
	final int STARTINGFUNDS = 10000;
	final String SYMBOL = "DAN";
	
	// Create a DanielStock object.
	DanielStock stock = new DanielStock(SYMBOL);
	
	// Create as many threads as the investors variable, passing each the test values, then start each thread.
	for (int i = 1; i <= NUMBEROFINVESTORS; i++) {
		DanielInvestor investor = new DanielInvestor(i, STARTINGFUNDS, NUMBEROFTRANSACTIONS, stock);
		investor.start();  
	}
	
	}
	
}

// Programmer: Jennifer Daniel
// Program: Logger (Assignment 3)
// Date: 29 October 2017
// Purpose: This file serves to write to both the log file and the console. It creates entries based on
// data it is given.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class DanielLogger extends Thread {

	private int investorNumber;
	private Timestamp timestamp;
	private int numberShares;
	private double price;
	private String entry = "";
	private String typeTrans = "";
	
	public DanielLogger(int in, int ns, double p, String ty) throws IOException {
		
		investorNumber = in;
		timestamp = new Timestamp(System.currentTimeMillis());
		numberShares = ns;
		price = p;
		
		// Type of transaction changes log entry.
		if (ty == "buy") {
			typeTrans = "bought";
		} else if (ty == "sell") {
			typeTrans = "sold";
		}
		
		// Create the log entry with all necessary information.
		// Entry for purchase or sale of stocks.
		entry = timestamp + ": Investor " + investorNumber + " " + typeTrans + " " + numberShares + " shares at " + price + ".";
		
	} 
	
	public DanielLogger(double p) {
		
		// Entry for price update.
		timestamp = new Timestamp(System.currentTimeMillis());
		entry = timestamp + ": Price updated to " + p + ".";
		
	}
	
	public DanielLogger(int in, double net, double bal) {
		
		// Entry for final earnings/loss report.
		entry = "Investor " + in + " net: " + net + "; Final balance: " + bal;
		
	}
	
	public void run() {
		
		// Write entry to console.
		System.out.println(entry);
		
		// Write log entry to file. Will append file created by stock class.
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("DanielLog", true));
			writer.append('\n');
			writer.append(entry);
			writer.close();
			
		} catch (IOException e) {

			// Alert users if writing fails.
			System.out.println("Something went wrong when the logger tried to write to DanielLog."
					+ " Please make sure the log file exists.");
			
		}
	    
		
	}
	
}

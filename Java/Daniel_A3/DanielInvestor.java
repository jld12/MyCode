// Programmer: Jennifer Daniel
// Program: Investor (Assignment 3)
// Date: 29 October 2017
// Purpose: This file creates the thread type 'Investor'. These investors have money with with they decide to buy or sell
// stocks depending on random numbers. Checking is used to make sure the investors do not try to sell stocks they don't have,
// buy stocks with more money than they have, or have a transaction with no shares at all.

import java.io.IOException;
import java.util.Random;

public class DanielInvestor extends Thread {
	
	private double availableFunds;
	private double transactionTotal;
	private int numTransactions;
	private int investorNumber;
	private int numberOfSharesHeld;
	private int numStocksTransaction;
	private int randomNumber;
	private int transactionsToRun;
	private int maxShares;
	private DanielStock stock;
	private Random ran;
	private int startFunds;
	
	public DanielInvestor(int idNumber, int startingFunds, int trans, DanielStock s) throws IOException {
		
		// Give the investor an id number for logging.
		investorNumber = idNumber;
		
		// Save the amt started with and set available funds to the starting amount.
		startFunds = startingFunds; 
		availableFunds = startingFunds;
		
		// The stock class to be interacted with.
		stock = s;
		
		// Values for sentinel and investor behavior.
		numberOfSharesHeld = 0;
		numTransactions = 0;
		
		// Upper limit for randomly generated shares.
		// Saved to variable for easy changing.
		maxShares = 10;
		// How many transactions should be run by the thread.
		transactionsToRun = trans;
	}
	
	public void run() {
				
		// Run as many times as variable is set to.
		while (numTransactions < transactionsToRun) {
		
			try {
			
		// Generate a 'random' number to determine whether to buy or sell.
		// This will hopefully make things more interesting than a predetermined
		// order of behavior.
		ran = new Random();	
		randomNumber = ran.nextInt(100);
		
		// Generate a 'random' number of shares to sell or purchase.
		ran = new Random();
		numStocksTransaction = ran.nextInt(maxShares);
		
		// If investor wants to buy/sell 0 shares, change to 1.
		if (numStocksTransaction == 0) {
			numStocksTransaction = 1;
		}
		
		if (randomNumber % 2 == 0) {
			
			// Check to make sure that the investor can afford to buy as many shares as
			// they are requesting. If so, buy that many.
			if (availableFunds > (stock.getPrice() * numStocksTransaction))	{
				
				transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "buy");
				numberOfSharesHeld += numStocksTransaction;
				availableFunds -= transactionTotal;
				
			// If they cannot afford that many, try to sell.
				
			// If they have more shares than  they want to sell, sell as many as they request.
			} else if (numberOfSharesHeld > numStocksTransaction) {
				
				transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "sell");
				numberOfSharesHeld -= numStocksTransaction;
				availableFunds += transactionTotal;
				
			// If they do not have enough to sell but still have, then sell what they have.
			} else if (numberOfSharesHeld != 0) {
				
				numStocksTransaction = numberOfSharesHeld;
				transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "sell");
				numberOfSharesHeld -= numStocksTransaction;
				availableFunds += transactionTotal;
				
			} else {
				
				// In the rare event that the investor is broke and has no shares...
				System.out.println("Investor " + investorNumber + "wants to buy but lacks the funds,"
						+ " and does not have any shares to sell to generate funds.");
				
			}
			
			// Increment the number of transactions.
			numTransactions++;
			
		} else {
			
			// If investor holds more shares than they want to sell, sell them.
			if (numberOfSharesHeld > numStocksTransaction) {
		
				transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "sell");
				numberOfSharesHeld -= numStocksTransaction;
				availableFunds += transactionTotal;
				
			// If investor has no shares to sell, buy instead.
			} else if (numberOfSharesHeld == 0) {

				// If no shares are held and they have enough money, buy shares.
				if (availableFunds > (stock.getPrice() * numStocksTransaction))	{
					
					transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "buy");
					numberOfSharesHeld += numStocksTransaction;
					availableFunds -= transactionTotal;  
					
				} else {
					
					// In the rare event that the investor is broke and has no shares...
					System.out.println("Investor " + investorNumber + "wants to sell but has no shares,"
							+ " and has insufficient funds to buy the requested number of shares.");
					
				}
				
			// If investor wants to sell more than they have, sell as many as they have.
			} else {
				
				numStocksTransaction = numberOfSharesHeld;
				transactionTotal = stock.transaction(numStocksTransaction, investorNumber, "sell");
				numberOfSharesHeld -= numStocksTransaction;
				availableFunds += transactionTotal;
				
			}
			
			// Increment the number of transactions.
			numTransactions++;
			
		} 
		} catch (IOException | InterruptedException E) {
			System.out.println("The Investor thread was interrupted or was unable to update the log file.");
		}
			
		try {
			
			// Sleep between transactions.
			sleep(700);
			
		} catch (InterruptedException e) {

			// If the investor was interrupted while sleeping.
			System.out.println("Investor " + investorNumber + " was trying to sleep but was interrupted.");
			
		}
		
		}
		
		// Update the log using the log thread -- net funds and final funds.
		DanielLogger logger = new DanielLogger(investorNumber, (availableFunds - startFunds), availableFunds);
		logger.run();
		
	}
	
}


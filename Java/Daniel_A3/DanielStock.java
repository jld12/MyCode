// Programmer: Jennifer Daniel
// Program: Stock (Assignment 3)
// Date: 29 October 2017
// Purpose: This file maintains stock information and controls the price updating and most of the logging.
// Important values are also stored here, like the available shares. Investor threads interact with this class.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DanielStock {

	private int numTransactions;
	private int sharesAvailable;
	private String symbol = "";
	private DanielPriceUpdater updater;
	private DanielLogger logger;
	private Random r;
	private BufferedWriter writer;
	
	private final int SHARESAVAILABLE = 500;
	
	private double price;
	
       public DanielStock(String sym)
       {
    	   sharesAvailable = SHARESAVAILABLE;
    	   numTransactions = 0;
    	   symbol = sym;   
    	   price = getInitialPrice();   
    	   
    	   // Title for log.
    	   String str = "LOG FOR STOCK " + symbol;
    	   
    	   try {
    		   
    		   // Create new log file. Will overwrite if file exists.
    		   writer = new BufferedWriter(new FileWriter("DanielLog"));
    		   writer.write(str);
    		   writer.close();
    		   
		} catch (IOException e) { 
			
			// Alert user to where something went wrong.
			System.out.println("Something went wrong when Stock tried to create DanielLog.");
			
		}
    	   
       }
       
       public synchronized double transaction(int shares, int invNumber, String type) throws IOException, InterruptedException {

    	   // If 5 transactions since last update, update the price.
    	   if (numTransactions == 5) {
    		   updater = new DanielPriceUpdater();
    		   updater.run(price);
    		   price = updater.getUpdatedPrice(); 
    		   
    		   // Update the log with the price update.
    		   logger = new DanielLogger(price);
    		   logger.run();
    		   
    		   // Reset sentinel.
    		   numTransactions = 0;
    	   }
    	   
    	   if (type == "sell") {

    		   // Investor sells the shares. Returns amount received for shares.
    		   sharesAvailable = sharesAvailable + shares;
    		   logger = new DanielLogger(invNumber, shares, price, "sell");
    		   logger.run();
    		   numTransactions++;
    		   return shares * price;
    		   
    	   } else if (type == "buy") {
    		   
    		   if (shares > sharesAvailable) {
    			   
    			   // If asking for more shares than is available, buy what's left.
    			   shares = sharesAvailable;
    			   sharesAvailable = 0;
    			   logger = new DanielLogger(invNumber, shares, price, "buy");
    			   logger.run();
    			   numTransactions++;
    			   return shares * price;    			   
    			   
    		   } else if (sharesAvailable == 0) {
    			   
    			   // If none left, sell instead.
    			   sharesAvailable = sharesAvailable + shares;
        		   logger = new DanielLogger(invNumber, shares, price, "sell");
        		   logger.run();
        		   numTransactions++;
        		   return shares * price;
    			   
    			   
    		   } else if (shares < sharesAvailable) {
    			   
    			   // If asking for less than is left, buy as many as requested.
    			   sharesAvailable = sharesAvailable - shares;
    			   logger = new DanielLogger(invNumber, shares, price, "buy");
    			   logger.run();
    			   numTransactions++;
    			   return shares * price;  
    			   
    		   }
    		   
    	   }
    	   
    	   // If failed.
    	   return -1;
       }
       
       // Generate a random starting price.
       public synchronized double getInitialPrice(){
    	   r = new Random();
           price = r.nextInt(100);
           return price;
       }
       
       // Get the price of shares.
       public double getPrice() {
    	   return price;
       }

}




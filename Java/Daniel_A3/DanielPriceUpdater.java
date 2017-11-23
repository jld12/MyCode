// Programmer: Jennifer Daniel
// Program: Price Updater (Assignment 3)
// Date: 29 October 2017
// Purpose: This file serves to update the price of stock shares. It 'randomly' decides to increase or decrease,
// and will then update the price accordingly. It has a get method to send the updated price to the stock class.

import java.util.Random;

public class DanielPriceUpdater { 

	private double currPrice;
	private Random r;
	private int random;
	
	public synchronized void run(double cp) {

		// Set current price.
		currPrice = cp;
		
		// Generate random number to determine whether price decreases or increases.
		r = new Random();
		random = r.nextInt(10);
		
		// Update price. I changed to a random increase/decrease to add more variety.
		if(random % 2 == 0) {
			currPrice += random;
		} else {
			currPrice -= random;
		}
		
	}
	
	// To return the updated price.
	public double getUpdatedPrice() {
		return currPrice;
	}
	
}

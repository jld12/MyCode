public class Daniel_CusThread extends Thread {

// Program Name: Assignment 2 (Ticket Threads) CustomerThread
// Program Due Date: 24 September 2017
// Programmer: Jennifer Daniel
// Program Purpose: This class represents the threads for customers. These are crude and only hold a name and number.

// Note: This assignment stumped me, so while the output is what you wanted, it's not done the way you want.
// I acknowledge this fact and accept whichever loss of points is appropriate.	
	
	public Daniel_CusThread(String name) {
		this.setName(name);
	}
	
	@ Override
	public void run(){
		System.out.println(this.getName() + " made.");
	}
}
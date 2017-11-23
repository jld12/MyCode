import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;

// Program Name: Assignment 2 (Ticket Threads) Server
// Program Due Date: 24 September 2017
// Programmer: Jennifer Daniel
// Program Purpose: This class represents the server, providing tickets for the customers to purchase.

// Note: This assignment stumped me, so while the output is what you wanted, it's not done the way you want.
// I acknowledge this fact and accept whichever loss of points is appropriate.

public class Daniel_A2_Server {
	
	public static void main(String[] args) {
		
		// Create a queue to hold the tickets and customers.
		ConcurrentLinkedQueue<Daniel_TickThread> clqTicket = new ConcurrentLinkedQueue<Daniel_TickThread>();
		ConcurrentLinkedQueue<Daniel_CusThread> clqCus= new ConcurrentLinkedQueue<Daniel_CusThread>();
		
		try {
			// Create variables for program and for allowing client connections.
			ServerSocket sock = new ServerSocket(6013);
			InputStream in = null;
			BufferedReader bin = null;
			int numTicks = 0;

			while (true) {
				// Initialize items for client connections and communication.
				Socket client = sock.accept();
				in = client.getInputStream();
				bin = new BufferedReader(new InputStreamReader(in));
				
				try {
					PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
					
					// Get number of tickets from client.
					try {
						numTicks = Integer.parseInt(bin.readLine());
					} catch (Exception e) {
						// Catch bad input.
						System.out.println("Something went wrong with the input.");
					}
					
					// Fill conncurrentLinkedQueue with thread for each ticket.
					for(int i = 1; i <= numTicks; i++) {
						Daniel_TickThread tick = new Daniel_TickThread("Ticket " + i);
						clqTicket.add(tick);
					}
					
					// Get customers from client, and fill a concurrentLinkedQueue with customer threads.
					String line;
					while((line = bin.readLine()) != null)
	                {
						int lint = Integer.parseInt(line);
						Daniel_CusThread cust = new Daniel_CusThread("Customer " + lint);
						clqCus.add(cust);	
	                }
					
					// Run the ticketSim method--see below.
					ticketSim(clqTicket, clqCus);
				
				}
				
				// Check for empty message or no message sent.
				catch (NullPointerException npe) {
					PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
					pout.println("No numbers found.");
				}
				
				// Close connections.
				client.close();
				sock.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
	
	public static void ticketSim(ConcurrentLinkedQueue<Daniel_TickThread> clqt, ConcurrentLinkedQueue<Daniel_CusThread> clqc) {
		
		// Save conncurrentLinkedQueues.
		ConcurrentLinkedQueue<Daniel_TickThread> clqTi = clqt;
		ConcurrentLinkedQueue<Daniel_CusThread> clqCu= clqc;
		
		// Save sizes of queues in variables (I was getting weird program behavior if I didn't save them as variables).
		int numberOfTickets = clqt.size();
		int numberOfCustomers = clqc.size();
		
		// Crudely simulate customers purchasing tickets until none are left. Customers are alerted if none remain.
		for(int i = 1; i <= numberOfCustomers; i++) {
			
			if(i <= numberOfTickets) {
				System.out.println(clqCu.poll().getName() + " purchased " + clqTi.poll().getName());
			} else {
				System.out.println(clqCu.poll().getName() + ": unable to purchase--no tickets left.");
			}
			
		}
		
	}

	
	
}
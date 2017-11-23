import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// Program Name: Assignment 2 (Ticket Threads) Client
// Program Due Date: 24 September 2017
// Programmer: Jennifer Daniel
// Program Purpose: This class is both to simulate a client sending requests
// for tickets to the server, but also for testing. The user can input whatever number
// of tickets or customers they want.

// Note: This assignment stumped me, so while the output is what you wanted, it's not done the way you want.
// I acknowledge this fact and accept whichever loss of points is appropriate.

public class Daniel_A2_Client {
	
	public static void main(String[] args) throws IOException {
		
		// Create variables to be used i nthe program.
		InputStream in = null; OutputStream out = null;
		BufferedReader bin = null; PrintWriter pw = null;
		Socket sock = null;
		
		int num_tickets = 0;
		int num_cust = 0;
		
		try {
			// Creates socket with this IP and port.
			sock = new Socket("127.0.0.1",6013);
			// getInputStream reads from socket
			in = sock.getInputStream();
			// getOutputStream writes to socket.
			out = sock.getOutputStream();
			// Connect writer to outPutStream; True flushes the stream automatically
			pw = new PrintWriter(out, true);
			
			// Get a scanner to accept user input.
			Scanner scanner = new Scanner(System.in);
			
			// Get number of tickets from user.
			// Letting the user choose allows for more testing than setting with a default number.
			System.out.println("How many tickets for simulation?");
			try {
			num_tickets = scanner.nextInt();
			} catch (Exception e) {
				// Catch if user did not send a number.
				System.out.println("Something went wrong with the input.");
			}
			
			// Send the number of tickets to the server.
			pw.println(num_tickets);
			
			// Get a number of customers from user.
			System.out.println("How many customers for simulation?");
			try {
				num_cust = scanner.nextInt();
			} catch (Exception e) {
				// Catch if user did not send a number.
				System.out.println("Something went wrong with the input.");
			}
			
			// Send numbers for customers to server.
			for(int i = 1; i <= num_cust; i++) {
				pw.println(i);
			}
			
			scanner.close();
		}
		
		catch (IOException ioe) {
				System.err.println(ioe);
		}
		finally {
			sock.close();
			}
	}	
}
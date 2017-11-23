// Program Name : Shell Interface
// Date : 03 September 2017
// Programmer : Jennifer Daniel (Section 1)
// Program Purpose : This program works as an interface for specific commands.
// Available commands : exit pwd ls cat cd

/**
 * Note: I've tried on two machines to get the command 'cd' recognized, including
 * one where I installed every single Cygwin package. Trying to run cd earns a message
 * stating that the file or directory does not exist, even when not putting a directory
 * in the command with cd.
 * 
 *  Because of this, for cd, I put methods to directly change the directory of the process.
 */

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Daniel_A1 {
public static void main(String[] args) throws java.io.IOException, InterruptedException {
		
		// Create patterns for RegEx to recognize cat, cd, relative path.
			String catPattern = "^(cat .*)";
			String cdPattern = "^(cd .*)";
			String relPattern = "^(\\.\\\\.*)";
				
		String commandLine;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		// Alert user of available commands.
			System.out.println("Current available commands: exit pwd ls cat cd");
		
		// Create variable to hold user's home directory.
			File homeDir = new File(System.getProperty("user.home"));
		
		// Create and start process, then move process to home directory.
			ProcessBuilder builder = new ProcessBuilder();
			builder.directory(homeDir);
		
		while (true) {
			
			// Read what the user enters.
				System.out.print("dshell> ");
				commandLine = console.readLine();
						
			// If the user enters a return, enter the loop again.
			if (commandLine.equals(""))
				continue;
			
			// If user enters 'exit', break loop.
			else if (commandLine.equals("exit")){
				break;
			}
			
			// If user enters ls, list files in current directory.
			else if (commandLine.equals("ls")) {

				File currDir = builder.directory();
				// Create an array with file names.
				File[] ls = currDir.listFiles();
				
				// If current directory empty, alert user.
				if(ls.length == 0) {
					System.out.println("Current directory empty.");
				}
				else{
					
					// If directory is not empty, use ProcessBuilder to execute ls.
					ProcessBuilder lsP = new ProcessBuilder("ls");
					lsP.directory(currDir);
					Process p = lsP.start();
					p.waitFor();
					Scanner s = new Scanner(p.getInputStream());
					while(s.hasNext()) {
						System.out.println(s.next());
					}
					s.close();
				}	
				
				continue;
				
			}
			
			// If user enters pwd, list current directory.
			else if (commandLine.equals("pwd")) {
				
				// Use ProcessBuilder to execute pwd.
				File currDir = builder.directory();
				ProcessBuilder pwdP = new ProcessBuilder("pwd");
				pwdP.directory(currDir);
				Process p = pwdP.start();
				p.waitFor();
				Scanner s = new Scanner(p.getInputStream());
				while(s.hasNext()) {
					System.out.println(s.next());
				}
				s.close();
				continue;

			}
			
			// If user enters just 'cat' or 'cat ', prompt them to retry.
			else if (commandLine.equals("cat") || commandLine.equals("cat ")) {
				System.out.println("Please reenter cat command with at least one file.");
				continue;
			}
			
			// If user enters cat with file(s), show contents.
			else if (Pattern.matches(catPattern, commandLine)) {
				
				// Extract file for cat from input.
				String input[] = commandLine.split(" ");
				String meow = input[1];
				
				File catFile = new File(meow);
				
				// Create path for file.
				String currDirS = builder.directory().toString();
				String filePath = currDirS + '\\' + meow;
				File testFile = new File(filePath);
				
				// Alert user if file doesn't exist.
				if(!testFile.exists()) {
					System.out.println("File does not exist.");
				}
				
				// Alert user if file is a directory.
				else if(catFile.isDirectory()) {
					System.out.println("File is a directory.");
				}
				
				// If file real/not directory, continue with cat.
				else {
				
					// If file real/not directory, use ProcessBuilder to execute cat.
					File currDir = builder.directory();
					ProcessBuilder catP = new ProcessBuilder("cat", filePath);
					catP.directory(currDir);
					Process p = catP.start();
					p.waitFor();
					Scanner s = new Scanner(p.getInputStream());
					while(s.hasNext()) {
						System.out.println(s.next());
					}
					s.close();
					
				}
				
				continue;
			}
			
			// If user enters just 'cd', current directory is listed.
			else if (commandLine.equals("cd")) {
				
				// Get current directory. // Non-pb and pb methods.
				//File currDir = new File(System.getProperty("user.dir"));
				File currDir = builder.directory();
				
				// Print current directory.
				System.out.println(currDir);
				continue;
				
				// Note : I tried using PB and couldn't get the system to recognize cd.
				// Attempted on two separate machines.
				
				/**
				
				// Use ProcessBuilder to execute cd.
				File currDir = builder.directory();
				ProcessBuilder cdP1 = new ProcessBuilder("cd");
				cdP1.directory(currDir);
				Process p = cdP1.start();
				p.waitFor();
				Scanner s = new Scanner(p.getInputStream());
				while(s.hasNext()) {
					System.out.println(s.next());
				}
				s.close();
				
				**/
			}
			
			// If user enters cd with a directory name, change to that directory.
			else if (Pattern.matches(cdPattern, commandLine)) {

				// Extract the path from input.
				String input[] = commandLine.split(" ");
				String nd = input[1];
				
				// Deal with relative path.
				if(Pattern.matches(relPattern, nd)) {
					
					// Trim the .\ from the relative path.
					String ndTrimmed = removeRelative(nd);
					
					// Combine the current directory and the new one.
					String curPath = builder.directory().toString();
					String newPath = curPath + ndTrimmed;
					
					nd = newPath;
				}
				
				File newDir = new File(nd);
				
				// Make sure the directory exists.
				if(newDir.exists()) {
				
					// If directory found, move user.
					builder.directory(newDir);
					
					// Verify move.
					System.out.println(builder.directory());
					
					// Note : I tried using PB and couldn't get the system to recognize cd.
					// Attempted on two separate machines.
					
					/**
					
					// If directory exists, use ProcessBuilder to execute cd.
					File currDir = builder.directory();
					ProcessBuilder cdP2 = new ProcessBuilder("cd", nd);
					cdP2.directory(currDir);
					Process p = cdP2.start();
					p.waitFor();
					Scanner s = new Scanner(p.getInputStream());
					while(s.hasNext()) {
						System.out.println(s.next());
					}
					s.close();
					
					**/
					
				}
				else {
					// If directory not found, alert user.
					System.out.println("Directory not found.");
				}
				
				continue;
			}
			
			// Account for user entering anything not matching the supported commands.
			else {
				System.out.println("Command not found.");
				continue;
			}
						
		}
	}
	
	// Method to trim first character from the path.
	public static String removeRelative(String s) {
		
		// trimmed is the passed String minus the first character.
		String trimmed;
		trimmed = s.substring(1);
		return trimmed;
	}
}
/**
 * Programmer: 	Jennifer Daniel
 * Course:		Secure Software Development
 * Program:		Fuzzer
 * 
 * Note: This fuzzer successfully broke the linkedList. Mission accomplished.
 */

public class Daniel_Fuzzer {

	public static void main(String[] args) {
		
		/**
		 * You should print out information about the fuzz test to be 
		 * conducted, print out the list prior to running the test, then 
		 * run the programmatic test, and after each of the tests you should 
		 * print out the list to show the results of the test.
		 */
		
		linkedList emptyList1 = new linkedList();
		linkedList emptyList2 = new linkedList();
		linkedList duplicatesList = new linkedList();
		
		// Add to an empty list.
		System.out.println("Test 1: Add to an empty list.");
				
			// Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");			
			
			// Perform test.
			System.out.println("PERFORMING TEST...");
			emptyList1.insertAtStart("word");
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
		System.out.println("##################################################################");

		// Add to the head of the list.
		System.out.println("Test 2: Add to the head of the list.");
				
		// Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList1.insertAtStart("newHead");
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");
		
		// Add to the tail of the list.
		System.out.println("Test 3: Add to the tail of the list.");

			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList1.insertAtEnd("newTail");
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");

		// Add to the middle of the list.
		System.out.println("Test 4: Add to the middle of the list.");
			
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			int middlepos = (emptyList1.getSize()/2) + 1;
			emptyList1.insertAtPos("middleValue", middlepos);
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");

		// Add duplicates.
		System.out.println("Test 5: Add duplicates.");
			
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			for(int i = 0; i < 4; i++){
				emptyList1.insertAtEnd("dupValue");
			}
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");

		// Remove from the head of the list.
		System.out.println("Test 6: Remove from the head of the list.");

			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList1.deleteAtPos(1);
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");

		// Remove from the tail of the list.
		System.out.println("Test 7: Remove from the tail of the list.");
	
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList1.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList1.deleteAtPos(emptyList1.getSize());
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList1.display();
				
			System.out.println("##################################################################");
			
		// Remove from an empty list.
		System.out.println("Test 8: Remove from an empty list.");
	
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList2.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList2.deleteAtPos(1);
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList2.display();
				
			System.out.println("##################################################################");
			
		// Remove from a list of 1 element.
		System.out.println("Test 9: Remove from a list of 1 element.");
	
			emptyList2.insertAtStart("singleVal");
		
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			emptyList2.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			emptyList2.deleteAtPos(1);
			
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			emptyList2.display();
				
			System.out.println("##################################################################");

		// Remove a duplicated element from a list with duplicated elements.
		System.out.println("Test 10: Remove a duplicated element from a list"
				+ " with duplicated elements.");
	
			for(int i = 0; i < 5; i++){
				duplicatesList.insertAtEnd("duplicateValue");
			}
		
			//Print out list prior to test.
			System.out.println("---------------------");
			System.out.println("List before test: ");
			duplicatesList.display();
			System.out.println("---------------------");
						
			//Perform test.
			System.out.println("\nPERFORMING TEST...\n");
			duplicatesList.deleteAtPos(2);
						
			// Print out list after test.
			System.out.println("---------------------");	
			System.out.println("List after test: ");
			duplicatesList.display();
				
			System.out.println("##################################################################");
		
	}

}

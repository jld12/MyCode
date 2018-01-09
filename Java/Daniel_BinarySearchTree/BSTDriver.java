import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class BSTDriver {
	public static void main(String[] args) throws Exception{
			 
		/*
	        BST testTree = new BST();
	 
	        testTree.addNode(23, "Jane");
	        testTree.addNode(15, "Bob");
	        testTree.addNode(18, "Betty");
	        testTree.addNode(10, "John");
	        testTree.addNode(45, "Pat");
	        testTree.addNode(20, "Sam");
	        testTree.addNode(3, "Mimi");
	 		testTree.addNode(4, "Adam");
	 		testTree.addNode(10, "Pat");
	 		testTree.addNode(8, "");
	 		testTree.addNode(9, "");
	 
	        testTree.inOrderTraverseTree(testTree.root);
	        testTree.preOrderTraverseTree(testTree.root);
	        testTree.postOrderTraverseTree(testTree.root);
	 
	        System.out.println(testTree.findNode(75));
	    */
	        
	        File alice = new File("Alice's_Adventures_in_Wonderland.txt");
	        String input = null;
	        
	        try{
	        	Scanner scan = new Scanner(alice);
	        	
	        	BST aliceTree = new BST();
	        	
	        	Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
	   
	        	
	            while (scan.hasNext()) {
	                
	                input = scan.next().toLowerCase();
	                input = input.replaceAll("\\W", "");
	                
	                if (!wordCounts.containsKey(input)) {
	                    wordCounts.put(input, 1);
	                    
	                } else {
	                    wordCounts.put(input, wordCounts.get(input) + 1);
	                    
	                }
	                
	            }
	            
	            	for(Map.Entry<String, Integer> entry: wordCounts.entrySet()){
	                	String key = entry.getKey();
	                	Integer value = entry.getValue();
	                	
	                	//System.out.println(key + " => " + value);
	                	
	                	aliceTree.addNode((int)value, key);
	                }
	            
	            	scan.close();
	            	aliceTree.inOrderTraverseTree(aliceTree.root);
	        }
	        
	        catch (FileNotFoundException e){
	        	e.printStackTrace();
	        }
	        
	        
	 
	}	 
			
            
}

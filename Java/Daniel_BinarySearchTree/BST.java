import java.util.LinkedList;
import java.util.Queue;

public class BST {
	 
	    BSTNode root;
	 
	    public void addNode(int key, String name) {
	 
	        BSTNode newNode = new BSTNode(key, name);	 
	        if (root == null) {
	            root = newNode;
	        } else {
	            BSTNode focusNode = root;
	            BSTNode parent;
	            while (true) {
	                parent = focusNode;
	                if (key < focusNode.key) {
	                    focusNode = focusNode.leftChild;
	                    if (focusNode == null) {
	                        parent.leftChild = newNode;
	                        return;
	                    }
	                } else { 
	                    focusNode = focusNode.rightChild;
	                    if (focusNode == null) {
	                        parent.rightChild = newNode;
	                        return;
	                    }
	                }
	            }
	        }
	    }
	    
	 
	    public void inOrderTraverseTree(BSTNode focusNode) {
	 
	        if (focusNode != null) {
	 
	            inOrderTraverseTree(focusNode.leftChild);
	            System.out.println(focusNode);
	            inOrderTraverseTree(focusNode.rightChild);
	        }
	    }
	 
	    public void preOrderTraverseTree(BSTNode focusNode) {
	 
	        if (focusNode != null) {
	            System.out.println(focusNode);
	            preOrderTraverseTree(focusNode.leftChild);
	            preOrderTraverseTree(focusNode.rightChild);
	 
	        }
	 
	    }
	 
	    public void postOrderTraverseTree(BSTNode focusNode) {
	 
	        if (focusNode != null) {
	            postOrderTraverseTree(focusNode.leftChild);
	            postOrderTraverseTree(focusNode.rightChild);
	            System.out.println(focusNode);
        }
	 
	    }
	 
	    public BSTNode findNode(int key) {
	        BSTNode focusNode = root;
	        while (focusNode.key != key) {
	            if (key < focusNode.key) {
	                focusNode = focusNode.leftChild;
	            } else {
	                focusNode = focusNode.rightChild;
	            }
	            if (focusNode == null)
	                return null;
	        }
	        return focusNode;
	    }
	 
	    public static void levelOrderTraversal(BSTNode startNode) {  
	    	  Queue<BSTNode> queue=new LinkedList<BSTNode>();  
	    	  queue.add(startNode);  
	    	  while(!queue.isEmpty())  
	    	  {  
	    	   BSTNode tempNode=queue.poll();  
	    	   System.out.println(tempNode);
	    	   if(tempNode.leftChild!=null)  
	    	    queue.add(tempNode.leftChild);  
	    	   if(tempNode.rightChild!=null)  
	    	    queue.add(tempNode.rightChild);  
	    	  }  
	    	 }
	    
	    public void deleteByMerging(String el) {
	        BSTNode tmp, node, p = root, prev = null;
	        while (p != null && !p.element.equals(el)) {  
	             prev = p;                           
	             if (el.compareTo(p.element) < 0)
	                  p = p.rightChild;
	             else p = p.leftChild;
	        }
	        node = p;
	        if (p != null && p.element.equals(el)) {
	             if (node.rightChild == null) 
	                  node = node.leftChild; 
	             else if (node.leftChild == null) 
	                  node = node.rightChild; 
	             else {                  
	                  tmp = node.leftChild;  
	                  while (tmp.rightChild != null) 
	                      tmp = tmp.rightChild;      
	                  tmp.rightChild =        
	                      node.rightChild;    
	                                     
	                  node = node.leftChild;  
	             }
	             if (p == root)
	                  root = node;
	             else if (prev.leftChild == p)
	                  prev.leftChild = node;
	             else prev.rightChild = node; 
	        }
	        else if (root != null)
	             System.out.println("Element " + el + " is not in the tree");
	        else System.out.println("The tree is empty");
	    }
	    
	    public void deleteByCopying(String el) {
	        BSTNode node, p = root, prev = null;
	        while (p != null && !p.element.equals(el)) {  
	             prev = p;                         
	             if (el.compareTo(p.element) < 0)
	                  p = p.leftChild;
	             else p = p.rightChild;
	        }
	        node = p;
	        if (p != null && p.element.equals(el)) {
	             if (node.rightChild == null)             
	                  node = node.leftChild;
	             else if (node.leftChild == null)        
	                  node = node.rightChild;
	             else {
	                  BSTNode tmp = node.leftChild;  
	                  BSTNode previous = node;   
	                  while (tmp.rightChild != null) {   
	                      previous = tmp;            
	                      tmp = tmp.rightChild;       
	                  }
	                  node.element = tmp.element;          
	                                              
	                  if (previous == node)        
	                      previous.leftChild  = tmp.leftChild; 
	                 else previous.rightChild = tmp.leftChild; 
	             }
	             if (p == root)
	                  root = node;
	             else if (prev.leftChild == p)
	                  prev.leftChild = node;
	             else prev.rightChild = node;
	        }
	        else if (root != null)
	             System.out.println("el " + el + " is not in the tree");
	        else System.out.println("the tree is empty");
	    }
	    
	class BSTNode {
	    int key;
	    String element;
	    BSTNode leftChild;
	    BSTNode rightChild;
	    BSTNode(int key, String element) {
	        this.key = key;
	        this.element = element;
	    }
	 
	    public String toString() {
	        return element + " has the key " + key;
	    }
	    
	    public void setKey(int k){
	    	key = k;
	    }
	    
	    public int getKey(){
	    	return key;
	    }
	   
	    public void setElement(String e){
	    	element = e;
	    }
	    
	    public String getElement(){
	    	return element;
	    }
	    
	    public BSTNode getLeft() {
            return leftChild;
	    }
	   
	    public void setLeft(BSTNode p) {
	            leftChild = p;
	    }
	   
	    public BSTNode getRight() {
	            return rightChild;
	    }
	   
	    public void setRight(BSTNode p) {
	            rightChild = p;
	    }
	    
	    public boolean isInternal() {
            return (leftChild == null) || (rightChild == null);
	    }
	    
	    public boolean isLeaf() {
	    	return ((leftChild == null) && (rightChild == null));
	    }
	    
	    public boolean isEmpty() {
	    	return ((element == null) && (key == 0));
	    }
	    
	    public int count(BSTNode rt) {
            if (rt == null) return 0; // Nothing to count
            return 1 + count(rt.getLeft()) + count(rt.getRight());
	    }
	    
	    
	    
	}
	}
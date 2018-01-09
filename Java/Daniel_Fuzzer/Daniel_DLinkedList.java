import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Programmer: 	Jennifer Daniel
 * Course:		Secure Software Development
 * Program:		Double Linked List - Alphabetically Sorted
 */
 
class Node
{
    protected String word;
    protected Node next, prev;
 
    public Node()
    { next = null; prev = null; word = null; }

    public Node(String w, Node n, Node p)
    { word = w; next = n; prev = p; }

    public void setLinkNext(Node n)
    { next = n; }

    public void setLinkPrev(Node p)
    { prev = p; }    

    public Node getLinkNext()
    { return next; }

    public Node getLinkPrev()
    { return prev; }

    public void setWord(String w)
    { word = w; }

    public String getWord()
    { return word; }
}
 


class linkedList
{ 
	protected Node start;
    protected Node end ;
    public int size;

    public linkedList()
    { start = null; end = null; size = 0; }
 
    public boolean isEmpty()
    { return start == null; }

    public int getSize()
    { return size; }

    public void insertAtStart(String val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        { start = nptr; end = start; }
        else
        {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
        
        if(size > 1){
	        LinkedList<String> stringList = new LinkedList<String>();
	        for(int i = 1; i <= this.getSize(); i++){
	        	stringList.add(this.getValAtPos(i));
	        }
	        Collections.sort(stringList);
	        
	        for(int j = 1; j <= this.getSize(); j++){
	        	this.setValAtPos(j, stringList.get(j - 1));
	        } 
        }
        
    }

    public String getValAtPos(int pos)
    {
        Node current = start;
        int count = 1; 
        
        while (current != null)
        {
            if (count == pos)
                return current.getWord();
            count++;
            current = current.next;
        }
 
        return null;
    }
    
    public void setValAtPos(int pos, String w)
    {
        Node current = start;
        int count = 1; 
        
        while (current != null)
        {
            if (count == pos)
                current.word = w;
            count++;
            current = current.next;
        }
 
    }
    
    public void insertAtEnd(String val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        { start = nptr; end = start; }
        else
        {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
        
        if(size > 1){
	        LinkedList<String> stringList = new LinkedList<String>();
	        for(int i = 1; i <= this.getSize(); i++){
	        	stringList.add(this.getValAtPos(i));
	        }
	        Collections.sort(stringList);
	        
	        for(int j = 1; j <= this.getSize(); j++){
	        	this.setValAtPos(j, stringList.get(j - 1));
	        } 
        }    
    }

    public void insertAtPos(String val , int pos)
    {
        Node nptr = new Node(val, null, null);    
        if (pos == 1)
        {
            insertAtStart(val);
            return;
        }            
        
        Node ptr = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();            
        }
        size++ ;
        
        if(size > 1){
	        LinkedList<String> stringList = new LinkedList<String>();
	        for(int i = 1; i <= this.getSize(); i++){
	        	stringList.add(this.getValAtPos(i));
	        }
	        Collections.sort(stringList);
	        
	        for(int j = 1; j <= this.getSize(); j++){
	        	this.setValAtPos(j, stringList.get(j - 1));
	        } 
        }  
    }

    public void deleteAtPos(int pos)
    {    
    	if (size == 0){
    		System.out.println("ERROR: LIST IS EMPTY");
    	}
    	
    	else{
    		
	        if (pos == 1) 
	        {
	        	
		            if (size == 1)
		            {
		                start = null;
		                end = null;
		                size = 0;
		                return; 
		            }
		            start = start.getLinkNext();
		            start.setLinkPrev(null);
		            size--; 
		            return ;
	        	
	        }
	        
	        if (pos == size)
	        {
	            end = end.getLinkPrev();
	            end.setLinkNext(null);
	            size-- ;
	        }
	        
	        Node ptr = start.getLinkNext();
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == pos)
	            {
	                Node p = ptr.getLinkPrev();
	                Node n = ptr.getLinkNext();
	 
	                p.setLinkNext(n);
	                n.setLinkPrev(p);
	                size-- ;
	                return;
	            }
	            ptr = ptr.getLinkNext();
	        }
        }      
    	if(size > 1){
	        LinkedList<String> stringList = new LinkedList<String>();
	        for(int i = 1; i <= this.getSize(); i++){
	        	stringList.add(this.getValAtPos(i));
	        }
	        Collections.sort(stringList);
	        
	        for(int j = 1; j <= this.getSize(); j++){
	        	this.setValAtPos(j, stringList.get(j - 1));
	        } 
        } 
    }    

    public void display()
    {
        System.out.print("\nList: ");
        
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        
        if (start.getLinkNext() == null) 
        {
            System.out.println(start.getWord() );
            return;
        }
        
        Node ptr = start;
        System.out.print(start.getWord()+ " <-> ");
        ptr = start.getLinkNext();
        
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getWord()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        
        System.out.print(ptr.getWord()+ "\n");
    }
}
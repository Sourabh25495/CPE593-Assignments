/*
Author: Sourabh kulkarni
*/

import java.io.*;
import java.util.*;
class DLinkedList{
    
    public class Node{      
        int val;
        Node next;
        Node prev;
        public Node(int v,Node next,Node prev) {// Constructor for Node class
			val = v; this.next = next; this.prev = prev; 
		}

    }


private Node head;
private Node tail;

public DLinkedList(){       // Constructor for DLinkedList
    head = null;
    tail = null;

}
  // adds a node at the start
public void addStart(int v){
    Node temp = new Node(v, head, null);
    if(head != null){   // checks if head is present
        head.prev = temp;

    }
    head = temp;         // set head to the newly added node to avoid NullPtrException

    if(tail == null) 
    { 
    tail = temp;
    }
      

}

// adds node at the end
public void addEnd(int v){
   Node temp = new Node(v, null, tail);
   if(tail != null) 
       {
       tail.next = temp;
       
       }
        tail = temp;    // set tail to the newly added node to avoid NullPtrException

    if(head == null){
        head = temp;
         
    }
    
     

}
// removes specified number of nodes from the start
public void removeStart(int v){
       
    for(int i = v; i> 0 ; i--){   // 
        if(head == null){
            return;
        }else{

            head = head.next;       
            head.prev = null;      // point head to second node and null the first node
        }
    }

}

// removes specified number of nodes from the end
public void removeEnd(int v){
   
    for(int i = v; i>0 ; i--){
        if( tail == null){
            return;
        }else{
            tail = tail.prev;
            tail.next = null;       // point tail to seconLast node and null the last one
        }
    }

}



public int getPos(int pos){
    Node temp = head;
    for(int i=0; i< pos; i++){
        temp = temp.next;
    }
    return temp.val;
}

// gets the size of linked list
public int size(){
    int i = 0;
    Node p;
    for(p= head; p != null; p =p.next){
       i++;
    }
    return i;
}

// Main function reads the input file
// Converts all strings to respective data types
public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new FileReader("HW4b.txt"));
        
        DLinkedList a = new DLinkedList();

        while(sc.hasNext()) {
		switch(sc.next()) {
		case "ADD_FRONT" :
			String [] strs = sc.nextLine().trim().split(":");
			int start = Integer.valueOf(strs[0]);
			int step = Integer.valueOf(strs[1]);
			int end = Integer.valueOf(strs[2]);

            for(int i=start;i<end;i+=step){
                a.addStart(i);
            


            }
            continue;

        case "ADD_BACK" :

            String [] strs1 = sc.nextLine().trim().split(":");
			int start1 = Integer.valueOf(strs1[0]);
			int step1 = Integer.valueOf(strs1[1]);
			int end1 = Integer.valueOf(strs1[2]);

			for(int i = start1;i <=end1;i += step1)
				a.addEnd(i);

            continue;
                
        case "REMOVE_FRONT" :

            String [] strs2 = sc.nextLine().split(" ");
			int val = Integer.valueOf(strs2[1]);
				a.removeStart(val);

            continue;

        case "REMOVE_BACK" :

            String [] strs3 = sc.nextLine().split(" ");
			int val1 = Integer.valueOf(strs3[1]);
				a.removeEnd(val1);

            continue;

        case "OUTPUT" :
            //a.output();
            
            for(int i=0;i<a.size();i++){
                System.out.print(a.getPos(i)+ " ");
             }
             System.out.println(" ");
             
            continue;
            }
           

        }
    }


}
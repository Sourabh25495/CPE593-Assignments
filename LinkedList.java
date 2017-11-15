/*
 *	 Author: Aakanksha Gokhe
 */
import java.io.*;
import java.util.*;
public class LinkedList {
	public class Node { //  LinkedList.Node
		int val;
		Node next;
		Node prev;
		
		public Node(int v,Node next,Node prev) {
			val = v; this.next = next; this.prev = prev; 
		}
	}
	private Node head;
	private Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}
	public void addStart(int v) {
		Node p = new Node(v, head, null);
		if(head != null ) {head.prev = p;}
        head = p;
        if(tail == null) { tail = p;}
	}

	public void addEnd(int v) {
		Node tmp = new Node(v, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
	}
	
	public void removeStart(int c){
		for(int i = c; i > 0; i-- ) {
		if(head == null)
			return;
		else{
			head = head.next;
			head.prev = null;
		}
		}
	}
	
	public void removeLast(int c1) {
		for(int j = c1; j > 0; j--) {
		if(tail == null)
			return;
		else {
			tail = tail.prev;
			tail.next = null;
		}
		}
	}

	int get(int pos)  {
    Node p = head;
		for (int i = 0; i < pos; i++) {
			p = p.next;
		}
		return p.val;
	}

	int size() {
		int i = 0;
		for (Node p = head;  p!=null; p = p.next) {
			i++;
		}
		return i;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileReader("HW4a.txt"));
		LinkedList a = new LinkedList();
		while(sc.hasNext()) {
			switch(sc.next()) {
			case "ADD_FRONT" :
				String [] strs = sc.nextLine().trim().split(":");
				int start = Integer.valueOf(strs[0]);
				int step = Integer.valueOf(strs[1]);
				int end = Integer.valueOf(strs[2]);

				for(int i = start;i <= end;i += step)
					a.addStart(i);

			continue;
			
			case "ADD_BACK":
				String [] strs1 = sc.nextLine().trim().split(":");
				int start1 = Integer.valueOf(strs1[0]);
				int step1 = Integer.valueOf(strs1[1]);
				int end1 = Integer.valueOf(strs1[2]);

				for(int i = start1;i <= end1;i += step1)
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
					a.removeLast(val1);

			continue;
			
			case "OUTPUT" :
				for (int i = 0; i < a.size(); i++){
					System.out.print(a.get(i)+ " ");}
				System.out.println();
			continue;
			
			default:
				System.out.println("Wrong command");
			continue;
			}		
		}
		sc.close();
	}

	}

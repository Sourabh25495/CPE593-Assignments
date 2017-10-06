import java.io.*;
import java.util.*;
public class GrowArray {
	private int[] p;
	private int used;
	private int size;
	// this should double the size of your list
	private	void grow() {
	  int s = size *2;
	  int[] temp=new int[s];
	  for(int j=0;j<p.length;j++)
		  temp[j] = p[j];
	  p = new int[s];
	  size = s;
	  for(int j=0;j<p.length;j++)
		  p[j] = temp[j];
	  
	}
	public GrowArray() {
		p = new int[2];
		used = 0;
		size = 2;
	}
	GrowArray(int capacity) {
		p = new int[capacity];
		used = 0;
		size = capacity;
	}
	
	// add elements to the front
	public void addStart(int v) { // O( n )
		if(size==used)
			grow();
		for(int i = p.length - 1; i > 0; i--){ // start at the end.
		     p[i] = p[i-1]; // move every element up 1... that is set the current element to the prior element.
		  }
		      p[0] = v;  // set the initial value.
		      used++;
		      size = used;
		  }
		
	// add elements to the back
 	public void addEnd(int v) {  //O(  1  )
		if (used == size)
			grow();
		// O(1)
		p[used] = v;
		used++;
	}
 	
 	//remove element from front
 	public void removeStart(int quantity) { // O( n )
 		for(int i=0;i<used-quantity;i++)
 			p[i] = p[quantity+i];
 		used -= quantity;
 		}
 	
 	// remove element from back
 	public void removeEnd(int quantity) { // O ( 1 )
 		used -= quantity;
 	}
 	
 	// OUTPUT function 
 	public void output() { // O(n)
 		System.out.println();
 		for(int i=0;i<used;i++)
 			System.out.print(p[i]+ " ");
 	}
 	
 	// Other possible functions
 	
  public int getCapacity() {
    return p.length;
	}

	public int getUsed() {
		return used;
	}
	int get(int i) { //O(1)
		return p[i];
	}
  void set(int i, int v) { // O(1)
		p[i] = v;
	}

public static void main(String[] args) throws Exception
 {
	Scanner sc = new Scanner(new FileReader("HW4a.txt"));
	GrowArray a = new GrowArray();
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
				a.removeEnd(val1);

		continue;
		
		case "OUTPUT" :
				a.output();
		continue;
		
		default:
			System.out.println("\nWrong command");
		continue;
		}		
	}
	sc.close();
}
}
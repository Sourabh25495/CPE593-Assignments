/*
author: Sourabh Kulkarni
*/

import java.io.*;
import java.util.*;


class GoodGrowArray{

    private int p[];
    private int used;
    private int size;

    public GoodGrowArray() {
		p = new int[2];
		used = 0;
		size = 2;
	}

    


    public void grow(){  // grow the array
        int s = size*2;
        int[] temp = new int[s];
        for(int j=0;j<p.length;j++)
		    temp[j] = p[j];
	        p = new int[s];
	        size = s;
	    for(int j=0;j<p.length;j++)
		    p[j] = temp[j]; 

    }




    GoodGrowArray(int capacity) {  //Set capacity
		p = new int[capacity];
		used = 0;
		size = capacity;
	}

    public void output() { // O(n)
 		System.out.println();
 		for(int i=0;i<used;i++)
 			System.out.print(p[i]+ " ");
            System.out.println(" ");
         System.out.println(" ");
 	}
     
 	

    public void removeEnd(int val){

        used-=val;

    }

    public void removeStart(int val){
        for(int i=0;i<used-val;i++)
            p[i]=p[val+i];
        used-=val;

    }

    public void addEnd(int v){
        if(size==used)
            grow();

        p[used]=v;
        used++;

    }
    

    public void addStart(int v){
        if(size==used){
            grow();   //If that array is full then grow by allocationg more memory
        }

        for(int i=p.length-1; i > 0; i--){
            p[i]=p[i-1];
        }

        p[0]=v;
        used++;
        size=used;


    }
    

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new FileReader("HW4a.txt"));
        GoodGrowArray a = new GoodGrowArray();


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
            a.output();
            continue;
            }
           

        }
    }

}
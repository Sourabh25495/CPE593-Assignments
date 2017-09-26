/*
author: sourabh kulkarni
cite: Some help taken from aakanksha gokhe
*/


import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;
	
import java.io.*;

class heapSort{


public static void main(String[] args)throws FileNotFoundException {

    Scanner scan = new Scanner(new File("hw2a.dat"));
			int i=0;
			String line = scan.nextLine();
			int a=Integer.parseInt(line);
			//System.out.println(a);
			String line1;
			int x=0;

    	 
		while(scan.hasNextLine()){
					if(x<a){
        	  int a1=Integer.parseInt(scan.nextLine()); 
			  String b[]=scan.nextLine().split(" ");
			  int[] nums = new int[b.length];

			  for( i=0;i<nums.length;i++)
			  		nums[i] = Integer.parseInt(b[i]);

				int L=0;
				int R=nums.length;
				 
				 heapSort(nums, R);

			  for( i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println(" ");
    
x++;
}else{
		//System.out.println(" ");
		break;
}
}
}


//heapIt
public static int heapSort(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			throw new IllegalArgumentException("Invalid input");

		buildHeap(nums);

		int size = nums.length;

		for(int i = 1;i < k;i++)
		{
			
			int t = nums[0];
			nums[0] = nums[size-1];
			nums[size-1] = t;
			size--;
			maxHeap(nums,0,size);
		}

		return nums[0];
	}
private static void buildHeap(int [] nums)
	{
		for(int i = nums.length / 2;i >= 0;i--)
			maxHeap(nums,i,nums.length);
	}

	private static void maxHeap(int [] nums, int parent, int size)
	{
		int l = parent * 2 + 1;
		int r = l + 1;
		int largest = parent;

		if(l < size && nums[l] > nums[largest])
			largest = l;

		if(r < size && nums[r] > nums[largest])
			largest = r;

		if(largest != parent)
		{
			
			int t = nums[largest];
			nums[largest] = nums[parent];
			nums[parent] = t;
			maxHeap(nums,largest,size);
		}
	}


	public static void print(int[] x) {
		for (int i = 0; i < x.length; ++i){
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

}
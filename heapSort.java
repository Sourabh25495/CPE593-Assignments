import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;
	
import java.io.*;

class heapSort{


public static void main(String[] args)throws FileNotFoundException {

    	Scanner scan = new Scanner(new File("hw2a.dat"));

			String line = scan.nextLine();
			int a=Integer.parseInt(line);
			//System.out.println(a);
			String line1;

    	while(scan.hasNextLine()){

        	  int a1=Integer.parseInt(scan.nextLine()); 
			  String b[]=scan.nextLine().split(" ");
			  int[] nums = new int[b.length];
			  for(int i=0;i<nums.length;i++)
			  	nums[i] = Integer.parseInt(b[i]);
				int L=0;
				int R=nums.length-1;
				 //System.out.print(R);
				 heapSort(nums, R);

			  for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println(" ");
    
}
	
}


//heapIt
public static int heapSort(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			throw new IllegalArgumentException("Input is invalid");

		buildHeap(nums);

		int size = nums.length;

		for(int i = 1;i < k;i++)
		{
			swap(nums,0,size - 1);
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
			swap(nums,largest,parent);
			maxHeap(nums,largest,size);
		}
	}

	private static void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void print(int[] x) {
		for (int i = 0; i < x.length; ++i)
			System.out.print(x[i] + " ");
		System.out.println();
	}




}
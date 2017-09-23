import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;
	
import java.io.*;

class QuickSort{


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
				 Quick(nums, L, R);

			  for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println(" ");
    
}
	
}






public static void Quick(int a[], int L, int R){
		if(a.length==0 || a==null)
			return;
		
		int middle=(L+R)/2;
		int pivot=a[middle];
		//System.out.print(pivot);
		int i=L, j=R;
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
 
			while (a[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		//return a;
		if(L<j)
			Quick(a, L, j);
		if(i<R)
			Quick(a, i, R);

		
				
		
	}
    


}




    

import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;	
import java.io.*;



class countPrime{


public static void main(String[] args)throws FileNotFoundException {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter lower limit");
    int a=sc.nextInt();
    System.out.println("Enter Ypper limit");
    int b=sc.nextInt();
    
    int count=0;
    
    ;
    int x=countPrimes(a,b, count);
    System.out.println(x);
}
	






public static int countPrimes(int a, int b, int count) {


    
    

   boolean[] primes = new boolean[b+1];
	for (int i = 2; i < b; i++)
		primes[i] = true;
 
	for (int i = 2; i <=(b - 1); i++) {

		if (primes[i]) {
			for (int j = i+i ; j < b; j +=i){
				primes[j] = false;
                //System.out.println(j);
            }
		}
	}
 
	//count = 0;
	for (int i = a; i <=b; i++) {
         //System.out.println(i);
		if (primes[i])
        {
           
			count++;
        }
          
	}
   
	return count;
    

}

    


}

/*
author: Sourabh Kulkarni
*/

import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;	
import java.io.*;



class Primes{


public static void main(String[] args)throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter lower limit");
    long a = sc.nextLong();
    System.out.println("Enter upper limit");
    long b = sc.nextLong();
	long range = b-a;
	int range1= (int) range;

	
    
    long count = 0;
    
    
    long x = countPrimes(a,b, count);
    System.out.println(x);
}
	






public static long countPrimes(long a, long b, long count) {

	// works till 10^9

/*
   boolean[] primes = new boolean[(int)b+1];
	for (int i = 0; i < range; i++)
		primes[(int)i] = true;
 
	for (long i = a; i <=(b ); i++) {

		if (primes[(int)i]) {
			for (long j = i*2 ; j <= range; j +=i){
				primes[(int)j] = false;
                //System.out.println(j);
            }
		}
	}
 
	//count = 0;
	for (long i = a; i <= b; i++) {
         //System.out.println(i);
		if (primes[(int)i])
        {
           System.out.println(i);
			count++;
        }
          
	}
   
	return count;
	*/
    

	// works till 10^14
    long sqrtB = (long)Math.sqrt(b);
			long n = b - a + 1;//The number of primes among the range
			BitSet seive = new BitSet((int)sqrtB + 1);
			BitSet range = new BitSet((int)n + 1);
			for(int i = 2;i <= sqrtB;i++)
			{
					if(!seive.get(i))
					{
						for(int k = i;k <= sqrtB;k += i)
						{
							seive.set(k);
						}
						long ratio = a / i;
						for(long j = ratio * i;j <= b;j += i)
						{
							if(j >= a)
							{
								if(j == i)
									continue;
								int index = (int)(j - a);
								if(!range.get(index))
								{
									range.set(index);
									n--;
								}
							}
						}
					}
			}
            
			
			return n;
			
    

}


    


}

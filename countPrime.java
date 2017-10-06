import java.util.*;
	
import java.io.IOException;
import java.util.ArrayList;	
import java.io.*;



class countPrime{


public static void main(String[] args)throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter lower limit");
    long a = sc.nextLong();
    System.out.println("Enter Ypper limit");
    long b = sc.nextLong();
    
    long count = 0;
    
    ;
    long x = countPrimes(a,b, count);
    System.out.println(x);
}
	






public static long countPrimes(long a, long b, long count) {

/*
   boolean[] primes = new boolean[(int)b+1];
	for (int i = 2; i < b; i++)
		primes[(int)i] = true;
 
	for (long i = 2; i <=(b - 1); i++) {

		if (primes[(int)i]) {
			for (long j = i+i ; j < b; j +=i){
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
           
			count++;
        }
          
	}
   
	return count;
    */



    //this works for numbers > 10^9
    long sqrtB = (long)Math.sqrt(b);
			long nop = b - a + 1;//The number of primes among the range
			BitSet seive = new BitSet((int)sqrtB + 1);
			BitSet range = new BitSet((int)nop + 1);
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
									nop--;
								}
							}
						}
					}
			}
            
			return nop;
    

}

    


}

/*
author: Sourabh kulkarni
*/



import java.util.*;


class HashLP{
   
    int size;
    int[] table;
    int[] count ;
    public HashLP(int n){
        table = new int[n];
        count = new int[n];
        size = n;
    }
    
public void addNumber(int number){
    int key = myKey(number);
    System.out.println("The key for "+ number+ " is "+ key);
    int attempts = 0;
    if(key< size){
        if(table[key]!=0){
            
            for(int i=key; i < size; i++){
                attempts++;
                if(table[i] == 0){
                    table[i] = number;
                    count[attempts]++;
                    return;
                }
            }
        }else{
            count[1]++;
            table[key] = number;
        }
    }
    



}

public int myKey(int number){
    return  number % size;
}

public void printHash(){
    int noOfZeros = 0;
    for(int i = 0; i < table.length; i++){
        if(table[i] == 0){
            noOfZeros++;
        }
        System.out.print(table[i]+ " ");
        
    }
    System.out.println("");
    System.out.println("0"+"    "+noOfZeros );
    for(int i = 1; i < count.length; i++){
        System.out.println(i+"    "+count[i] );
    }
}






    public static void main(String args[]){
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        System.out.println("Enter a number: ");
        int n = reader.nextInt(); 

         HashLP hashlp = new HashLP(n);

        for(int i =1; i<= n; i++ ){
          hashlp.addNumber(i);  
        }
        //  hashlp.addNumber(14);
        //  hashlp.addNumber(44);
        //  hashlp.addNumber(5);

        //  hashlp.addNumber(7);
        //  hashlp.addNumber(40);
        //  hashlp.addNumber(10);
        //  hashlp.addNumber(64);
        //  hashlp.addNumber(24);
        //  hashlp.addNumber(94);

         hashlp.printHash();

    }
}
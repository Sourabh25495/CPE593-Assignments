
import java.util.*;

class SortIt{


    public static void main(String args[]){
        Scanner s=new Scanner(System.in);

        System.out.println("enter number of elements");

        int n=s.nextInt();

        int arr[]=new int[n];

        System.out.println("enter elements");

        for(int i=0;i<n;i++){//for reading array
            arr[i]=s.nextInt();

        }
        sortForLargeNumbers(arr);
        sortForLargeNumbers1(arr);


    }

     public static void sortForLargeNumbers(int input []){
        int comparisons =0, swaps = 0;
        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input.length; j++){
                comparisons++;
                if (input[i] < input[j]) {

                    swaps++;

                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }

            }
        }

        for(int i: input){ //for printing array

        System.out.print(i);

    }

    System.out.println("Bubble Sort");
    System.out.println(comparisons);
    System.out.println(swaps);
     System.out.println(" ");





    }


    public static void sortForLargeNumbers1(int  input[]){
        int comparisons =0, swaps = 0;
        boolean sorted = true;
        for (int i = 0; i < input.length; i++){

            for (int j = 0; j < input.length - 1; j++){
                comparisons++;

                if (input[i] < input[j]) {

                    swaps++;

                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                    sorted = false;
                }

            }
            if(sorted){
                break;
            }
        }
        for(int i: input){ //for printing array
      
        System.out.print(i);

    }

    System.out.println("Imp Bubble Sort");
    System.out.println(comparisons);
    System.out.println(swaps);


    }

}
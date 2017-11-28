
import java.util.*;
import java.io.*;

public class Hash {

    public class LinkedHashEntry {
    private int key;
    private String value;
    private LinkedHashEntry next;

    LinkedHashEntry(int key, String value) {
          this.key = key;
          this.value = value;
          this.next = null;
    }

    public String getValue() {
          return value;
    }

    public void setValue(String value) {
          this.value = value;
    }

    public int getKey() {
          return key;
    }

    public LinkedHashEntry getNext() {
          return next;
    }

    public void setNext(LinkedHashEntry next) {
          this.next = next;
    }
}
	
    private final static int TABLE_SIZE = 128 ;
    static int[] hist = new int[TABLE_SIZE];

    LinkedHashEntry[] table;

    Hash() {
          table = new LinkedHashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }
    public int hash(int k){
    	int h = k % TABLE_SIZE;
    	return h;
    }
    
    public String get(int key) {
          int hash = hash(key);
          if (table[hash] == null)
                return null;
          else {
                LinkedHashEntry entry = table[hash];
                while (entry != null && entry.getKey() != key)
                      entry = entry.getNext();
                if (entry == null)
                      return null;
                else
                      return entry.getValue();
          }
    }

    public void put(int key, String value) {
    		
          int hash = hash(key);
          if (table[hash] == null) {
                table[hash] = new LinkedHashEntry(key, value);
                hist[hash]=1;
          }
          else {
                LinkedHashEntry entry = table[hash];
                while (entry.getNext() != null && entry.getKey() != key)
                      entry = entry.getNext();
                	  
                if (entry.getKey() == key){
                      entry.setValue(value);
                      hist[hash]+=1;
                }
                else {
                      entry.setNext(new LinkedHashEntry(key, value));
                      hist[hash]+=1;
                }
          }
    }

    public void remove(int key) {
          int hash = hash(key);
          if (table[hash] != null) {
                LinkedHashEntry prevEntry = null;
                LinkedHashEntry entry = table[hash];
                while (entry.getNext() != null && entry.getKey() != key) {
                      prevEntry = entry;
                      entry = entry.getNext();
                }
                if (entry.getKey() == key) {
                      if (prevEntry == null)
                           table[hash] = entry.getNext();
                      else
                           prevEntry.setNext(entry.getNext());
                }
          }
    }
    
    public void print_hist(){
    	System.out.println("insert\t\tcount");
    	for (int k = 1; k< TABLE_SIZE;k++){
     		int h1 = k % TABLE_SIZE;
     		System.out.println(k+"\t\t"+hist[h1]);
     	}
    }
    
    public static void main(String[] args)throws Exception{
    	Hash h = new Hash();
    	try{
    		int k = 0;
 		   File input= new File("dict.txt");
 		   StreamTokenizer tokenizer= new StreamTokenizer(
 		                 new BufferedReader(new FileReader(input)));
 		   tokenizer.lowerCaseMode(true); 
 		   while(tokenizer.nextToken()!=tokenizer.TT_EOF)  {
 			   k++;
 		     if(tokenizer.ttype==tokenizer.TT_WORD) {
 		      String word=tokenizer.sval; // get the next word
 		      h.put(k,word);
 		     }
 		   }
 		   //System.out.println("Insert Complete");
 		  }
 		  catch(IOException e)                 // Error reading in nextToken()
 		  {
 		      System.out.println(e);             
 		      System.exit(1);                    
 		  }	
      Scanner sc1 = new Scanner( new FileReader("hw8.txt"));
 	int b =0;
 	while(sc1.hasNext()){
 		String s1 = sc1.next();
 		for(int k1 =1;k1<TABLE_SIZE;k1++){
 			String s=h.get(k1);
 			if(s1.equals(s)== true) {
 				b =1;
 			}
 		}
 		if(b==1){
 				System.out.println("TRUE");
 			}
 			else{
 				System.out.println("FALSE");
 			}		
 	}
 	h.print_hist();
}
}
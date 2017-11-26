/*
author: sourabh kulkarni
*/

import java.util.*;
import java.io.*;;

class Trie{
    class TrieNode{
        TrieNode[] arr;
        boolean isEnd;

        public TrieNode() {
        this.arr = new TrieNode[30];
    }
    }

private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        // code goes here
        TrieNode p = root;
        for (int i =0;i<word.length() ; i++){
            char c = word.charAt(i);
            int ind = c-'a';
             if(p.arr[ind]==null){
                TrieNode temp = new TrieNode();
                p.arr[ind]=temp;
                p = temp;
            }else{
                p=p.arr[ind];
            }
        }
        p.isEnd = true;

    }

    public boolean search(String word){
        // code goes here
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;

    }

    public TrieNode searchNode(String s){
        // code goes here
        TrieNode p = root;
        for (int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            int ind = c-'a';
            if(p.arr[ind]!=null){
                p = p.arr[ind];
            }else{
                return null;
            }
        }
         if(p==root)
            return null;
 
        return p;

    }



    public static void main(String[] args) throws Exception{
        Trie T = new Trie();

        try{
                File input= new File("dict.txt");
                StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(input)));
                //code goes here
                tokenizer.lowerCaseMode(true);
                while(tokenizer.nextToken()!=tokenizer.TT_EOF)  {
                        if(tokenizer.ttype==tokenizer.TT_WORD) {
                        String word=tokenizer.sval; // get the next word
                        T.insert(word);//insert it starting at letter position 0
                        }
                    } 
        }
        catch(IOException e){
            System.out.println(e);             
            System.exit(1); 
        }       

    
    Scanner sc = new Scanner( new FileReader("hw5.txt"));
    	boolean b;
    	while(sc.hasNext()){
    		b=T.search(sc.next());
    	if(b == true) {
    		System.out.println("TRUE");
    	}
    	else{
    		System.out.println("FALSE");
    	}		
    	}
    }


}
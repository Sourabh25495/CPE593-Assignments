import java.util.*;

class Trie{
    class TrieNode{
        TrieNode[] arr;
        boolean isEnd;

        public TrieNode() {
        this.arr = new TrieNode[26];
    }
    }

private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        // code goes here
    }

    public boolean search(String word){
        // code goes here
    }

    public TrieNode searchNode(String s){
        // code goes here
    }



    public static void main(String[] args) throws Exception{
        Trie t = new Trie();

        File input= new File("dict.txt");
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader(input)));
        //code goes here
        

    }


}
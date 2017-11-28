/*
author: Sourabh Kulkarni
cite: Help taken from Pranit
*/
import java.io.*;
import java.util.*;

  class Node{
            String word;
            Node next;
    
            public Node(String word){
                this.word = word;
                this.next = null;
            }
        }


class HashLC {

    static int SIZE = 500;

    public static class LinkedList{

        int count = 0;

    
        Node head;

        public void addStart(String word){
            
            Node node = new Node(word);

            count++;

            if(head == null){
            
                head = node;
            
                return;
            }
            
            node.next = head;
            head = node;
            
                   // displayLinkedList();
        }

        public Boolean searchList(String word){

 
            for(Node node = head ; node != null ; node = node.next)
                if(node.word.equals(word)){
                   //System.out.println(word);
                    return true;
                }

            return false;
        }

        public int getLength(){
            return count;
        }

        public void displayList(){

            StringBuilder stringBuilder = new StringBuilder();

            for(Node node = head; node.next != null ; node = node.next){
                stringBuilder.append(node.word+" -> ");
            }

            stringBuilder.append("NULL");

            System.out.println(stringBuilder.toString());
        }
    }

    public static class MapNode{

        LinkedList list;
        
        public MapNode(){
            //System.out.print("Constructor called");
            list = new LinkedList();
        }
    }

    public static class HashMapLinearChaining{

        private MapNode[] table = new MapNode[SIZE];

        public void add(String word){

            int key = getKey(word);

            //System.out.println("Key for "+word+" is "+key);

            if(table[key] == null)  
                table[key] = new MapNode(); // if node is not already created then create one..

            //System.out.println("Table item list -> "+table[key].list);
            table[key].list.addStart(word);

        }

        public Boolean search(String searchWord){
            
            for(int i=0; i < table.length; i++){
                if(table[i].list.searchList(searchWord))    // search in the list of this index
                //System.out.println("I am here");
                    return true;
            }

            return false;
        }

        private int getKey(String word){ // HASH FUNCTION
            int key = 0;
            int len = word.length();

            for(int i=0; i < len; i++)
                key += word.charAt(i);

            return key%SIZE;
            //return number%SIZE;
        }

        public void displayHashMap(){
            for(int i=0; i < table.length; i++)
                if(table[i] == null)
                    System.out.println("NONE");
                else
                    table[i].list.displayList();
        }

        public void showHist(){
            for(int i=0; i < table.length; i++)
                if(table[i] == null)
                    System.out.println(i+" 0");
                else
                    System.out.println(i+" "+table[i].list.getLength());

        }
        
        
    }

    public static void main(String[] args) {

        final String dictonaryFileName = "dict.txt";

        try{

            FileReader fileReader = new FileReader(dictonaryFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            HashMapLinearChaining myHashMap = new HashMapLinearChaining();

            String line = "";

            while((line = bufferedReader.readLine())!= null){

                myHashMap.add(line.trim());

            }

            //final String wordToBeSearched = "aa";

            Scanner sc1 = new Scanner( new FileReader("hw8.dat"));

            while(sc1.hasNext()){
                String s1 = sc1.next();
               // System.out.println(s1);
                System.out.println(myHashMap.search(s1));
            }
            System.out.println(" ");

            
            myHashMap.showHist();
            //myHashMap.displayHashMap();

            bufferedReader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }


}
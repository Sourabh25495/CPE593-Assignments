class DlinkedList{
    class Node{
        int val;
        Node next;
        Node prev;

    }
public Node(int v,Node next,Node prev){
    val = v; this.next = next; this.prev = prev; 
}

private Node head;
private Node tail;

public DlinkedList(){
    head = null;
    tail = null;

}

public void addStart(){


}

public void addEnd(){


}

public void removeStart(){


}

public void removeEnd(){

    
}





















public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new FileReader("HW4a.txt"));
        GoodGrowArray a = new GoodGrowArray();


        while(sc.hasNext()) {
		switch(sc.next()) {
		case "ADD_FRONT" :
			String [] strs = sc.nextLine().trim().split(":");
			int start = Integer.valueOf(strs[0]);
			int step = Integer.valueOf(strs[1]);
			int end = Integer.valueOf(strs[2]);

            for(int i=start;i<end;i+=step){
                a.addStart(i);
            


            }
            continue;

        case "ADD_BACK" :

            String [] strs1 = sc.nextLine().trim().split(":");
			int start1 = Integer.valueOf(strs1[0]);
			int step1 = Integer.valueOf(strs1[1]);
			int end1 = Integer.valueOf(strs1[2]);

			for(int i = start1;i <=end1;i += step1)
				a.addEnd(i);

            continue;
                
        case "REMOVE_FRONT" :

            String [] strs2 = sc.nextLine().split(" ");
			int val = Integer.valueOf(strs2[1]);
				a.removeStart(val);

            continue;

        case "REMOVE_BACK" :

            String [] strs3 = sc.nextLine().split(" ");
			int val1 = Integer.valueOf(strs3[1]);
				a.removeEnd(val1);

            continue;

        case "OUTPUT" :
            a.output();
            continue;
            }
           

        }
    }















}
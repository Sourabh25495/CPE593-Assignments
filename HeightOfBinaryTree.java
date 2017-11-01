


  class Node{
        Node left;
        Node right;
        int data;

        
        Node(int item){
        left = right = null;
        data = item;
    }
      
    }

class HeightOfBinaryTree{
  

Node root;

int maxDepth(Node node){
    if(node == null){
        return 0;
    }else{
        // write code to calculate the depth
        int ldepth = maxDepth(node.left);
        int rdepth = maxDepth(node.right);

        if(ldepth > rdepth){
            return (ldepth+1);
        }else{
            return (rdepth+1);
        }
        
    }
}

public static void main(String[] args) 
    {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The height of the tree is "+ tree.maxDepth(tree.root));
  

    }



}
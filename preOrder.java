/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/


// preorder traversal of a tree
void preOrder(Node root) {
    Stack<Node> s = new Stack<Node>();
    s.push(root);
    while(!s.isEmpty()){
        Node thisNode = stack.pop();
        if(thisNode.right!= null)
            s.push(thisNode.right);
        if(thisNode.left!= null)
            s.push(thisNode.left);
        System.out.print(thisNode.data + " ")
        
    }

}
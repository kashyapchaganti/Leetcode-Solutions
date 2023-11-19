/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node last, first;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        check(root);
        first.left=last;
        last.right= first;
        return first;
        
    }
    public void check(Node root){
        if(root==null) return; 
        check(root.left);
        if(last!=null){
            last.right=root;
            root.left=last;
            
        }else{
            first = root;
        }
        last= root;
        check(root.right);
        
    }
}
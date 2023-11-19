/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st= new Stack();
        addLeft(root);
    }
    
    public int next() {
        TreeNode next = st.pop();
        addLeft(next.right);
        return next.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
    public void addLeft(TreeNode root){
        if(root==null){
            return ;
        }
        st.add(root);
        addLeft(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
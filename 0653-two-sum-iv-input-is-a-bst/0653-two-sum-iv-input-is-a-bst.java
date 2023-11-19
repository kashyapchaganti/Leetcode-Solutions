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
class Solution {
    Stack<TreeNode> stDesc,stAsc;
    public boolean findTarget(TreeNode root, int k) {
        stDesc = new Stack();
        stAsc = new Stack();
        addLeft(root);
        addRight(root);
        while(!stDesc.isEmpty() && !stAsc.isEmpty()){
            if(stAsc.peek().equals(stDesc.peek()))return false;
            int total= stAsc.peek().val+ stDesc.peek().val;
            
            if(total==k) return true;
            if(total>k){
                getDesc();
            }else{
                getAsc();
            }
            
        }
        return false;
        
    }
    public void addLeft(TreeNode root){
        if(root==null) return;
        stAsc.push(root);
        addLeft(root.left);
    }
    public void addRight(TreeNode root){
       if(root==null) return;
        stDesc.push(root);
        addRight(root.right); 
    }
    public int getDesc(){
        TreeNode next= stDesc.pop();
        addRight(next.left);
        return next.val;
    }
    public int getAsc(){
        TreeNode next= stAsc.pop();
        addLeft(next.right);
        return next.val;
        
    }
}
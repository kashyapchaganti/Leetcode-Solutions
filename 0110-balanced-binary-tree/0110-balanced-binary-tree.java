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
    boolean f;
    public boolean isBalanced(TreeNode root) {
        f=true;
        check(root,0);
        return f;
    }
    public int check(TreeNode root, int level){
        if(root==null){
            return level;
        }
        
        
        int a = check(root.left, level+1);
        int b = check(root.right, level+1);
        
        if(Math.abs(a-b)>1) f= false;
        
        return Math.max(a,b);
        
    }
}
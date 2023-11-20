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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        check(root);
        return;
    }
    public TreeNode check(TreeNode root){
        if(root==null) return null;
        
        TreeNode r= check(root.right);
        TreeNode l =check(root.left);
        
        root.left =null;
        root.right = prev;
        prev= root;
        return root;
        
    }
}
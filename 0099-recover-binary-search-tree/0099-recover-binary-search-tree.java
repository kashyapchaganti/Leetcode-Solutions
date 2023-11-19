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
    TreeNode first,middle, last, prev; 
    
    public void recoverTree(TreeNode root) {
        prev= new TreeNode(Integer.MIN_VALUE);
        check(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val= last.val;
            last.val= t;
        }else{
            int t = first.val;
            first.val= middle.val;
            middle.val= t;
        }
    }
    public void check(TreeNode root){
        if(root==null) return;
        
        check(root.left);
        if(root.val<prev.val){
           if(first==null){
               first= prev;
               middle= root;
           } else{
               last = root;
           }
        }
        prev= root;
        check(root.right);
    }
}
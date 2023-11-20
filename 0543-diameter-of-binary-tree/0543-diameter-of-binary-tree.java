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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        max=0;
        check(root);
        return max;
    }
    public int check(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int a = check(root.left); 
        int b = check(root.right);
        
        max = Math.max(max, a+b);
        // System.out.println(root.val +" "+level +" "+ a +" "+b);
        return Math.max(a,b)+1;
        
    }
}
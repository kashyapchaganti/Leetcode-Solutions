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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return check(root)+1;
    }
    public int check(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 0;
        }
        int max= (int)(1e9);
        if(root.left!=null){
            max= 1+check(root.left);
        }
        if(root.right!=null){
            max= Math.min(max, 1+ check(root.right));
        }
        
        return max;
    }
}
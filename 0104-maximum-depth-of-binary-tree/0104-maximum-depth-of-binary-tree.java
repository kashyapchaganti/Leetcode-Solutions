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
    public int maxDepth(TreeNode root) {
        return check(root,0);
    }
    public int check(TreeNode root, int level){
        if(root==null){
            return 0;
        }
        
        int a = check(root.left, level+1);
        int b = check(root.right, level+1);
        return Math.max(a,b)+1;
    }
}
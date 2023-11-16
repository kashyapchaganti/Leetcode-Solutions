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
        check(root,0);
        return max;
    }
    public int check(TreeNode root, int level){
        if(root==null){
            return level-1;
        }
        
        int a = check(root.left, level+1);
        int b = check(root.right, level+1);
        
        max = Math.max(a-level + b-level, max);
        return Math.max(a,b);
        
    }
}
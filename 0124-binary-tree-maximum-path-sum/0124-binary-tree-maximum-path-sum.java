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
    public int maxPathSum(TreeNode root) {
        max= (int)(-1e9);
        check(root);
        return max;
    }
    public int check(TreeNode root){
        if(root ==null){
            return 0;
        }
        
        int a = check(root.left);
        int b = check(root.right);
        a= Math.max(a,0);
        b= Math.max(b,0);
        max = Math.max(a+b+root.val, max);
        return Math.max(a,b)+root.val;
    }
}
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
    public int maxAncestorDiff(TreeNode root) {
        return check(root, Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public int check(TreeNode root, int cur_min, int cur_max){
        if(root==null){
            return cur_max-cur_min;
        }
        cur_min= Math.min(cur_min, root.val);
        cur_max= Math.max(cur_max, root.val);
        
        int left = check(root.left, cur_min,cur_max);
        int right = check(root.right, cur_min,cur_max);
        
        return Math.max(left,right);
    }
}
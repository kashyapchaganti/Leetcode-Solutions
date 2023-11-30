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
    int ans;
    public int distributeCoins(TreeNode root) {
        ans=0;
        check(root);
        return ans;
    }
    public int check(TreeNode root){
        if(root==null)return 0;
        int l= check(root.left);
        int r= check(root.right);
        ans+=Math.abs(l)+Math.abs(r);
        return root.val+l+r-1;
        
        
    }
}


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
    int cnt; 
    public int kthSmallest(TreeNode root, int k) {
        cnt=0;
        return check(root,k).val;
    }
    public TreeNode check(TreeNode root, int k){
        if(root==null) return null;
        
        
        
        TreeNode left = check(root.left,k);
        cnt++;
        if(cnt==k)return root;
        TreeNode right = check(root.right,k);
        
        
        if(left!=null) return left;
        return right;
        
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return check(root,p,q)  ; 
    }
    public TreeNode check(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return root;
        }
        
        TreeNode l = check(root.left, p,q);
        TreeNode r = check(root.right, p,q);
        if(root==p || root ==q){
            return root;
        }
        
        
        if(l!=null && r!=null){
            return root;
        }
        if(l!=null && r==null){
            return l;
        }
        return r;
        
    }
}
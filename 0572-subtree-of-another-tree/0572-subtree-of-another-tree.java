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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return check(root,subRoot);
    }
    public boolean check(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        boolean a= check2(root, subRoot);
        boolean b= check2(root.left, subRoot);
        boolean c= check2(root.right, subRoot);
        if(a || b || c) return true;
        return check(root.left,subRoot) || check(root.right,subRoot);
    }
    public boolean check2(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        if(root.val!=subRoot.val) return false;
        return check2(root.left,subRoot.left) && check2(root.right, subRoot.right);
    }
}
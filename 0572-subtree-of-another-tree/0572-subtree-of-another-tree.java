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
        if(a) return true;
        boolean b= check(root.left, subRoot);
        if(b) return true;
        boolean c= check(root.right, subRoot);
        if(c) return true;
        return false;
    }
    public boolean check2(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        if(root.val!=subRoot.val) return false;
        return check2(root.left,subRoot.left) && check2(root.right, subRoot.right);
    }
}
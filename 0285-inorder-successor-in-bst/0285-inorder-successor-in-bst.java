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
    int min;
    TreeNode ans;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        min= Integer.MAX_VALUE;
        
        check(root, p);
        return ans;
    }
    public void check(TreeNode root, TreeNode p){
        if(root==null) return ; 
        
        if(root.val>p.val){
            if(root.val<min){
                min= root.val;
                ans = root;
            }
            check(root.left,p);
            
        }else{
            check(root.right,p);
        }
        
    }
}
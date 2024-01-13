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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        
        int val1 = root1==null? 0: root1.val;
        int val2 = root2==null? 0: root2.val;
        TreeNode root = new TreeNode(val1 + val2);
        if(root2==null){
            root.left= mergeTrees(root1.left,null);    
        }else if(root1==null){
            root.left= mergeTrees(null,root2.left);    
        }else{
            root.left= mergeTrees(root1.left,root2.left);    
        }
        
        if(root2==null){
            root.right= mergeTrees(root1.right,null);    
        }else if(root1==null){
            root.right= mergeTrees(null,root2.right);    
        }else{
            root.right= mergeTrees(root1.right,root2.right);    
        }
        
        
        return root;
        
        
        
        
    }
}

/*
  1          1
 2              2
3                  3 

*/
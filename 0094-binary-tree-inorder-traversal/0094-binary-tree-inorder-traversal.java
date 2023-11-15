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
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        helperFunction(root);
        return ans;
    }
    public void helperFunction(TreeNode root){
        if(root==null){
            return ;
        }
        helperFunction(root.left);
        ans.add(root.val);
        helperFunction(root.right);
        
        
    }
}

 

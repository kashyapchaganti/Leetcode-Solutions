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
    public int countNodes(TreeNode root) {
        return countNodesHelper(root);
    }
    public int countNodesHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftNodes = countNodesHelper(root.left);
        int rightNodes = countNodesHelper(root.right);
        
        return 1+ leftNodes+rightNodes;
    }
}
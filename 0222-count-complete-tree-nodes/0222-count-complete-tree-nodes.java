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
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);
        
        if(leftHeight==rightHeight) return ((2 << leftHeight)-1);
        return 1+(countNodesHelper(root.left)+countNodesHelper(root.right));
    }
    public int getLeftHeight(TreeNode root){
        if(root==null) return 0;
        int height=0;
        while(root!=null){
            height++;
            root= root.left;
        }
        return height;
    }
    public int getRightHeight(TreeNode root){
        if(root==null) return 0;
        int height=0;
        while(root!=null){
            height++;
            root= root.right;
        }
        return height;
    }
}
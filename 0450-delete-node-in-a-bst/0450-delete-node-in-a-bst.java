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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null){
                    if(root.left.val==key){
                        TreeNode child = helper(root.left);
                        root.left= child;
                        break;
                    }else{
                        root=root.left;
                    }
                }
                else{
                    root= root.left;
            }
            }else if(root.val<key){
                if(root.right!=null){
                    if(root.right.val==key){
                        TreeNode child = helper(root.right);
                        root.right= child;
                        break;
                    }else{
                        root=root.right;
                    }
                }
                else{
                        root=root.right;
                    }
            }
            
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root){
        if(root.left!=null){
            TreeNode rightChild = getRight(root.left);
            if(rightChild!=null)rightChild.right=root.right;
             
            return root.left;
        }else{
            return root.right;
        }
    }
    public TreeNode getRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return getRight(root.right);
    }
}
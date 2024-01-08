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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int a=0,b=0,c=0,d=0;
        if(root.val<low){
            a=rangeSumBST(root.right,low,high);
        }
        else if(root.val>high){
            b=rangeSumBST(root.left,low,high);
        }
        else if (root.val<=high || root.val>=low){
            c=root.val+rangeSumBST(root.right,low,high)+rangeSumBST(root.left,low,high);
        }
        
        return a+b+c;
        
    }
}
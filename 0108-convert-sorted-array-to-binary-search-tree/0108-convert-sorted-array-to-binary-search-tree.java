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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return check(0,nums.length-1);
    }
    public TreeNode check(int left, int right){
        if(left>right){
            return null;
        }
        int m= left+(right-left)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = check(left,m-1);
        root.right = check(m+1, right);
        return root;
    }
}
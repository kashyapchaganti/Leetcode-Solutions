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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        check(root);
        return count;
    }
    public Pair<Integer,Integer> check(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair<Integer,Integer> left = check(root.left);
        Pair<Integer,Integer> right = check(root.right);
        
        int totalSum = left.getKey()+right.getKey()+ root.val;
        int nodes = left.getValue()+right.getValue()+1;
        if(totalSum/nodes == root.val) count++;
        return new Pair(totalSum, nodes);
    }
}
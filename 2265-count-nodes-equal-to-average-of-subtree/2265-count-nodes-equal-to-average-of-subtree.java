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
    int count;
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return 0;
        check(root);
        
        return count;
    }
    public Pair<Integer,Integer> check(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        
        Pair<Integer,Integer> left= check(root.left);
        Pair<Integer,Integer> right= check(root.right);
        
        
        int nodeSum = left.getKey() + right.getKey()+root.val;
        int nodes = left.getValue() + right.getValue()+1;
        
        if(nodeSum/nodes == root.val)count++;
        
        
        return new Pair(nodeSum, nodes);
    }
}
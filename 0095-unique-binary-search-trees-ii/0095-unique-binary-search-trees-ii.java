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
    public List<TreeNode> generateTrees(int n) {
        return check(1,n);
    }
    public List<TreeNode> check( int left, int right){
        List<TreeNode> ans = new ArrayList<>();
        if(left>right){
            ans.add(null);
            return ans;
        }
        
        for( int k=left;k<=right;k++){
            List<TreeNode> l= check(left,k-1); // 1,0 // 
            List<TreeNode> r= check(k+1,right); // 2,3 
            for(TreeNode x: l){
                for(TreeNode y: r){
                    TreeNode root = new TreeNode(k);
                    root.left= x;
                    root.right= y;
                    ans.add(root);
                }
            }
        }
        
        
        return ans;
        
    }
}
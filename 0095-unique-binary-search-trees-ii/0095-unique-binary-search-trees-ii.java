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
        HashMap<String,List<TreeNode>> dp = new HashMap<>();
        return check(1,n,dp);
    }
    public List<TreeNode> check( int left, int right, HashMap<String,List<TreeNode>> dp){
        List<TreeNode> ans = new ArrayList<>();
        if(left>right){
            ans.add(null);
            return ans;
        }
        String x1= left+" "+right;
        if(dp.containsKey(x1)){
            return dp.get(x1);
        }
        for( int k=left;k<=right;k++){
            List<TreeNode> l= check(left,k-1,dp); 
            List<TreeNode> r= check(k+1,right,dp); 
            for(TreeNode x: l){
                for(TreeNode y: r){
                    TreeNode root = new TreeNode(k);
                    root.left= x;
                    root.right= y;
                    ans.add(root);
                }
            }
        }
        dp.put(x1,ans);
        return ans;
        
    }
}
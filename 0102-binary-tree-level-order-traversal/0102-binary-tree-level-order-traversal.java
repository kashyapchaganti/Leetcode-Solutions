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
    List<List<Integer>> ans ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans=  new ArrayList<>();
        if(root==null)return ans;
        helperFunction(root,1);
        return ans;
        
    }
    public void helperFunction(TreeNode root, int level){
        if(root==null){
            return ;
        }
        if(ans.size()<level){
            ans.add(new ArrayList<>());
        }
        ans.get(level-1).add(root.val);
        helperFunction(root.left, level+1);
        helperFunction(root.right, level+1);
    }
}
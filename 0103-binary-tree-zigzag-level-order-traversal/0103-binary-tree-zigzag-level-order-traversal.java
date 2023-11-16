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
    List<List<Integer>> ans;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans= new ArrayList<>();
        check(root,0);
        return ans;
        
    }
    public void check(TreeNode root, int level){
        if(root==null){
            return ;
        }
        
        if(level%2==0){
            if(ans.size()==level){
                ans.add(new ArrayList<>());
                
            }
            ans.get(level).add(root.val);
        }else{
            if(ans.size()==level){
                ans.add(new ArrayList<>());
                
            }
            ans.get(level).add(0,root.val);
        }
        
        check(root.left, level+1);
        check(root.right, level+1);
        
        
    }
    
    
}
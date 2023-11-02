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
    HashMap<TreeNode,Integer> m,c;
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        m=new HashMap<>();
        c=new HashMap<>();
        check(root);
        return ans;
    }
    public void check(TreeNode root){
        if(root==null){
            return;
        }
        
        m.put(root,root.val);
        c.put(root,1);
        if(root.left!=null){
            check(root.left);
            m.put(root,m.get(root.left)+m.get(root));
            c.put(root,c.get(root.left)+c.get(root));
            
        }
        if(root.right!=null){
            check(root.right);
            m.put(root,m.get(root.right)+m.get(root));
            c.put(root,c.get(root.right)+c.get(root));
        }
        if(m.get(root)/c.get(root)==root.val){
            ans++;
        }
        
    }
}
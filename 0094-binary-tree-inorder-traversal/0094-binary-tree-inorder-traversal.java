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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Stack<TreeNode> st = new Stack();
        TreeNode cur =root;
        while(cur!=null || !st.isEmpty()){
            
            while(cur !=null){
                st.push(cur);
                cur=cur.left;
            }
            TreeNode leftMost = st.pop();
            ans.add(leftMost.val);
            if(leftMost.right!=null){
                cur= leftMost.right;
            }
            
        }
        return ans;
    }
    
}
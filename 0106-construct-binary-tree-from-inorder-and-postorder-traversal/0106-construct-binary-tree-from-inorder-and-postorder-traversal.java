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
    HashMap<Integer,Integer> orderMapper; 
    int[] inorder, postorder;
    int n, index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        orderMapper= new HashMap<>();
        this.inorder=inorder;
        this.postorder=postorder;
        n= inorder.length;
        for(int i=0;i <n ;i ++){
            orderMapper.put(inorder[i],i);
        }
        index=n-1;
        return helper(0, n-1);
    }
    public TreeNode helper(int left, int right){
        if(left>right) return null;
        TreeNode root = new TreeNode(postorder[index--]);
        root.right= helper(orderMapper.get(root.val)+1, right);
        root.left= helper(left, orderMapper.get(root.val)-1);
        return root;
    }
}
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
    int size;
    HashMap<Integer,Integer> orderMapper;
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        size = preorder.length;
        orderMapper= new HashMap<>();
        
        for(int i=0;i<size;i++){
            
            orderMapper.put(inorder[i],i);
        }
        
        return buildTreeHelper(preorder, 0, size-1);
        
    }
    public TreeNode buildTreeHelper(int[] preorder,  int left, int right){
        
        if(left>right) return null;
        
        TreeNode root = new TreeNode(preorder[index++]);
        
        root.left = buildTreeHelper(preorder, left, orderMapper.get(root.val)-1);
        root.right = buildTreeHelper(preorder, orderMapper.get(root.val)+1, right);
        
        return root;

        
    }
    
}

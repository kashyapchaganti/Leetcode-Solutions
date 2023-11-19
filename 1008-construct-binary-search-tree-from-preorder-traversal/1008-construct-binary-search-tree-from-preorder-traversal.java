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
    int idx=0;
    HashMap<Integer,Integer> m;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];
        m= new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            inorder[i]= preorder[i];
        }
        Arrays.sort(inorder);
        for(int i=0;i<preorder.length;i++){
            m.put(inorder[i],i);
        }
        return check(inorder,preorder,0,preorder.length-1 );
    }
    public TreeNode check(int[] inorder,int[] preorder, int left, int right){
        
        if(left>right) return null;
        
        TreeNode root= new TreeNode(preorder[idx++]);
        root.left= check(inorder,preorder, left, m.get(root.val)-1);
        root.right= check(inorder,preorder, m.get(root.val)+1, right);
        return root;
    }
}
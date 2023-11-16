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
    List<Integer> res;
    Stack<Integer> st;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res= new ArrayList<>();
        if(root==null) return res;
        res.add(root.val);
        if(root.left!=null)
        addLeft(root);
        if(root.left!=null || root.right!=null)
        addLeaves(root);
        st=new Stack();
        if(root.right!=null)
        addRight(root);
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
        
    }
    public void addLeft(TreeNode root){
        if(root==null) return ; 
        if(root.left!=null){
            if(root.left.left!=null || root.left.right!=null){
                res.add(root.left.val);
                addLeft(root.left);    
            }
            
        }else{
            
            if(root.right!=null){
                if(root.right.left!=null || root.right.right!=null){
                    res.add(root.right.val);
                     addLeft(root.right);    
                }
                
            }
        }
    }
    public void addRight(TreeNode root){
        if(root==null){
            return ;
        }
        if(root.right!=null){
            if(root.right.left!=null || root.right.right!=null){
                st.add(root.right.val);
                addRight(root.right);    
            }
            
        }else{
            if(root.left!=null){
                if(root.left.left!=null || root.left.right!=null){
                    st.add(root.left.val);
                    addRight(root.left);    
                }
                
            }
        }
    }
    public void addLeaves(TreeNode root){
        if(root==null) return ;
        if(root.left==null && root.right==null){
            res.add(root.val);
        }
        
        addLeaves(root.left);
        
        addLeaves(root.right);

    }
    
    
}
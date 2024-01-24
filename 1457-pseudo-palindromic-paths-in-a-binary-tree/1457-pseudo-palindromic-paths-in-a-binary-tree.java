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
    public int pseudoPalindromicPaths (TreeNode root) {
        return check(root, new int[10]);
    }
    public int check(TreeNode root, int[] arr){
        if(root==null) return 0;
        arr[root.val]++;
        boolean f= false;
        if(root.left==null && root.right==null){
            
            int c=0;
            for(int j=0;j<10;j++){
                if(arr[j]%2!=0){
                    if(c==0){
                        c=1;
                    }else if(c==1) {c++;break;}
                }
            }
            if(c<=1) f=true;
            
        }
        int left = check(root.left,arr);
        int right = check(root.right,arr);
        arr[root.val]--;
        
        return f==true? 1+ left + right: left +right;
    }
}
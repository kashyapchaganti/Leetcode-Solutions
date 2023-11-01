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
    int curNum=0;
    int curFreq=0;
    List<Integer> ans;
    int maxFreq=0;
    public int[] findMode(TreeNode root) {
        ans= new ArrayList<>();
        check(root);
        int[]  a= new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            a[i]=ans.get(i);
        }
        return a;
    }
    public void check(TreeNode root){
        if(root==null){
            return ;
        }
        check(root.left);
        
        if(curNum==root.val){
            curFreq++;
            
            if(curFreq==maxFreq){
                ans.add(curNum);
                maxFreq=curFreq;
                
            }else if(curFreq>maxFreq){
                ans=new ArrayList<>();
                ans.add(curNum);
                maxFreq=curFreq;
                
            }
            
            
        }else{
             curNum=root.val;
            curFreq=1;
            if(curFreq==maxFreq){
                ans.add(curNum);
                maxFreq=curFreq;
                
            }else if(curFreq>maxFreq){
                ans=new ArrayList<>();
                ans.add(curNum);
                maxFreq=curFreq;
                
            }
          
        }
        check(root.right);
        
    }
}
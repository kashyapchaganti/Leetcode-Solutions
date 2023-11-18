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
    int n, time=0 ;
     List<Integer> eulerTour; int[] depth, inTime, outTime;
    public int[] treeQueries(TreeNode root, int[] queries) {
        n =findNumberOfNodes(root);
        depth= new int[n+1];
        inTime= new int[n+1];
        outTime= new int[n+1];
        eulerTour = new ArrayList<>();
        buildEulerTour(root, 0);
        int[] prefixMax= new int[eulerTour.size()];
        int[] suffixMax= new int[eulerTour.size()];
        prefixMax[0]= depth[root.val];
        suffixMax[n-1]= depth[root.val];
        for(int i=1;i<eulerTour.size();i++){
            prefixMax[i]= Math.max(prefixMax[i-1], depth[eulerTour.get(i)]);
        }
        for(int i=eulerTour.size()-2;i>=0;i--){
            suffixMax[i]= Math.max(suffixMax[i+1], depth[eulerTour.get(i)]);
        }
        
        int[] ans = new int[queries.length];
        int idx=0;
        for(int q : queries){
            int left = inTime[q]-1;
            int right = outTime[q]+1;
            int leftMax = left>=0? prefixMax[left]: 0;
            int rightMax = right<=suffixMax.length? suffixMax[right]: 0;
            ans[idx++]= Math.max(leftMax,rightMax)-1;
        }
        return ans;
    }
    public void buildEulerTour(TreeNode root, int parent ){
        if(root==null){
            return; 
        }
        depth[root.val]=depth[parent]+1;
        eulerTour.add(root.val);
        inTime[root.val]=time++;
        buildEulerTour(root.left,root.val);
        buildEulerTour(root.right,root.val);
        eulerTour.add(root.val);
        outTime[root.val]=time++;
    }
    public int findNumberOfNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = findNumberOfNodes(root.left);
        int right = findNumberOfNodes(root.right);
        return left+right+1;
    }
}

/*

        1 3 2 2 3 4 6 6 5 7 7 5 4 1 
        
        5 8 2 4 4 6 6 1 1 8 9 3 3 7 7 9 5
        
        1 2 3 4 4 4 4 3 3 2 2 3 3 3 3 2 1 
        
        1   2  3  4  5  6  7  8  9
        [3, 3, 3, 4, 1, 4, 3, 2, 2]
*/




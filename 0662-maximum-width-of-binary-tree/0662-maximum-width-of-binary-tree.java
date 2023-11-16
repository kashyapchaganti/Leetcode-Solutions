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
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int ans =0;
        while(!q.isEmpty()){
            int n = q.size();
            int min =Integer.MAX_VALUE, max= Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                Pair cur = q.poll();
                if(cur.node.left!=null){
                    q.add(new Pair(cur.node.left, 2*cur.nodeNumber+1));
                }

                if(cur.node.right!=null){
                    q.add(new Pair(cur.node.right, 2*cur.nodeNumber+2));
                }
                min= Math.min(cur.nodeNumber,min);
                max= Math.max(cur.nodeNumber,max);
            }

            ans= Math.max(ans, max-min+1);
        }
        return ans;

    }
}

class Pair{
	TreeNode node;
	int nodeNumber;

	public Pair(TreeNode node, int nodeNumber){
		this.node = node;
		this.nodeNumber = nodeNumber;
	}

}

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
		if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int n =q.size();
			TreeNode x=null;
			for(int i=0;i<n;i++){
				TreeNode cur = q.poll();
				if(cur.left!=null){
					q.add(cur.left);
				}
				if(cur.right!=null){
					q.add(cur.right);
				}
				if(i==n-1)x=cur;

			}
			ans.add(x.val);
		}
		return ans;
            
        
    }
}
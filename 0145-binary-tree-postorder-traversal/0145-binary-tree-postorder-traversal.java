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
    public List<Integer> postorderTraversal(TreeNode root) {
List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<Pair> st = new Stack();
        st.add(new Pair(root,1));
        while(!st.isEmpty()){
            Pair cur = st.pop();
            if(cur.c==1){
                ans.add(cur.r.val);
                cur.c++;
                st.push(cur);
                if(cur.r.left!=null){
                    st.push(new Pair(cur.r.left,1));
                }
            }else if(cur.c==2){
                ans1.add(cur.r.val);
                cur.c++;
                st.push(cur);
                if(cur.r.right!=null){
                    st.push(new Pair(cur.r.right,1));
                }
                
                
            }else if(cur.c==3){
                ans2.add(cur.r.val);
            }
        }
        return ans2;
        
    }
    class Pair{
        TreeNode r;
        int c;
        public Pair(TreeNode r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    TreeNode r;
    int c;
    public Pair(TreeNode r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    HashMap<TreeNode,List<Pair>>m;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // convert to a graph 
        m= new HashMap<>();
        check(root,null);
        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[501];
        q.add(new Pair(target,0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            vis[cur.r.val]+=1;
            if(cur.c==k) ans.add(cur.r.val);
            for(Pair x: m.get(cur.r)){
                if(vis[x.r.val]==0)
                q.add(new Pair(x.r, cur.c+1));
            }
        }
        return ans;
        
    }
    
    public void check(TreeNode root,TreeNode p){
        if(root==null){
            return ;
        }
        if(p!=null){
            m.put(root,new ArrayList<>());
            m.get(root).add(new Pair(p,1));
        }else{
            m.put(root,new ArrayList<>());
        }
        if(root.left!=null){
            m.get(root).add(new Pair(root.left,1));
            check(root.left,root);
        }
        if(root.right!=null){
            m.get(root).add(new Pair(root.right,1));
            check(root.right,root);
        }
        return; 
        
    }
}
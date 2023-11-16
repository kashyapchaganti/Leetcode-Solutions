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
    TreeMap<Integer,List<Pair>>m;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        m=new TreeMap<>();
        check(root, 0,0);
        List<List<Integer>> ans= new ArrayList<>();
        for(int v: m.keySet()){
            List<Pair> a = m.get(v);
            Collections.sort(a, (x,y)->x.r==y.r? x.c-y.c: x.r-y.r);
            List<Integer> z= new ArrayList<>();
            for(Pair y: a){z.add(y.c);}
            ans.add(new ArrayList<>(z));
        }
        return ans;
    }
    public void check(TreeNode root, int r, int level){
        if(root==null){
            return ;
        }
        m.put(level, m.getOrDefault(level, new ArrayList<>()));
        m.get(level).add(new Pair(r, root.val));
        check(root.left, r+1,level-1);
        check(root.right, r+1, level+1);
        
    }
}
class Pair{
    int r,c;
    public Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
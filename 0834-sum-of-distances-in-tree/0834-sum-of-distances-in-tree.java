class Solution {
    //https://www.youtube.com/watch?v=nGhE4Ekmzbc
    int s1,k;
    List<List<Integer>> adj;int[]sizeOfSubtree;int[] ans,subTree,subTreeAns;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        sizeOfSubtree  = new int[n];
        Arrays.fill(sizeOfSubtree,1);
        adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x: edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        ans = new int[n];
        subTree=new int[n];
        subTreeAns=new int[n];
        
        check(0,-1);
        
        check2(n,0,-1,0);
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
    public void check(int i, int p){
        int noOfNodes=1;
        int ansForSubTree=0;
        for(int x: adj.get(i)){
            if(x!=p){
                check(x,i);
                noOfNodes+=subTree[x];
                ansForSubTree+=subTree[x]+subTreeAns[x];
            }
        }
        subTree[i]+=noOfNodes;
        subTreeAns[i]+=ansForSubTree;
        return ;
    }
    
    public void check2(int n,int i,int p,int par){
        ans[i]= subTreeAns[i]+par+n-subTree[i];
        for(int x: adj.get(i)){
            if(x==p) continue;
            int par_ans= ans[i]-(subTree[x]+subTreeAns[x]);
            check2(n,x,i,par_ans);
        }
        
    }
}
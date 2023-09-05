class TreeAncestor {
    List<List<Integer>> adj;
    int[][] dp;
    // int[] depth;
    public TreeAncestor(int n, int[] parent) {
        adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int x= parent[i];
            if(x!=-1){
                adj.get(x).add(i);
            }
        }
        dp= new int[n+1][21];
        binaryLifting(0,-1);
        // depth= new int[n+1];
        // check(0,-1);
        
        
    }
//     public void check(int i, int p){
//         if(p!=-1){
//             depth[i]=depth[p]+1;
//         }
//         for(int x: adj.get(i)){
//             check(x,i);
//         }
        
//     }
    
    public int getKthAncestor(int node, int k) {
        int ans = query(node , k);
        return ans;
    }
    public int query(int n, int k){
        if(n==-1 || k==0){
            return n;
        }
        for(int j=20;j>=0;j--){
            if(k >= (1 << j)){
                int next = dp[n][j];
                return query(next, k-(1 <<j));
            }
        }
        return -1;
    }
    public void binaryLifting(int i, int p){
        dp[i][0]=p;
        for(int j=1;j<=20;j++){
            if(dp[i][j-1]!=-1){
                dp[i][j]= dp[dp[i][j-1]][j-1];
            }else{
                dp[i][j]=-1;
            }
        }
        for(int x: adj.get(i)){
            
            binaryLifting(x,i);
        }
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
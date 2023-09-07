class TreeAncestor {
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        dp= new int[n+1][21];
        // for(int[] x:dp) Arrays.fill(x,-1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(parent[i]!=-1){
                adj.get(parent[i]).add(i);
            }
        }
        // System.out.println(adj);
        binaryLifting(0,-1,adj);
        // for(int[] x:dp) System.out.println(Arrays.toString(x));
    }
    
    public int getKthAncestor(int node, int k) {
        return query(node,k);
    }
    public int query(int i, int k){
        if(k==0  || i==-1) return i;
        for(int j=20;j>=0;j--){
            if(k >= (1 <<j)){
                int nxtNode = dp[i][j]; // jump 2 ^ j levels 
                // System.out.println()
                int r = k - (1<<j);
                return query(nxtNode, r);
            }
        }
        return -1;
    }
    public void binaryLifting(int i, int p, List<List<Integer>>adj ){
        dp[i][0]=p;
        
        for(int j=1;j<=20;j++){
            if(dp[i][j-1]!=-1){
                dp[i][j]= dp[dp[i][j-1]][j-1]; // 2^x levels from current is 2^x-1 from the 2^x-1 th parent
            }else{
                dp[i][j]=-1;
            }
        }
        for(int x: adj.get(i)){
            binaryLifting(x,i,adj);
        }
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
class Solution {
    int mod= (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int[][]dp=new int[n+1][target+1];
        for(int[] x: dp) Arrays.fill(x,-1);
        return findNoOfRolls(dp,0,k,target,n);
    }
    public int findNoOfRolls(int[][] dp, int i, int k,  int target, int n){
        if(i==n){
            if(target==0) return 1;
            return 0;
        }
        if(target<=0) return 0;
        
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int ways=0;
        for(int j=1;j<=k;j++){
            ways= (ways+findNoOfRolls(dp,i+1,k,target-j,n))%mod;
        }
        return dp[i][target]=ways;
            
    }
}

// o(n*k*target)

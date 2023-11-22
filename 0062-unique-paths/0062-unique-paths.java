class Solution {
    int m,n;
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        int[][] dp = new int[m+1][n+1];
        for(int[] x: dp)Arrays.fill(x,-1);
        return check(dp,0,0);
    }
    public int check(int[][] dp, int i, int j){
        if( i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int a = check(dp,i+1,j);
        int b = check(dp,i,j+1);
        
        return dp[i][j]= a+b;
    }
}
class Solution {
    int mod =(int)(1e9+7);
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int[][] x: dp){
            for(int[] x1:x){
                Arrays.fill(x1,-1);
            }
        }
        return check(dp,startRow,startColumn,maxMove,m,n);
    }
    public int check(int[][][] dp , int i, int j, int max, int m, int n){
        if(max>=0 && i==m || j==n || i<0 || j<0 ){
            return 1;
        }
        if(max==0 ){
            return 0;
        }
        if(dp[i][j][max]!=-1){
            return dp[i][j][max];
        }
        int[] dr= {-1,0,1,0},dc={0,1,0,-1};
        int ans=0;
        for(int k=0;k<4;k++){
            int x= i+dr[k];
            int y= j+dc[k];
            ans=(ans+check(dp,x,y,max-1,m,n))%mod;
            
        }
        return dp[i][j][max]=ans;
    }
}
class Solution {
    int n,m ;
    public int minPathSum(int[][] grid) {
        n= grid.length;
        m=grid[0].length;
        int[][] dp =new int[n][m];
        for(int[] x:dp) Arrays.fill(x,-1);
        return check(dp,0,0, grid);
        
    }
    public int check(int[][] dp, int i, int j, int[][] grid){
        if(i==n-1 && j==m-1){
            return grid[i][j]; 
        }
        if(i>=n || j>=m)return (int)(1e9);
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a = grid[i][j] + check(dp, i+1, j,grid) ;
        int b = grid[i][j] + check(dp, i, j+1,grid) ;
        return dp[i][j]= Math.min(a,b);
    }
}
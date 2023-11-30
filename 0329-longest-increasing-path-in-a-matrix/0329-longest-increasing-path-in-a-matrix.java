class Solution {
    int n,m;
    int[] dr= {-1,0,1,0}, dc= {0,1,0,-1};
    int[][] dp ;
    public int longestIncreasingPath(int[][] grid) {
        n = grid.length; m = grid[0].length;
        int max=0;
        dp= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j = 0; j< m ;j++){
                int a= check(i,j, grid);        
                max= Math.max(a,max);
            }
        }
        return max+1;
    }
    public int check(int i, int j, int[][] g){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int max=0;
        for(int k=0;k<4;k++){
            int x= i+dr[k];
            int y= j+dc[k];
            if(x>=0 && x<n && y>=0 && y<m && g[x][y]> g[i][j]){
                max= Math.max(max, 1+check(x,y,g));
            }
        }
        return dp[i][j]=max;
        
        
    }
}
class Pair{
    int r, c,d;
    public Pair(int r, int c, int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
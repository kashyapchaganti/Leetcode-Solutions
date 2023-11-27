class Solution {
    int[] dr = {-2,-1,1,2,2,1,-1,-2}, dc= {1,2,2,1,-1,-2,-2,-1};
    int mod= (int)(1e9+7);
    public int knightDialer(int n) {
        int[][][] dp = new int[4][3][n+1];
        for(int[][] x:dp){
            for(int[] x1:x){
                Arrays.fill(x1,-1);
            }
        }
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans=(ans+check(dp, i,j,n-1))%mod;
            }
        }
        return ans;
        
    }
    public int check(int[][][] dp, int i, int j, int n){
        if(i==3 && j==0 || i==3 && j==2){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[i][j][n]!=-1){
            return dp[i][j][n];
        }
        int a=0, min=0;
        for(int k=0;k<8;k++){
            int x = i+dr[k];
            int y = j+dc[k];
            if(x>=0 && y>=0 && x<4 && y<3){
                a= check(dp, x,y,n-1);    
                min=(a+min)%mod;
            }
        }
        return dp[i][j][n]=min;
    }
}
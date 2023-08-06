class Solution {
    long[][] dp;
    int n,goal,k;
    int mod = (int)(1e9+7);
    public int numMusicPlaylists(int n, int goal, int k) {
        this.n=n;
        this.goal=goal;
        this.k=k;
        
        dp= new long[goal+1][n+1];
        for(long[] x: dp) Arrays.fill(x,-1);
        return (int)check(0,0);
    }
    public long check(int count_unique, int count_songs ){
        if(count_songs==goal){
            
            if(count_unique==n){
                
                return 1;
            }
            return 0;
        }
        // if(count_songs>n) return 0;
        if(dp[count_songs][count_unique]!=-1){
            return dp[count_songs][count_unique];
        }
        long a=0;
        if(count_unique<n){
            a+= ((n-count_unique)*check(count_unique+1,count_songs+1))%mod;
            
        }
        if(count_unique>k){
            a+=(count_unique-k)*check(count_unique,count_songs+1)%mod;
            
        }
        return dp[count_songs][count_unique]=a;
        
    }
}
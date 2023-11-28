class Solution {
    int n, mod=(int)(1e9+7) ;
    public int numberOfWays(String s) {
        n= s.length();
       int[][] dp = new int[n][3];
        for(int[] x:dp) Arrays.fill(x,-1);
        return check(dp,0,0,s);
    }
    public int check(int[][] dp, int i, int seats, String s){
        if(seats>=3){
            return 0;
        }
        if(i==n && seats==2){
            return 1;
        }
        if(i>=n || seats>2)return 0;
        if(dp[i][seats]!=-1){
            return dp[i][seats];
        }
        int a =0;
        char ch=s.charAt(i);
        if(ch=='S'){
            if(seats+1==2){
                a = check(dp,i+1,0,s)%mod;
                a=(a+check(dp,i+1,2,s))%mod;
            }else{
                a=(a+check(dp,i+1,seats+1,s))%mod;
            }
        }else{
            if(seats==2){
                a=(a+check(dp,i+1,0,s))%mod;
                a=(a+check(dp,i+1,seats,s))%mod;
            }else{
                a=(a+check(dp,i+1,seats,s))%mod;
            }
        }
        return dp[i][seats]=a;
    }
}
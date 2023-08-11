class Solution {
    int n;
    public int change(int amount, int[] coins) {
        n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] x:dp) {
            Arrays.fill(x,-1);
        }
        return check(dp, 0,amount, coins);
    }
    public int check(int[][] dp, int i, int s, int[] nums){
        if(s==0){
            return 1;
        }
        if(s<=0 || i>= n){
            return 0;
        }
        if(dp[i][s]!=-1){
            return dp[i][s];
        }
        int a=0;
        a= check(dp, i, s-nums[i],nums);
        // a+=check(dp, i+1, s-nums[i],nums);
        a+=check(dp, i+1,s,nums);
        return dp[i][s]=a;
    }
}
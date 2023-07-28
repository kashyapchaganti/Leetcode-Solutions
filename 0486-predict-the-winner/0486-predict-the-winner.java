class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][n];
        for(long[] x:dp) Arrays.fill(x,-1);
        // long s= 0;
        // for(int x: nums)s+=x;
        long a= check(dp, 0,n-1,n, nums);
        return a>=0?true:false;
    }
    public long check(long[][] dp, int i, int j, int n , int[] nums){
        if(i==j){
            return nums[i];
        }
       if(dp[i][j]!=-1) return dp[i][j];
        long a = (nums[i]-(check(dp, i+1,j,n,nums)));
        long b = (nums[j]-(check(dp, i,j-1,n,nums)));
        return dp[i][j]= Math.max(a,b);
    }
}
class Solution {
    int n ;
    public long minIncrementOperations(int[] nums, int k) {
        n= nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp,-1);
        return check(dp,0,nums,k);
        
    }
    public long check(long[] dp, int i, int[] nums, int k){
        if(i>nums.length-3)
            return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        long a = Math.max(0,k-nums[i]) + check(dp,i+1,nums,k);
        long b = Math.max(0,k-nums[i+1]) + check(dp,i+2,nums,k);
        long c= Math.max(0,k-nums[i+2]) + check(dp,i+3,nums,k);
        return dp[i]= Math.min(a, Math.min(b,c));
        
        
    }
}
class Solution {
    int n;
    public boolean validPartition(int[] nums) {
        n= nums.length;
        Boolean[] dp =new Boolean[n];
        return check(dp, 0,nums);
    }
    public Boolean check(Boolean[] dp, int i, int[] nums){
        if(i>=n){
            return true;
        }
        
        if(dp[i]!=null){
            return dp[i];
        }
        boolean f= false;
        if(i+1<n && nums[i]==nums[i+1]){
                f= check(dp, i+2, nums);
        }
        if(i+1<n &&  i+2 <n && nums[i]==nums[i+1] && nums[i+1] ==nums[i+2]){
            f=f||check(dp, i+3, nums);
        }
        if(i+1<n &&  i+2 <n && nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2]){
            f=f||check(dp, i+3, nums);
        }
        return dp[i]=f;
    }
}
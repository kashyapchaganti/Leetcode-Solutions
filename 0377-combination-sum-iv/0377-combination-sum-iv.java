class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        
        Arrays.fill(dp,-1);
        
        return check(dp,nums,target);
    }
    public int check(int[] dp, int[] nums,int target){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int a=0;
        for(int i=0;i<nums.length;i++){ // any combination is allowed (3,1) and (1,3) different ones.
            a+=check(dp,nums,target-nums[i]);
        }
        return dp[target]= a;
    }
}
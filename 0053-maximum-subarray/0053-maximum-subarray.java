class Solution {
    public int maxSubArray(int[] nums) {
        // max sum subarray -> Kadane's Algo 
        
        int n = nums.length;
        int max= (int)(-1e9);
        int s=0;
        for(int i=0;i<n;i++){
            if(nums[i]>s+nums[i]){
                max= Math.max(max, nums[i]);
                s=nums[i];
            }else{
                s=s+nums[i];
                max= Math.max(max, s);
            }
        }
        return max;
        
    }
}
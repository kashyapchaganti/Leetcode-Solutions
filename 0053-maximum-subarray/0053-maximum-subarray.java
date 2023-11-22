class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum=0,max=(int)(-1e9);
        for(int i=0;i<n;i++){
            if(nums[i]+sum<nums[i]){
                sum=nums[i];
                max = Math.max(sum,max);
            }else{
                sum+=nums[i];
                max = Math.max(sum,max);
            }
        }
        return max==(int)(-1e9)?-1: max;
    }
}
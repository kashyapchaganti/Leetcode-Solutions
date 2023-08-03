class Solution {
    public int maxProfit(int[] nums) {
       int n = nums.length;
        int max= 0;
        int min= (int)(1e9);
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min= nums[i];
            }else{
                max= Math.max(max, nums[i]-min);
            }
        }
        return max;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int cur_max= nums[0];
        int cur_min=  nums[0];
        int ans=  nums[0];
        for(int i=1;i<n;i++){
            int t= Math.max(nums[i], Math.max(nums[i]*cur_max, nums[i]*cur_min));
            cur_min= Math.min(nums[i], Math.min(nums[i]*cur_max, nums[i]*cur_min));
            cur_max=t;
            ans= Math.max(ans, cur_max);
            
        }
        return ans;
        
    }
}
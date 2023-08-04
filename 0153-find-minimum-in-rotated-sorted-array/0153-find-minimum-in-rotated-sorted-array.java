class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int s=0, e= n-1;
        // s...m...e
        // 3 4 5 1 2
        // 5 1 2 3 4 
        int ans=(int)(1e9);
        while(s<=e){
            int m = s+(e-s)/2;
            if(m+1<n && nums[m]>nums[m+1]){
                return nums[m+1];
            }
            if(m-1>=0 && nums[m-1]>nums[m]){
                return nums[m];
            }
            if(nums[s]>=nums[m]){
                ans= Math.min(nums[m],ans);
                e=m-1;
            }else{
                ans= Math.min(nums[s],ans);
                s=m+1;
            }
        }
        return ans;
    }
}
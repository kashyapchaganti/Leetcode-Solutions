class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e =n-1;
        // 2 5 6 0 0 1 2 
        while(s<=e){
            int m= s+(e-s)/2;
            if(nums[m]==target) return true;
            if(nums[m]==nums[s] && nums[m]==nums[e]){
                    s++;
                    e--;
            }else{
                 if(nums[m]>= nums[s]){
                if(nums[m]>target && target>=nums[s]){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }else if(nums[m]<=nums[e]){
                if(nums[m]<target && target<=nums[e]){
                    s=m+1;
                }else{
                    e=m-1;
                }
                
            }
            }
           
        }
        return false;
    }
}



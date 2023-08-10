class Solution {
    public int search(int[] nums, int target) {
        int n =nums.length;
        
        // s ....nums[t]? ...m... nums[t]? ...e
        int s= 0, e= n-1;
        while(s<=e){
            int m= s+(e-s)/2;
            if(nums[m]==target) return m;
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
        return -1;
    
        }
        
    }

class Solution {
    public int maxSubArray(int[] nums) {
        
        int n =nums.length;
        int max=(int)(-1e9), sum=0;
        for(int i=0;i<n;i++){
            if(sum+nums[i]<nums[i]){
                sum= nums[i];
            }else{
                sum+=nums[i];
            }    
            max= Math.max(max,sum);
        }
        return max;
        
    }
}
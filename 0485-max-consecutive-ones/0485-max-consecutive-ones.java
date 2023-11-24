class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, max=0,c=0;
        
        for(int i =0;i<n;i++){
            if(nums[i]==1){
                c++;
                max= Math.max(max,c);
            }else{
                c=0;
            }
            
        }
        return max;
    }
}
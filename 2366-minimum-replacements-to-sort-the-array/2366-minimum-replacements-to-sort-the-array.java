class Solution {
    public long minimumReplacement(int[] nums) {
        int n =nums.length;
        
        long c=0;
        long min = nums[n-1];
        for(int i=n-2;i>=0;i--){
           if(nums[i]<=min){
               min=nums[i];
               continue;
           }else{
               long parts = (nums[i] % min==0? nums[i]/min: (nums[i]/min )+1);
               // now we need to divide each in such a way that we have max in each one of them
               c+=parts-1;
               min= nums[i]/parts;
           }
        }
        return c;
        
    }
}
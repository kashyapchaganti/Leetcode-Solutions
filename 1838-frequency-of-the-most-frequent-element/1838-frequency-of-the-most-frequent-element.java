class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = 0, totalPrefix=0,countOfHighestFrequency=0; 
        
        for(int i=0;i<n;i++){
            totalPrefix+=nums[i];
            int allNumbersEqualToCurrentIdx= (i-start+1)*nums[i];
            while(allNumbersEqualToCurrentIdx-totalPrefix>k){
                totalPrefix-=nums[start];
                allNumbersEqualToCurrentIdx-=nums[i];
                start++;
            }
            countOfHighestFrequency= Math.max(countOfHighestFrequency, i-start+1);
        }
        
      
        
        return countOfHighestFrequency;
    }
}
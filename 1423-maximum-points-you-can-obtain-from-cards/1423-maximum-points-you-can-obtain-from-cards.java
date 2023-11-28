class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int maxSubArrayLength = n-k;
        int windowSum =0;
        int totalSum=0;
        for(int x: nums){
            totalSum+=x;
        }
        if(maxSubArrayLength==0)return totalSum;
        int ans=0;
        int leftPointer =0;
        for(int i=0;i<n;i++){
            windowSum+=nums[i];
            if(i-leftPointer+1==maxSubArrayLength){
                int requiredSum= totalSum-windowSum;
                ans=Math.max(requiredSum, ans);
                windowSum-=nums[leftPointer++];
            }
        }
        return ans;
        
    }
    
}
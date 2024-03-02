class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0, j = nums.length-1, index=nums.length-1;
        while(i<=j){
            int leftValue = nums[i]*nums[i];
            int rightValue = nums[j]*nums[j];
            if(leftValue>rightValue){
                ans[index]=leftValue;
                index--;
                i++;
            }else{
                ans[index]=rightValue;
                index--;
                j--;
            }
        }
        return ans;
    }
}
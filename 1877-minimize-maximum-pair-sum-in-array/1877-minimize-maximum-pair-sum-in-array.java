class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max =0;
        int i = 0, j= nums.length-1;
        while(i<j){
            max = Math.max(nums[i]+nums[j],max);
            i++;
            j--;
        }
        return max;
    }
}
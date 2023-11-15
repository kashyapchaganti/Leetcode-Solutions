class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 4 cases remove from the beg all three or beg 2 + 1 end , beg 1 + 2 end, 3 end
        if(n<=3) return 0;
        int a=Math.abs(nums[3]- nums[n-1]);
        a= Math.min(a, Math.abs(nums[2]- nums[n-2]));
        a= Math.min(a, Math.abs(nums[1]- nums[n-3]));
        a= Math.min(a, Math.abs(nums[0]- nums[n-4]));
        return a;
    }
}
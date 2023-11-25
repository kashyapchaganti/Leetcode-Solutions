class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] psum = new int[n];
        psum[0]=nums[0];
        for(int i=1;i<n;i++){
            psum[i]= psum[i-1]+nums[i];
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int l = i-1>=0?psum[i-1]: 0;
            int r = psum[n-1]-psum[i];
            int lsum= (i)*(nums[i])- l;
            int rsum = r-(n-(i+1))*nums[i];
            ans[i]= lsum+rsum;
            // System.out.println(lsum+" "+rsum);
        }
        return ans;
    }
}
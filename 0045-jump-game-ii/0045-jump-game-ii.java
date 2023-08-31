class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int curEnd=0,curFar=0;
        int s=0;
        for(int i=0;i<n-1;i++){
            curFar = Math.max(curFar,i+nums[i]); // 2 1 3 0 1 for 2 3 is the max jump possible
            if(i==curEnd){
                s++;
                curEnd= curFar;
            }
        }
        return s;
    }
}
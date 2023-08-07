class Solution {
    public int findMinArrowShots(int[][] nums) {
        int n =nums.length;
        Arrays.sort(nums, (a,b)-> a[0]==b[0]? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        int s= nums[0][0], e= nums[0][1];
        int ans=1;
        
        for(int i=1;i<n;i++){
            if(e>=nums[i][0]){
                e= Math.min(e, nums[i][1]);
            }else{
                ans++;
                s= nums[i][0];
                e= nums[i][1];
            }
        }
        return ans;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        int n =nums.length;
        int c=0;
        Arrays.sort(nums, (a,b)-> a[0] !=b[0] ?a [0]-b[0]:a[1]-b[1]);
        int s = nums[0][0] ,e= nums[0][1];
        for(int i=1;i<n;i++){
            if(nums[i][0]>= e){
                   s= nums[i][0];
                    e= nums[i][1];
                continue;
            }else{
                c++;
                if(nums[i][1]< e){
                    
                    s= nums[i][0];
                    e= nums[i][1];
                }
            }
        }
        return c;
    }
}
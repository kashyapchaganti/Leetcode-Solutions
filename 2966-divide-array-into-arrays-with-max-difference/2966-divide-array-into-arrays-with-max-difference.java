class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n%3!=0)return new int[0][0];
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int i=0, c=0;
        while(i<n){
            int j=0;
            while(j<3 && i<n){
                if(j>=1 && nums[i]-ans[c][0]<=k || j==0){
                    ans[c][j]=nums[i];    
                }else{
                    return new int[0][0];
                }
                i++;
                j++;
            }
            c++;            
        }
        return ans;
    }
}
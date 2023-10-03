class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int prev=-1;
        int n= nums.length;
        int i=0,c=0;
        while(i<n){
            int j=i;
            while(j+1<n && nums[j]==nums[j+1]){
                j++;
            }
            c+=(j-i+1)*(j-i)/2;
            if(j==i){
                i++;
            }else{
                i=j;
            }
        }
        return c;
    }
}
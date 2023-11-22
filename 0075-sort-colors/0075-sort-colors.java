class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0;;
        int zeroPlace =0, twoPlace=n-1;
        while(i<n && i<=twoPlace){
            if(nums[i]==0){
                swap(i,zeroPlace,nums);
                zeroPlace++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(i,twoPlace,nums);
                twoPlace--;
            }
        }
        return ;
    }
    public void swap(int i, int j, int[] nums){
            int t= nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        // find the first decreasing number from the back
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        // find the first number greater than the found no
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        // reverse the seq from i+1
        reverse(nums,i+1);
    }
    public void reverse(int[] nums,int i){
        int j= nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
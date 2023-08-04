class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        
        l[0]=nums[0];
        r[n-1]=nums[n-1];
        
        r[n-1]= nums[n-1];
        for(int i=1;i<n;i++){
            l[i]=l[i-1]*nums[i];
            
        }
        for(int i=n-2;i>=0;i--){
            r[i]=r[i+1]*nums[i];
            
        }
        int[] ans = new int[n];
        for(int i=1;i<n-1;i++){
            ans[i]= l[i-1]*r[i+1];
        }
        ans[0]=r[1];
        ans[n-1]=l[n-2];
        return ans;
        
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ans[0]=1;
        ans[n-1]=1;
        
        int prev=nums[0];
        for(int i=1;i<n;i++){
            ans[i]=prev;
            prev*= nums[i];
            
        }
        // System.out.println(Arrays.toString(ans));
        // System.out.println(prev);
        
        prev= nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            ans[i]=ans[i]*prev;
            prev*=nums[i];
            
        }
        
        // ans[0]=r[1];
        // ans[n-1]=l[n-2];
        return ans;
        
    }
}
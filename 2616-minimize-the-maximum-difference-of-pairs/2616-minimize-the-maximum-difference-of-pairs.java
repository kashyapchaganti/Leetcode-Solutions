class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        int ans =(int)(1e9);
        int s= 0, e= ans;
        Arrays.sort(nums);
        while(s<=e){
            int m = s+(e-s)/2;
            if(check(nums, p, m , n)){
                ans = m;
                e=m-1;
            }else{
                s= m+1;
            }
        }
        return ans; 
    }
    public boolean check(int[] nums ,int p, int m , int n){
        int c= 0;
        int i=0;
        while(i<n-1){
            if(Math.abs(nums[i]-nums[i+1])<=m){
                i=i+2;
                c++;
            }else{
                i++;
            }
        }
        return c>=p;
        
    }
}
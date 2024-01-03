class Solution {
    public int numberOfBeams(String[] nums) {
        int n = nums.length;
        int[]psum = new int[n];
        
            for(int i=0;i<nums[0].length();i++){
                if(nums[0].charAt(i)=='1'){
                    psum[0]++;
                }
            }
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1];
            for(int j=0;j<nums[i].length();j++){
                if(nums[i].charAt(j)=='1'){
                    psum[i]++;
                }
            }
        }
        int ans=0;
        // System.out.println(Arrays.toString(psum));
        for(int i=0;i<n;i++){
            int v= i-1>=0?psum[i]-psum[i-1]: psum[i];
            for(int j=i+1;j<n;j++){
                if(psum[j]-psum[j-1]>0){
                    ans+=v*(psum[j]-psum[j-1]);
                    break;
                }
            }
        }
        return ans;
        
        
    }
}
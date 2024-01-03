class Solution {
    public int numberOfBeams(String[] nums) {
        int n = nums.length, prev=0,ans=0;
        
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<nums[i].length();j++){
                if(nums[i].charAt(j)=='1'){
                    count++;
                }
            }
            if(count>0){
                ans+=prev*count;
                prev=count;
            }
        }
        return ans;
        
        
    }
}
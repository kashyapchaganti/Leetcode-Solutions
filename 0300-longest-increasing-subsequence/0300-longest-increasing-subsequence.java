class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }else{
                int x= bs(nums[i],arr);
                if(x!=-1)
                arr.set(x,nums[i]);
            }
        }
        return arr.size();
    }
    public int bs(int x, List<Integer> arr){
        int s= 0, e=arr.size()-1;
        int ans=-1;
        while(s<=e){
            int m =s+(e-s)/2;
            if(x<=arr.get(m)){
                ans=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int s= i+1, e= n-1;
            while(s<e){
                int y= nums[i] + nums[s]+nums[e];
                if(y==0){
                    
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[s],nums[e])));
                    s++;
                    e--;
                    while(nums[s]==nums[s-1] && s<e){
                        s++;
                    }
                    while(nums[e]==nums[e+1] && s<e){
                        e--;
                    }
                }else{
                    if(y>0){
                        e--;
                    }else{
                        s++;
                    }
                }
            }
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j-1>=i+1 && nums[j]==nums[j-1] ){
                    continue;
                }
                int c= nums[i]+nums[j];
                int s =j+1, e= n-1;
                // System.out.println(-c);
                while(s<=e){
                    int m = s+(e-s)/2;
                    if(nums[m]==-c){
                        
                        ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],-c)));
                        break;
                    }else{
                        if(nums[m]>-c){
                            e=m-1;
                        }else{
                            s=m+1;
                        }
                    }
                    
                }
            }
        }
        return ans;
    }
}
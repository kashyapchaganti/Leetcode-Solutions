class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // res.add(new ArrayList<>());
        for(int i=0;i<(1<<n);i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0;j<n;j++){
                int x=1<<j;
                if((i & x)!=0){
                    a.add(nums[j]);
                }
               
                
            }
            
            // System.out.println(a);
            // if(a.size()!=0)
            res.add(new ArrayList<>(a));
        }
        return res;
    }
}
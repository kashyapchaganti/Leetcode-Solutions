class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);
        int s=0;
        int max=0;
        for(int i=0;i<n;i++){
            s+=nums[i];
            if(m.containsKey(s-k)){
                max= Math.max(max, i-m.get(s-k));
                // System.out.println(m);
            }
            if(!m.containsKey(s)) m.put(s,i);
            
        }
        return max;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            int x= target-nums[i];
            if(m.containsKey(x)){
                return new int[]{m.get(x),i};
            }
            m.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
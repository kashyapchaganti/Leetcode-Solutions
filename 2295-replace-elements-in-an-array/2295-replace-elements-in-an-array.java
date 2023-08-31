class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],i);
        }
        for(int[] x: operations){
            int v= m.get(x[0]);
            m.put(x[1],v);
            m.remove(x[0]);
            nums[v]=x[1];
        }
        return nums;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();
        for(int x: nums)s.add(x);
        for(int i=1;i<=n;i++){
            if(!s.contains(i)) return i;
        }
        return n+1; 
    }
}
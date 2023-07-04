class Solution {
    public int singleNumber(int[] nums) {
        int s1= 0;
        int s2=0;
        for(int num: nums){
            s1 = ~s2 & (s1 ^ num);
            s2 = ~s1 & (s2 ^ num);
        }
        return s1;
    }
}
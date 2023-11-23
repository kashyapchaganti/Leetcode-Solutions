class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
        int count=0;
        HashSet<Integer> s = new HashSet<>();
        for(int x: nums){
            s.add(x);
        }
        for(int x: s){
            if(s.contains(x-1)){
                continue;
            }else{
                int v= x;
                int c=0;
                while(s.contains(v)){
                    v++;
                    c++;
                }
                count= Math.max(c,count);
            }
        }
        return count;
    }
}
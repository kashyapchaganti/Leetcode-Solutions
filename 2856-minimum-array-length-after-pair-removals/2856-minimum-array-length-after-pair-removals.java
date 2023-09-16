class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        //https://www.youtube.com/watch?v=0jnBbMwK6kM&ab_channel=codingMohan
        int i=0, r= n/2;
        int rem=0;
        while(i< n/2 && r<n){
            
            if((long)(nums.get(i))==(long)(nums.get(r))){
                r++;
                continue;
            }
            rem+=2;
            // System.out.println("EQUAL");
            i++;
            r++;
        }
        return n-rem;
        
        
    }
}
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int start = 0, max =1; 
        TreeSet<Pair> s = new TreeSet<>((a,b)->a.val==b.val? a.idx-b.idx:a.val-b.val);
        for(int i=0;i<n;i++){
            int diff =(int)(1e9);
            if(s.size()!=0){
                while(s.size()>0 &&
                      Math.max(Math.abs(s.first().val-nums[i]),
                      Math.abs(s.last().val-nums[i]))>limit){
                    Pair cur = new Pair(nums[start],start);
                    s.remove(cur);
                    start++;
                }
                max= Math.max(max, i-start+1);
            }else{
                diff=0;
            }
            s.add(new Pair(nums[i],i));
        }
        return max;
    }
}
class Pair{
    int val, idx;
    public Pair(int val, int idx){
        this.val=val;
        this.idx=idx;
    }
}

/*

1, 2, 4, 7


*/
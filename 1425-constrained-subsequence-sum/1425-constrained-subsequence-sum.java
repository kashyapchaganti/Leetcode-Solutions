class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n =nums.length;
        int max= nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        for(int i=1;i<n;i++){
            while(i-pq.peek()[1]>k){
                pq.poll();
            }
            int cur= Math.max(0,pq.peek()[0])+nums[i];
            max=Math.max(cur,max);
            pq.add(new int[]{cur,i});
        }
        return max;
    }
}
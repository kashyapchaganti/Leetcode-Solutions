class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int s=0;
        
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        ans[s++]= nums[dq.peekFirst()];
        for(int i=k;i<n;i++){
            
            if(dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            
            ans[s++]= nums[dq.peekFirst()];
        }
        
               
        return ans;
    }
}
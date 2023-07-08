class Solution {
    public long putMarbles(int[] weights, int k) {
        //https://www.youtube.com/watch?v=hjyFkhXKowc
        PriorityQueue<Long> max = new PriorityQueue<>((a,b)->Long.compare(b,a));
        PriorityQueue<Long> min = new PriorityQueue<>((a,b)->Long.compare(a,b));
        int n = weights.length;
        
        if(n==k || k==1){
            return 0;
        }
        for(int i=1;i<n;i++){
            long a=weights[i-1]+weights[i];
            max.add(a);
            min.add(a);
        }
        long ans=0;
        for(int i=0;i<k-1;i++){
            ans+=max.poll()-min.poll();
        }
        return ans;
    }
}
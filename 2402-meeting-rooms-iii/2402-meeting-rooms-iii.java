class Solution {
    public int mostBooked(int n, int[][] nums) {
        int m = nums.length,max=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.r==b.r? a.idx-b.idx:Long.compare(a.r,b.r));
        for(int i=0;i<n;i++){
            q.add(new Pair(0,0,i));
        }
        Arrays.sort(nums,(a,b)-> a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        int t=0;
        
        for(int[] x: nums){
            if(q.peek().r<=x[0]){
                PriorityQueue<Pair> q1 = new PriorityQueue<>((a,b)-> a.idx-b.idx);    
                while(!q.isEmpty() && q.peek().r<=x[0]){
                    Pair y= q.poll();
                    q1.add(y);
                }
                Pair y= q1.poll();
                q.add(new Pair(x[1],y.c+1,y.idx));
                while(!q1.isEmpty()){
                    q.add(q1.poll());
                }
                
            }else{
                Pair y= q.poll();
                int d= x[1]-x[0];
                q.add(new Pair(d+y.r, y.c+1,y.idx));
            }
            
            
        }
        int ans=(int)(1e9);
        while(!q.isEmpty()){
            Pair y= q.poll();
            // System.out.println(y);
            if(max<y.c ){
                ans= y.idx;
                max=y.c;
            }else if(max==y.c){
                ans= Math.min(ans, y.idx);
            }
        }
        return ans;
    }
    public class Pair{
        int c,idx;
        long r;
        public Pair(long r, int c,int idx){
            this.r=r;
            this.c=c;
            this.idx=idx;
        }
        public String toString(){ return r+" "+c +" "+idx;}
    }
    
}
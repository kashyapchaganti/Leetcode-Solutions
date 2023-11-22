class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Pair> busy = new PriorityQueue<>((a,b)-> a.totalTime==b.totalTime? a.idx-b.idx: Long.compare(a.totalTime, b.totalTime));
        PriorityQueue<Pair> available = new PriorityQueue<>((a,b)-> a.idx-b.idx);
        for(int i=0;i<n;i++){
            available.add(new Pair(i,0));
        }
        Arrays.sort(meetings,(a,b)-> a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        int[] count = new int[n];
        
        for(int[] meeting: meetings){
            while(!busy.isEmpty() && busy.peek().totalTime<=meeting[0]){
                available.add(busy.poll());
            }
            if(available.isEmpty()){
                Pair room = busy.poll();
                busy.add(new Pair(room.idx,room.totalTime+meeting[1]-meeting[0]));
                count[room.idx]++;
            }else{
                Pair room = available.poll();
                busy.add(new Pair(room.idx, meeting[1]));
                count[room.idx]++;
            }
        }
        int ans=0, max=0;
        for(int i=n-1;i>=0;i--){
            if(count[i]>=max){
                ans=i;
                max= count[i];
            }
        }
        return ans;
        
       
    }
    
}
class Pair{
    long totalTime; 
    int idx;
    public Pair(int idx, long totalTime){
        this.idx= idx;
        
        this.totalTime= totalTime;
    }
}
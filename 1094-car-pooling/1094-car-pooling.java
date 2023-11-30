class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Arrays.sort(trips, (a,b)-> a[1]==b[1]? a[2]-b[2]: a[1]-b[1]);
        int start = trips[0][1] , end = trips[0][2], c= trips[0][0];
        if(c>capacity)return false;
        // for(int[] x: trips){
        //     System.out.println(Arrays.toString(x));
        // }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        pq.add(new int[]{c,start,end});
        for(int i=1;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[2]<=trips[i][1]){
                int[] arr=pq.poll();
                c-=arr[0];
            }
            if(c+trips[i][0]>capacity)return false;
            
            c+=trips[i][0];
            pq.add(trips[i]);
        }
        return true;
        
    }
}
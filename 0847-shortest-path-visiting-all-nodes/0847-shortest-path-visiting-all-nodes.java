class Solution {
    int n;
    public int shortestPathLength(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        n= graph.length;
        int[][] dp = new int[n][1<<n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],(int)(1e9));
            dp[i][1<<i]=0;
            q.add(new int[]{i,1<<i}); //so dp[1][2], dp[2][4]= 0
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int x: graph[cur[0]]){
                int newMask= (cur[1] | (1<<x));
                if(dp[x][newMask]>dp[cur[0]][cur[1]]+1){
                    dp[x][newMask]=dp[cur[0]][cur[1]]+1;
                    q.add(new int[]{x,newMask});
                }
            }
        }
        int min= (int)(1e9);
        for(int i=0;i<n;i++){
            min=Math.min(dp[i][(1<<n)-1],min);
        }
        return min;
        
    }
}
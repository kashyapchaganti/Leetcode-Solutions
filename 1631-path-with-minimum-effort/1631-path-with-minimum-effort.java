class Solution {
    int n,m;
    int[]dr= {-1,0,1,0}, dc={0,1,0,-1};
    public int minimumEffortPath(int[][] heights) {
        n= heights.length;
        m= heights[0].length;
        Queue<Pair> q= new LinkedList<>();
        int[][] dis = new int[n][m];
        for(int[] x:dis) Arrays.fill(x,(int)(1e9));
        dis[0][0]=0;
        q.add(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int k=0;k<4;k++){
                int x= cur.r+dr[k];
                int y= cur.c+dc[k];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(dis[x][y]>Math.max(Math.abs(heights[x][y]-heights[cur.r][cur.c]),cur.d)){
                        dis[x][y]=Math.max(Math.abs(heights[x][y]-heights[cur.r][cur.c]),cur.d);
                        q.add(new Pair(x,y,dis[x][y]));
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
    class Pair{
        int r,c,d;
        public Pair(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
}




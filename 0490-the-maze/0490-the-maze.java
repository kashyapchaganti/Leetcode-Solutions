class Solution {
    int n , m;
    int[] dr={-1,0,1,0}, dc={0,1,0,-1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        n =maze.length; m = maze[0].length;
        int[][] vis = new int[n][m];
        return check(maze, start[0],start[1], destination, vis);
    }
    public boolean check(int[][] maze , int i, int j, int[] destination, int[][] vis){
        if(vis[i][j]!=0){
            return false;
        }
        vis[i][j]=1;
        if(destination[0]==i && destination[1]==j) return true;
        
        for(int k=0;k<4;k++){
            int x= i+dr[k];
            int y= j+dc[k];
            while(x>=0 && y>=0 && x<n && y<m && maze[x][y]==0){
                x+=dr[k];
                y+=dc[k];
            }
            x-=dr[k];
            y-=dc[k];
            if(check(maze, x,y,destination,vis)){
                return true;
            }
        }
        return false;
    }
}
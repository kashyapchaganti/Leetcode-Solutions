class Solution {
    int n , m; 
    int[][] vis;
    int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        vis= new int[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid1[i][j]==grid2[i][j] && vis[i][j]==0 && grid2[i][j]==1){
                  if(check(grid1,grid2,i,j)){
                      System.out.println("Hi"+i+" "+j);
                      c++;
                  }       
                    
                }
            }
            
        }
        return c;         
    }
    public boolean  check(int[][] g1, int[][]g2, int i, int j){
        vis[i][j]=1;
        // if(g1[i][j]==0 && g2[i][j]==1) return false;
        boolean f= true;
        for(int k=0;k<4;k++){
            int x= i +dr[k];
            int y= j +dc[k];
            if(x>=0 && x<n && y>=0 && y<m && vis[x][y]==0){
               
                if(g2[x][y]==1 && g1[x][y]==0){
                    f=false;
                    boolean x1= check(g1,g2,x,y);
                }else if(g1[x][y]==1 && g2[x][y]==1){
                    boolean x1= check(g1,g2,x,y);
                    f=f&&x1;
                }

            }       
        }
        if(f==false) return false; 
        return true;
        
    }
    
}

// 1 0
// Hi1 0
// 3 1
// 3 3
// 4 0
// Hi4 0
// 4 4
// Hi4 4
// [0, 0, 0, 0, 0]
// [1, 1, 1, 1, 1]
// [0, 0, 0, 0, 0]
// [0, 1, 0, 1, 0]
// [1, 0, 0, 0, 1]


       
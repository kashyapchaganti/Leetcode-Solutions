class Solution {
    int n , m; 
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        
        int c=0;
        for (int i = 0; i < grid1.length; i++){
            for (int j = 0; j < grid1[0].length; j++){
                if(grid2[i][j]==1 ){
                  if(check(grid1,grid2,i,j)){
                      c++;
                  }       
                    
                }
            }
            
        }
       
        return c;         
    }
    public boolean  check(int[][] g1, int[][]g2, int i, int j){
        if(i>=n || i<0 || j>=m  || j<0 || g2[i][j]==2 || g2[i][j]==0) return true;

        if(g2[i][j]==1 && g1[i][j]==0){
            return false;
        }
        g2[i][j]=2;
        
        boolean a= check(g1,g2,i-1,j);
        boolean b = check(g1,g2,i,j-1);
        boolean c= check(g1,g2,i+1,j);
        boolean d = check(g1,g2,i,j+1);
        return a && b && c && d;
        
    }
    
}

// class Solution {
//     public int countSubIslands(int[][] grid1, int[][] grid2) {
//         if (grid1 == null || grid2 == null) return 0;

//         int res = 0;

//         for (int i = 0; i < grid1.length; i++){
//             for (int j = 0; j < grid1[0].length; j++){
//                 if (grid2[i][j] == 1){
//                     if (dfs(grid1, grid2, i, j))
//                         res++;
//                 }
//             }
//         }

//         return res;
//     }

//     private boolean dfs (int[][] grid1, int[][] grid2, int x, int y){
//         if (x < 0 || y < 0 || x >= grid1.length || y >= grid1[0].length || grid2[x][y] == 2 || grid2[x][y] == 0)
//             return true;
        
//         if (grid1[x][y] == 0 && grid2[x][y] == 1)
//             return false;

//         grid2[x][y] = 2;

//         boolean up = dfs(grid1, grid2, x-1, y);
//         boolean left = dfs(grid1, grid2, x, y-1);
//         boolean right = dfs(grid1, grid2, x, y+1);
//         boolean down = dfs(grid1, grid2, x+1, y);

//         return up && left && right && down;
//     }
// }       
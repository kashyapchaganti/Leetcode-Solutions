class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] onesRow= new int[n];
        int[] onesCol= new int[m];
        int[] zRow= new int[n];
        int[] zCol= new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    onesRow[i]++;
                    onesCol[j]++;
                }else{
                    zRow[i]++;
                    zCol[j]++;
                }
            }
        }
        int[][] diff= new int[n][m];
        for(int  i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]= onesRow[i]+onesCol[j]-zRow[i]-zCol[j];
            }
        }
        return diff;
    }
}
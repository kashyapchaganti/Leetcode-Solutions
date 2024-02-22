class Solution {
    public boolean isValidSudoku(char[][] board) {
        // three things to check row unique, col unique and box unique 
        int n= board.length, m=board[0].length;
        int[][] r = new int[n][m];
        int[][] c = new int[n][m];
        int[][] b = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int pos = board[i][j]-'1';
                if(r[i][pos]==1){
                    return false;
                }
                r[i][pos]=1;
                if(c[j][pos]==1){
                    return false;
                }
                c[j][pos]=1;
                int idx = (i/3)*3+j/3;
                if(b[idx][pos]==1){
                    return false;
                }
                b[idx][pos]=1;
            }
        }
        return true;
    }
 
}
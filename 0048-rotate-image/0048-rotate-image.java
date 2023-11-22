class Solution {
    int n;
    public void rotate(int[][] matrix) {
        n= matrix.length;
        transpose(matrix);
        reverse(matrix);
        
    }
    
    public void transpose(int[][] matrix){
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               int t = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
    public void reverse(int[][] matrix){
        for(int i=0;i<n;i++){
            int i1=0,j1=n-1;
            while(i1<j1){
                swap(matrix[i],i1,j1)    ;
                i1++; j1--;
            }
            
        }
    }
    public void swap(int[] matrix, int i, int j){
         int t = matrix[j];
                matrix[j]= matrix[i];
                matrix[i]=t;
    }
  
    
}
/* 

1 2 3 
4 5 6 
7 8 9


1 4 7
2 5 8
3 6 9




*/


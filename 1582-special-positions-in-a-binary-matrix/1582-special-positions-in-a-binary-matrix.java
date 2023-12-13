class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length, m= mat[0].length;
        int[] rCount =new int[n], cCount= new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    rCount[i]++;
                    cCount[j]++;
                }
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1 && rCount[i]==1 && cCount[j]==1){
                    c++;
                }
            }
        }
        return c;
        
    }
}
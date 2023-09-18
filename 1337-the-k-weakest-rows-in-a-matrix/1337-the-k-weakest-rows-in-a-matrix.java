class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans =new int[n][2];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    c++;
                }
            }
            ans[i]= new int[]{i,c};
        }
        Arrays.sort(ans, (a,b)-> a[1]==b[1]? a[0]-b[0]:a[1]-b[1]);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=ans[i][0];
        }
        return res;
    }
}
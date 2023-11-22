class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        int n = grid.length;
        int m = grid[0].length;
        int i=0, j= m*n-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            int val =grid[mid/m][mid%m];
            if(val==target){
                return true;
            }else{
                if(val>target){
                    j=mid-1;
                }else{
                    i=mid+1;
                }
            }
        }
        return false;
    }
}

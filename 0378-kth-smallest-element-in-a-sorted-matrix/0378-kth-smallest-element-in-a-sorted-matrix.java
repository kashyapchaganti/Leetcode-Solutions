class Solution {
    int n,m;
    public int kthSmallest(int[][] grid, int k) {
        n= grid.length;
        m=grid[0].length;
        int s= grid[0][0] , e= grid[n-1][m-1], ans=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(check(mid,grid,k)){
                ans= mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean check(int mid, int[][] grid, int k ){
        int count =0;
        for(int i=n-1;i>=0;i--){
            int j=m-1;
            while(j>=0){
                if(grid[i][j]>mid){
                    j--;
                }else{
                    break;
                }
            }
            count+=j+1;
        }
        return count>=k;
        
    }
}
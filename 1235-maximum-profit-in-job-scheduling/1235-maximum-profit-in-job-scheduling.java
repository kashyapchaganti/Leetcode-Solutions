class Solution {
    int n;
    int[][] nums;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n= startTime.length;
        nums= new int[n][3];
        for(int i = 0; i < n; i++){
            nums[i][0]= startTime[i];
            nums[i][1]= endTime[i];
            nums[i][2]=profit[i];
        }
        Arrays.sort(nums, (a,b)-> a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return check(dp, 0, startTime, endTime, profit);
    }
    public int check(int[] dp,int i, int[] start, int[] end, int[] profit){
        if(i>=n){
            return 0;
        }
        if(i==-1) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int next = bs(i,start, end);
        int pick = nums[i][2]+ check(dp, next, start, end, profit);
        int notPick = check(dp,i+1, start, end, profit);
        return dp[i]= Math.max(pick, notPick);
        
    }
    public int bs(int i, int[] st, int[] en){
        
        int ans=(int)(1e9);
        int s=i+1, e= n-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[i][1]<=nums[m][0]){
                ans= m;
                e= m-1;
            }else{
                s= m+1;
            }
        }
        return ans;
        
    }
}
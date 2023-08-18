class Solution {
    int n;
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        int[][] nums  = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0]= cost[i];
            nums[i][1]= time[i];
        }
        
        int[][] dp = new int[n][n+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        return check(dp, 0, n, nums);
        
    }
    public int check(int[][]dp, int i, int remWalls, int[][] nums){
        if(remWalls<=0) return 0; // 
        if(i>=n) return (int)(1e9);
        if(dp[i][remWalls]!=-1){
            return dp[i][remWalls];
        }
        // String x= i +""+ t;
        // if(dp.containsKey(x)){
        //     return dp.get(x);
        // }
        
        int a = nums[i][0]+check(dp, i+1,remWalls-nums[i][1]-1,nums);
        int b = check(dp, i+1,remWalls,nums);
        // if(t==0){
        //     System.out.println(a +" "+b);
        // }
        return dp[i][remWalls]=Math.min(a,b);
        
    }
}
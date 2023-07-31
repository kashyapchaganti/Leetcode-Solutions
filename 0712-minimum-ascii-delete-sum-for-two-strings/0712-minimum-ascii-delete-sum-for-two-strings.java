class Solution {
    int n1,n2;
    public int minimumDeleteSum(String x1, String x2) {
        char[] s1= x1.toCharArray();
        char[] s2= x2.toCharArray();
        n1= s1.length;
        n2=s2.length;
        int[][]dp = new int[n1][n2];
        for(int[] x:dp) Arrays.fill(x,-1);
        return check(dp,0,0,s1,s2);
    }
    public int check(int[][] dp, int i, int j, char[] s1, char[] s2){
        if(i==n1 && j==n2){
            return 0;
        }
        if(j==n2){
            int sum=0;
            for(int k=i;k<n1;k++){
                sum+=(int)(s1[k]);
            }
            return sum;
        }else if(i==n1){
              int sum=0;
            for(int k=j;k<n2;k++){
                sum+=(int)(s2[k]);
            }
            return sum;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=(int)(1e9);
        if(s1[i]==s2[j]){
            int a = check(dp, i+1,j+1, s1,s2);
            max=a;
        }else{
            int a = (int)(s1[i])+check(dp,i+1,j,s1,s2);
            
            int b = (int)(s2[j])+check(dp,i,j+1,s1,s2);
            // System.out.println((int)(s1[i]) +" "+(int)(s2[j]));
            max= Math.min(max, Math.min(a,b));
        }
        return dp[i][j]= max;
    }
}
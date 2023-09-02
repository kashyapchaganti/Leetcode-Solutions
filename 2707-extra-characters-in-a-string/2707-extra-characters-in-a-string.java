class Solution {
    int n;
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> m= new HashSet<>();
        for(String x: dictionary) m.add(x);
        n= s.length();
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
        return check(dp,0,s,m);
    }
    public int check(int[] dp, int i, String s,HashSet<String> m ){
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min = 1+check(dp, i+1,s,m);
        
        StringBuilder s1 = new StringBuilder();
        for(int k=i;k<n;k++){
            s1.append(s.charAt(k));
            if(m.contains(s1.toString())){
                int b = check(dp,k+1,s,m);
                min= Math.min(min,b);
            }else{
                int b=  s1.length()+check(dp, k+1,s,m);
                min= Math.min(min,b);
            }
        }
        return dp[i]= min;
    }
}
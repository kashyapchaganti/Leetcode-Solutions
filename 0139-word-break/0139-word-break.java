class Solution {
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n= s.length();
        Boolean[] dp = new Boolean[n];
        HashSet<String> m= new HashSet<>();
        for(String x: wordDict){
            m.add(x);
        }
        return check(dp,0,s,m);
    }
    public boolean check(Boolean[] dp, int i, String s, HashSet<String>  wordDict ){
        if(i==n){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        //o(n^2)
        StringBuilder x = new StringBuilder();
        boolean f= false;
        for(int k=i;k<n;k++){
            x.append(s.charAt(k));
            if(wordDict.contains(x.toString())){
                f= f||check(dp, k+1,s,wordDict);
            }
        }
        return dp[i]= f;
    }
}
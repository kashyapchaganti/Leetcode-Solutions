class Solution {
    public int numDecodings(String s) {
        int n =s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return check(dp,0,s) ;
    }
    public int check(int[] dp, int i,String s){
        if(i==s.length()){
            return 1;
        }
        if(i>s.length()){
            return 0;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(i==s.length()-1) return 1;
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int oneDigit= check(dp,i+1,s);
        int twoDigit=0;
        if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
            twoDigit= check(dp,i+2,s);
        }
        return dp[i]=oneDigit+twoDigit;
    }
}
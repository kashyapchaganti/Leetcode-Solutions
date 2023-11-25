class Solution {
    public boolean checkValidString(String s) {
        Boolean[][][] dp = new Boolean[101][101][101];
        return check(dp,0,0,0,s);
    }
    public boolean check(Boolean[][][] dp , int i, int l, int r, String s){
        if(i==s.length()){
            if(l==r){
                return true;
            }
            return false;
        }
        if(l<r) return false;
        if(dp[i][l][r]!=null){
            return dp[i][l][r];
        }
        boolean a =false;
        if(s.charAt(i)=='('){
            
            a= check(dp, i+1, l+1, r,s);
        }else if(s.charAt(i)==')'){
            a= check(dp, i+1, l, r+1,s);
        }else{
            a= check(dp, i+1, l+1, r,s);
            a = a || check(dp, i+1, l, r+1,s);
            a= a || check(dp, i+1, l+1, r+1,s);
        }
        return dp[i][l][r]=a;
    }
}
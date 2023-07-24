class Solution {
    public double myPow(double x, int y) {
        double ans=1;
        int x1= y;
        long n = Math.abs((long)y);
        while(n>0){
            if(n%2==0){
                x=x*x;
                n=n/2;
            }else{
                n=n-1;
                ans= ans*x;
            }
        }
        if(x1<0){
            return 1/ans;
        }
        return ans;
    }
}
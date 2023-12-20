class Solution {
    public int buyChoco(int[] prices, int money) {
        int n =prices.length;
        int a=(int)(1e9), b =(int)(1e9);
        for(int x: prices){
            if(a>x){
                b=a;
                a=x;
            }else if(b>x){
                b=x;
            }
        }
        if(b+a>money)return money;
        return money-(b+a);
    }
}
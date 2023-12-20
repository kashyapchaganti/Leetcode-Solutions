class Solution {
    public int buyChoco(int[] prices, int money) {
        int n =prices.length;
        Arrays.sort(prices);
        int a= prices[0];
        int b= prices[1];
        if(b+a> money) return money;
        return (money- (b+a));
    }
}
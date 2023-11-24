class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum=0;
        int n = piles.length;
        int c= n/3;
        // System.out.println(Arrays.toString(piles));
        for(int i=piles.length-2;i>=0 && c>0;i=i-2){
            c--;
            
            sum+=piles[i];
            
        }
        return sum;
    }
}
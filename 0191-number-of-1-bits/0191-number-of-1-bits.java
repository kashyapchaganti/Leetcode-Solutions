public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c=0;
        System.out.println(n);
        while(n!=0){
            if((n & 1)==1){
                c++;
            }
            
            n=n>>>1;
        }
        return c;
    }
}
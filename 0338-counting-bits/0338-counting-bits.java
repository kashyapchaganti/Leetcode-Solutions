class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            int c=0; 
            int j=i;
            while(j>0){
            if((j & 1)==1){
                c++;
            }
            j=j>>1;
            }
            ans[i]=c;
        }
        
        return ans;
    }
}
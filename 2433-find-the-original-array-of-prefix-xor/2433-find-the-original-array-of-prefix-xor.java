class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        ans[0]=pref[0];
        int xor = pref[0];
        for(int i=1;i<n;i++){
            ans[i]= pref[i] ^ xor;
            xor= xor^ans[i];
        }
        return ans;
    }
}
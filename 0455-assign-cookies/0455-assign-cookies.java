class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0, c=0, n = g.length, m= s.length;
        while(i<n && j<m){
            if(g[i]<=s[j]){
                c++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return c;
    }
}
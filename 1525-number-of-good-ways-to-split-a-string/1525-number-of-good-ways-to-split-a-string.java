class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];
        int rightUnique=0, leftUnique=0, ans=0;
        for(char ch : s.toCharArray()){
            r[ch-'a']++;
            if(r[ch-'a']==1) rightUnique++;
        }
        for(char ch : s.toCharArray()){
            l[ch-'a']++;
            if(l[ch-'a']==1) leftUnique++;
            
            r[ch-'a']--;
            if(r[ch-'a']==0) rightUnique--;
            if(leftUnique==rightUnique)ans++;
            
        }
        return ans;
    }
}
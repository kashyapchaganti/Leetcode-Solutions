public class Solution {
    public int MinSteps(string s, string t) {
        
        int[] a = new int[26];
        for(int i=0;i < s.Length;i++){
            a[s[i]-'a']++;
            a[t[i]-'a']--;
        }
        int c=0;
        foreach(int x in a){
            if(x<0){c+=Math.Abs(x);}
        }
        return c;
    }
}
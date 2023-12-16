class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] m = new int[26];
        for(char ch: s.toCharArray()){
            m[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            m[ch-'a']--;
            if(m[ch-'a']<0)return false;
        }
        return true;
    }
}
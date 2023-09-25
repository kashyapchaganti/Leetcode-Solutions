class Solution {
    public char findTheDifference(String s, String t) {
        char n =0;
        for(char ch: s.toCharArray()){
            n^=ch;
        }
        for(char ch: t.toCharArray()){
            n^=ch;
        }
        return n;
    }
}
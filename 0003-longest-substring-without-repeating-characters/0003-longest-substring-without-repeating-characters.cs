public class Solution {
    public int LengthOfLongestSubstring(string s) {
        HashSet<char> MySet= new HashSet<char>();
        int start =0,max=0;
        for(int i=0; i< s.Length; i++){
            while(MySet.Contains(s[i])){
                MySet.Remove(s[start++]);
            }
            MySet.Add(s[i]);
            max= Math.Max(max, i-start+1);
        }
        return max;
    }
}
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length(), m=abbr.length(); 
        int i=0, j=0;
        while(i<n && j<m){
            while(i<n && j<m && abbr.charAt(j)==word.charAt(i)){
                i++;
                j++;
            }
            if(i<n && j<m){
                if(abbr.charAt(j)=='0')return false;
                int start =j;
                while(j<m && Character.isDigit(abbr.charAt(j))){
                    j++;
                }
                if(start==j)return false;
                int num= Integer.parseInt(abbr.substring(start,j));
                if(i+num-1>=n)return false;
                i=i+num;
            }
        }
        if(i<n || j<m) return false;
        return true;
    }
}
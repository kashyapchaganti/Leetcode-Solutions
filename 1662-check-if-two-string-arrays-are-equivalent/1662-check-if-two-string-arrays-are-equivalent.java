class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0, j=0, a=0,b=0;
        while(i<word1.length && j<word2.length){
            if(word1[i].charAt(a++)!=word2[j].charAt(b++)){
                return false;
            }
            if(a>=word1[i].length()){
                i++;
                a=0;
            }
            if(b>=word2[j].length()){
                j++;
                b=0;
            }
            
        }
        return i==word1.length && j==word2.length ;
    }
}
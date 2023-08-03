class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();
        int i=0, j=0;
        int n1= a1.length, n2= a2.length;
        StringBuilder ans= new StringBuilder();
        while(i<n1 && j<n2){
            ans.append(a1[i]);
            ans.append(a2[j]);
            i++;
            j++;
        }
        while(i<n1){
 ans.append(a1[i]);
            i++;
        }
        while(j<n2){
 ans.append(a2[j]);           
            j++;
        }
        return ans.toString();
    }
}
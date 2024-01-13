class Solution {
    public int minSteps(String s, String t) {
        int n1 = s.length();
        int[] a= new int[26];
        int[] b= new int[26];
        for(int i=0;i<n1;i++){
            a[s.charAt(i)-'a']++;
            b[s.charAt(i)-'a']--;
            b[t.charAt(i)-'a']++;
        }
        int c=0;
        for(int x: b){
            // if(x>0 ) c++;
             if(x<0) c+= Math.abs(x);
        }
        return c;
    }
}





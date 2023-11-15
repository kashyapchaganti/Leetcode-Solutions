class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[][] arr = new int[n][26];
        arr[0][s.charAt(0)-'a']++;
        for(int i=1;i<n;i++){
            char ch = s.charAt(i);
            arr[i][ch-'a']++;
            for(int j=0;j<26;j++){
                arr[i][j]+=arr[i-1][j];
            }
        }
        int c=0;
        for(int i=0;i<n-1;i++){
            int c1=0,c2=0;
            int[] a1= arr[i];
            for(int j=0;j<26;j++){
                if(a1[j]>0){
                    c1++;
                }
            }
            for(int j=0;j<26;j++){
                if(arr[n-1][j]-arr[i][j]>0){
                    c2++;
                }
            }
            if(c1==c2){
                c++;
            }
            // System.out.println(i +" "+c1+" "+c2);
            
        }
        return c;
    }
}
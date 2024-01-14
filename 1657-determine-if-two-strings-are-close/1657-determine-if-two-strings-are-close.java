class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1= word1.length() , n2 = word2.length();
        if(n1!=n2)return false;
        int[] a = new int[26];
        int[] b= new int[26];
        
        for(char ch: word1.toCharArray()){
            a[ch-'a']++;
        }
        
        for(char ch : word2.toCharArray()){
            b[ch-'a']++;
            if(a[ch-'a']==0)return false;
            
        }
                for(char ch: word1.toCharArray()){
                       if(b[ch-'a']==0)return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int i=0;i< 26; i++){
            if(a[i]!=b[i]) return false;
        }
        
        return true;
    }
}

/*

a -> 2
b -> 2 
c -> 1
z -> 2

a -> 1 
b -> 2
c -> 1
z -> 3

1 3 2 2
1 2 2 3
*/
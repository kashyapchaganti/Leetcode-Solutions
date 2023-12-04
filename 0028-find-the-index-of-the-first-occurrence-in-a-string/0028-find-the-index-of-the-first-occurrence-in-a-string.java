class Solution {
    long mod= (long)(1e9+7);
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2= needle.length();
        char[] s1 = haystack.toCharArray(), s2= needle.toCharArray();
        long[] p1 = new long[n1], p2= new long[n2], pow_p=new long[n1];
        p1[0]= s1[0]-'a'+1l; p2[0]= s2[0]-'a'+1l;
        long prime = 233l;
        pow_p[0]=1;
        for(int i=1;i<n1;i++){
            p1[i]= (mod+(p1[i-1]*prime)%mod + s1[i]-'a'+1l)%mod;
            pow_p[i]= (prime*pow_p[i-1])%mod;
        }
        
        for(int i=1;i<n2;i++){
            p2[i]= (mod+(p2[i-1]*prime)%mod + s2[i]-'a'+1l)%mod;
            
        }
        
        
        if(n1<n2) return -1;
        long h2 = p2[n2-1];
        long h1= p1[n2-1];
        if(h1==h2) return 0;
        int start=0;
        for(int i=1;i<n1 && i+n2-1<n1;i++){
            
             h1= (mod+p1[i+n2-1]- (p1[i-1]*pow_p[n2])%mod)%mod;
            // System.out.println(i +" "+h1 +" "+h2);
            if(h2==h1)return i;
        }
        return -1;
        
    }
}
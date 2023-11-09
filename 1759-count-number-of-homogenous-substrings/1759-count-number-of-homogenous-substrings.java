class Solution {
    int mod = (int)(1e9+7);
    public int countHomogenous(String s) {
        int n = s.length();
        System.out.println(n);
        List<List<Integer>> nums = new ArrayList<>();
        for(int i=0;i<26;i++){
            nums.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int a= s.charAt(i)-'a';
            nums.get(a).add(i);
        }
        long f=0;
        for(int i=0;i<26;i++){
            List<Integer> a =nums.get(i);
            if(a.size()==0) continue;
            long c=1, ans=0;
            for(int j=0;j<a.size()-1;j++){
                if(a.get(j)+1==a.get(j+1)){
                    c++;
                }else{
                    ans=(ans+((c)*(c+1)/2))%mod;
                    c=1;
                }
            }
            ans=(ans+((c)*(c+1)/2))%mod;
            f=(f+ans)%mod;
        }
        return (int)(f);
        
    }
}
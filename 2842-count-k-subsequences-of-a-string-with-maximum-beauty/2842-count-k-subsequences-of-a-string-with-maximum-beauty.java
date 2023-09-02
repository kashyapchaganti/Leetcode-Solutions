class Solution {
    int mod = (int)(1e9+7);
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int n =s.length();
        Integer[] m= new Integer[26];
        Arrays.fill(m,0);
        for(char ch:s.toCharArray()){
            m[ch-'a']++;
        }
        Arrays.sort(m, (a,b)-> b-a);
        int c=0;
        int maxPossibleSum=0;
        for(int i=0;i<26;i++){
            if(m[i]>0 && i+1<=k){
                c++;
                maxPossibleSum+=m[i];
            }else{
                n=i+1;
                if(c<k){
                    return 0;
                }
            }
        }
        // int[][]dp = new int[27][27];
        // for(int[] x:dp){
        //      Arrays.fill(x,-1);
        // }
        HashMap<String,Long> dp = new HashMap<>();
        // System.out.println(maxPossibleSum);
        return (int)(check(dp,0,k,maxPossibleSum,m));
    }
    public long check(HashMap<String,Long> dp, int i, int k, int maxP,Integer[] m){
        if(i==26){
            if(k==0 && maxP==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(k<0 || maxP<0){
            return 0;
        }
        String x= i+" "+k +" "+maxP;
        if(dp.containsKey(x)){
            return dp.get(x);
        }
        long notTake = check(dp,i+1,k,maxP,m);
        long take = ((m[i]%mod)*(check(dp,i+1,k-1,maxP-m[i],m))%mod);
        long a2= (take+notTake)%mod;
        dp.put(x,a2);
        return a2;
    }
}
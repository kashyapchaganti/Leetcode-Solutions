class Solution {
    int mod = (int)(1e9+7);
    public int countNicePairs(int[] nums) {
        int n = nums.length; 
        HashMap<Integer,Long> m = new HashMap<>();
        for(int x: nums){
            int y = reverse(x);
            int sub= x-y;
            if(m.containsKey(sub)){
                long v= m.get(sub);
                v= (v+1);
                m.put(sub,v);
            }else{
                m.put(sub,1l);
            }
        }
        long ans=0;
        for(int x: m.keySet()){
            if(m.get(x)>1){
                long v= m.get(x);
                ans=(ans+ ((v)*(v-1))/2)%mod;
            }
        }
        
        // (a%mod)*(b^-1 %mod) -> b^-1 = b^mod-1
        return (int)(ans);
        
    }
    public int reverse(int x){
        int y=0;
        while(x>0){
            int n= x%10;
            y=(y*10)+n;
            x=x/10;
        }
        return y; 
    }
    
}
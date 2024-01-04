class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int x: nums){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        int ans=0;
        for(int x: m.keySet()){
            int v= m.get(x);
            int min= check(v);
            if(min==(int)(1e9))return -1;
            ans+=min;
        }
        return ans;
    }
    public int check(int v){
        int min=(int)(1e9);
        for(int i=0;i<=v;i++){
            int x= 3*i;
            int y= v-x;
            if(y%2==0 && y>=0){
                min= Math.min(min,(y/2)+i);
            }
        }
        return min;
    }
}
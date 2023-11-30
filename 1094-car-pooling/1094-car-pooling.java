class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        TreeMap<Integer,Integer> m = new TreeMap<>();
        for(int[] t: trips){
            int start = t[1];
            int end = t[2];
            m.put(start, m.getOrDefault(start,0)+t[0]);
            m.put(end, m.getOrDefault(end,0)-t[0]);
        }
        int total=0;
        for(int v: m.values()){
            total+=v;
            if(total>capacity)return false;
        
        }
        return true;
        
    }
}
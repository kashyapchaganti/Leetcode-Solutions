class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int x: arr){
            m.put(x, m.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: m.keySet()){
            pq.add(m.get(x));
        }
        
        while(k>0 && !pq.isEmpty()){
            int a = pq.poll();
            if(a<=k){
                k-=a;
            }else{
                return pq.size()+1;
            }
        }
        return pq.size();
    }
}


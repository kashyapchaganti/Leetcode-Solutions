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
        int c= pq.size();
        while(k>0 && !pq.isEmpty()){
            int a = pq.poll();
            while(k>0 && a>0){
                a--;
                k--;
            }
            if(a==0){
                c--;
            }else{
                return c;
            }
        }
        return c;
    }
}

/*
 3 3 4 5 5 5 
    {4:1, 3: 2,5:3}
    

*/
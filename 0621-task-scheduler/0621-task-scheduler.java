class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        HashMap<Character,Integer> m = new HashMap<>();
        for(char ch: tasks){
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        maxHeap.addAll(m.entrySet());
        int r=0;
        while(!maxHeap.isEmpty()){
            List<Map.Entry<Character,Integer>> a= new ArrayList<>();
            int x= n+1;
            while(x>0 && !maxHeap.isEmpty()){
                Map.Entry<Character,Integer> e = maxHeap.poll();
                r++;
                x--;
                e.setValue(e.getValue()-1);
                if(e.getValue()>0){
                    a.add(e);
                }
            }
            maxHeap.addAll(a);
            if(!maxHeap.isEmpty()){
                r+=x;
            }
        }
        return r;
    }
}
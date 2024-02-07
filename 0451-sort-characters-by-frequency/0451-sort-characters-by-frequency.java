class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        for(char ch: s.toCharArray()){
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>>pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> e: m.entrySet()){
            pq.add(e);
        }
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer>e= pq.poll();
            char ch = e.getKey();
            int val = m.get(ch);
            for(int i=0;i<val;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
        
    }
}
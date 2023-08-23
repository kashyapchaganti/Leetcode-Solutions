class Solution {
    int n;
    public String reorganizeString(String s1) {
        char[] arr1 = s1.toCharArray();
        n=arr1.length;
        StringBuilder s = new StringBuilder();
        HashMap<Character,Integer> m = new HashMap<>();
        for(char ch: arr1){
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> e: m.entrySet()){
            pq.add(e);
        }
        char[] arr = new char[n];
        int k=0;
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> e = pq.poll();
            if(s.length()==0 || s.charAt(s.length()-1)!= e.getKey()){
                s.append(e.getKey());
                e.setValue(e.getValue()-1);
                if(e.getValue()>0){
                    
                pq.add(e);
            }
            }else{
                if(pq.size()==0){
                    return "";
                }
                var second = pq.poll();
                s.append(second.getKey());
                second.setValue(second.getValue()-1);
                if(second.getValue()>0){
                    pq.add(second);
                }
                pq.add(e);
            }
            
        }
       
        
        return s.toString();
        
    }
    
}
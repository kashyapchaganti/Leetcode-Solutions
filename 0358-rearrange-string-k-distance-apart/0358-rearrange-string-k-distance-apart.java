class Solution {
    public String rearrangeString(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> m = new HashMap<>();
        for(char ch: s.toCharArray()){
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> free = new PriorityQueue<>((a,b)-> b.count-a.count);
        Queue<Pair> busy=new LinkedList<>();
        // add all to free 
        for(char ch: m.keySet()){
            free.add(new Pair(ch, m.get(ch),0));
        }
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(!busy.isEmpty() || !free.isEmpty() && i<s.length()){
            
            if(!busy.isEmpty() && i-busy.peek().index>=k){
                free.add(busy.peek());
                busy.poll();
            }
            
            if(free.size()==0)return"";
            Pair cur =free.poll();
            
            sb.append(cur.r);
            cur.count--;
            cur.index=i;
            if(cur.count>0)
            busy.add(cur);
            i++;
            
        }
        return sb.toString();
                     
        
        
    }
}
class Pair{
    char r;
    int count, index;
    public Pair(char r, int count, int index){
        this.r=r;
        this.count=count;
        this.index=index;
    }
    public String toString(){
        return r+" "+count+" "+index;
    }
}
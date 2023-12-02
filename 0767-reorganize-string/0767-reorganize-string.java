class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb= new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.c-a.c);
        HashMap<Character,Integer> m= new HashMap<>();
        int n =s.length();
        for(int i=0;i<n;i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        for(char ch:m.keySet()){
            pq.add(new Pair(ch,m.get(ch)));
        }
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(sb.length()==0 || sb.length()>0 && sb.charAt(sb.length()-1)!=cur.r){
                sb.append(cur.r);
                cur.c--;
                if(cur.c>0)
                pq.add(cur);
                
            }else{
                if(pq.isEmpty()){return "";}
                Pair two= pq.poll();
                sb.append(two.r);
                two.c--;
                if(two.c>0)pq.add(two);
                if(cur.c>0)pq.add(cur);
                
            }
        }
        return sb.toString().length()==n?sb.toString(): "";
    }
    
}
class Pair{
    char r;
    int c;
    public Pair(char r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int minDeletions(String s) {
        int n = s.length();
    HashMap<Character,Long> m = new HashMap<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(b.f,a.f));
    for(int i=0;i<n;i++){
      m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0l)+1l);

    }
    
    for(Map.Entry<Character,Long> e: m.entrySet()){
      pq.add(new Pair(e.getKey(),e.getValue()));
    }
    long ans=0;
    long prev= (long)(1e9); 
    // Pq =  { e: 3, b: 3, c:3, a:3 }
    
    while(!pq.isEmpty()){ 
        Pair cur = pq.poll();
        while(cur.f>=prev){   
           cur.f--;
          ans++;
        }
        if(cur.f==0){
            continue;
        }
        prev=cur.f;
    }

    return (int)ans;
    }
   
  
}
public class Pair {
    char ch;
    long f;
    public Pair(char ch, long f ){
      this.ch=ch;
      this.f=f;
    }
  }
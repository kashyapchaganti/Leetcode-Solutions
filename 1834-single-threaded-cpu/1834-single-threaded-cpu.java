class Pair{
    int s;
    int p;
    int id;
    public Pair( int id, int s, int p){
        this.id=id;
        this.s=s;
        this.p=p;
        
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Pair[] newTasks= new Pair[n];
        for(int i=0;i<n;i++){
            newTasks[i]= new Pair(i, tasks[i][0],tasks[i][1]);
        }
        int[] res =new int[n];
        Arrays.sort(newTasks, (a,b)-> a.s-b.s); 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.p==b.p? a.id-b.id: a.p-b.p);
        int i=0,j=0;
        int t= 0;
        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty() && t<newTasks[i].s){
                t=newTasks[i].s;
            }
            
            while(i<n && t>=newTasks[i].s ){
                Pair cur = newTasks[i];
                pq.add(new Pair(cur.id, cur.s, cur.p));
                i++;
            }
            Pair cur2= pq.poll();
            res[j++]=cur2.id;
            t+=cur2.p;
        }
        return res;
        
    }
}
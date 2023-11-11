class Pair{
    int r;
    
    int w;
    public Pair(int r,  int w){
        this.r=r;
        
        this.w=w;
    }
}
class Graph {
    List<List<Pair>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        adj= new ArrayList<>();
        this.n=n;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x: edges){
            adj.get(x[0]).add(new Pair(x[1],x[2]));
        }
        
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
    }
    
    public int shortestPath(int n1, int n2) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.w-b.w);
        int[] dis = new int[n];
        Arrays.fill(dis,(int)(1e9));
        dis[n1]=0;
        q.add(new Pair(n1,0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.r==n2){
                return cur.w;
            }
            for(Pair x: adj.get(cur.r)){
                if(dis[x.r]> cur.w+x.w){
                    dis[x.r]=cur.w+x.w;
                    q.add(new Pair(x.r,dis[x.r]));
                }
            }
        }
        return dis[n2]==(int)(1e9)?-1: dis[n2];
        
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
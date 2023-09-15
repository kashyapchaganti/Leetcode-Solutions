class Solution {
    public int minCostConnectPoints(int[][] p) {
        int n =p.length;
        List<Pair> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                adj.add(new Pair(i,j,Math.abs(p[i][0]-p[j][0])+Math.abs(p[i][1]-p[j][1])));
            }
        }
        Collections.sort(adj,(a,b)-> a.d-b.d);
        int sum=0;
        int connectedComp=0;
        DSU ds= new DSU(n+1);
        for(Pair x: adj){
            int a= x.r;
            int c= x.c;
            int dis = x.d;
            if(ds.find(a)!=ds.find(c)){
                ds.union(a,c);
                sum+=dis;
                connectedComp++;
                if(connectedComp==n-1){
                    break;
                }
            }
        }
        return sum;
    }
    class Pair{
        int r,c,d;
        public Pair(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    class DSU{
        int[] p, s;
        public DSU(int n){
            p=new int[n+1];
            s=new int[n+1];
            for(int i=0;i<=n;i++){
                p[i]=i;
                s[i]=1;
            }
        }
        public int find(int n){
            if(p[n]==n) return n;
            int ulp= find(p[n]);
            return ulp;
        }
        public void union(int n1, int n2){
            int p1= find(n1);
            int p2= find(n2);
            if(p1==p2){
                return ;
            }
            if(s[p1]>=s[p2]){
                s[p1]=s[p1]+s[p2];
                p[p2]=p1;
            }else{
                s[p2]=s[p1]+s[p2];
                p[p1]=p2;
            }
        }
    }
}
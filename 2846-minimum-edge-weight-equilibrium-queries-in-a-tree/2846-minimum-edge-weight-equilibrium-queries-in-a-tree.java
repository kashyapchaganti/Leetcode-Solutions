class Pair{
    int r, c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<List<Pair>> adj = new ArrayList<>();
        int[][] map =new int[n+1][27];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x: edges){
            adj.get(x[0]).add(new Pair(x[1],x[2]));
            adj.get(x[1]).add(new Pair(x[0],x[2]));
        }
        int[][] dp = new int[n+1][21];
        int[] depth = new int[n+1];
        binaryLifting(dp,0,-1,adj);
        check(depth,0,-1,map,adj);
        // for(int[] x: map){
        //     System.out.println(Arrays.toString(x));
        // }
        // System.out.println(Arrays.toString(depth));
        int[] ans = new int[queries.length];
        int k1=0;
        for(int[] x: queries){
            int a = x[0],b=x[1];
            int[] comb= new int[27];
            int lca = getLca(a,b,depth,dp);
            // System.out.println(lca +" LCA "+k1);
            int fmax = -1;
            int num=0;
            int c=0;
            for(int i=0;i<=26;i++){
                comb[i]= map[a][i]+map[b][i]-2*map[lca][i];
                fmax= Math.max(fmax,comb[i]);
                if(comb[i]>0){
                    c+=comb[i];
                }
            }
                // System.out.println(a+" "+b +" "+Arrays.toString(comb));
            ans[k1++]=c-fmax;
            
        }
        
        return ans;
        
        
    }
    public void check(int[] depth, int i, int p, int[][] map, List<List<Pair>> adj){
        if(p!=-1){
            depth[i]=depth[p]+1;
        }else{
            depth[i]=0;
        }
        for(Pair x: adj.get(i)){
            if(x.r==p)continue;
            int val= x.c;
            map[x.r][val]++;
            for(int j=0;j<=26;j++){
                map[x.r][j]+=map[i][j];
            }
            check(depth,x.r,i,map,adj);
        }
    }
    public int getLca(int a,int b, int[] depth,int[][]dp){
        if(depth[a]>depth[b]){
            int t= a;
            a=b;
            b=t;
        }
        int remJump= depth[b]-depth[a];
        // System.out.println(depth[a] +" DEPTH "+ depth[b] +" "+a +" "+b);
        int finalB= getKLevels(b,remJump,dp);
        // System.out.println(finalB +" "+remJump);
        // System.out.println(depth[a]+" final Node "+depth[finalB]);
        
        if(finalB!=-1){
            int s=0, e=depth[finalB];
            int ans=e;
            while(s<=e){
                int m = s+(e-s)/2;
                int a1= getKLevels(a,m,dp);
                int b1= getKLevels(finalB,m,dp);
                if(a1==b1){
                    
                    ans= a1;
                    e=m-1;
                }else{
                    s=m+1;
                }
            }
            // System.out.println(ans);
            return ans;
        }
        return -1;
        
        
    }
    public int getKLevels(int b, int r, int[][] dp){
        if(r==0 || b==-1){
            return b;
        }
        // int a= (int)(1e9);
        for(int k=20;k>=0;k--){
            if(r >= (1 << k)){
                int nextNode = dp[b][k];
                r= r-(1 << k);
                
                return getKLevels(nextNode,r,dp);
            }
        }
        return -1;
    }
    public void binaryLifting(int[][] dp, int i, int p,List<List<Pair>> adj){
        dp[i][0]=p;
        for(int j=1;j<=20;j++){
            if(dp[i][j-1]!=-1){
                dp[i][j]= dp[dp[i][j-1]][j-1];
            }else{
                dp[i][j]=-1;
            }
        }
        for(Pair x: adj.get(i)){
            if(x.r!=p)
            binaryLifting(dp,x.r,i,adj);
        }
    }
}
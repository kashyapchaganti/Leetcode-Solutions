class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n+1];
        for(int[] x: relations){
            adj.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ans=0;
        int total=0;
        while(!q.isEmpty()){
            int n1= q.size();
            for(int i=0;i<n1;i++){
                int cur =q.poll();
                total++;
                for(int x: adj.get(cur)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.add(x);
                }
            }
            }
            ans++;
            
        }
        return total==n?ans:-1;
    }
}
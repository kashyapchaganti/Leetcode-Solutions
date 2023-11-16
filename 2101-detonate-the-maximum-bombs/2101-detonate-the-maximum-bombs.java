class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length; 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i==j) continue; 
                long x1 = bombs[i][0],y1= bombs[i][1],r1= bombs[i][2], x2=bombs[j][0],y2=bombs[j][1],r2=bombs[j][2];
                long l = (Math.abs(x1-x2)*Math.abs(x1-x2) + Math.abs(y1-y2)*Math.abs(y1-y2));
                if(l<=r1*r1){
                    adj.get(i).add(j);
                }
            }
        }
        // System.out.println(adj);
        int max=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> s = new HashSet<>();
            check(i,s,adj);
            max= Math.max(max,s.size());
            
        }
        return max;
    }
    public void check(int i, HashSet<Integer> s,List<List<Integer>> adj  ){
        
        s.add(i);
        for(int x: adj.get(i)){
            if(s.contains(x)) continue; 
            
            check(x,s,adj);
        }
        return ;
    }
}
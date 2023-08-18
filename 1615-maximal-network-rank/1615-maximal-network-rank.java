class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] x:roads){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            // HashSet<Integer> s= new HashSet<>();
            
            for(int j=0;j<n;j++){
                if(i!=j ){
                    if(adj.get(i).contains(j)){
                        max= Math.max(max, adj.get(i).size()+adj.get(j).size()-1);    
                    }else{
                        max= Math.max(max, adj.get(i).size()+adj.get(j).size());
                    }
                    
                    
                }
                
            }
            
        }
        return max;
    }
}
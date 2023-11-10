class Solution {
    public int[] restoreArray(int[][] nums) {
        int n = nums.length;
        HashMap<Integer, HashSet<Integer>> m= new HashMap<>();
        
        for(int[] x: nums){
            if(!m.containsKey(x[0])){
                m.put(x[0],new HashSet<>());
            }
            m.get(x[0]).add(x[1]);
            if(!m.containsKey(x[1])){
                m.put(x[1],new HashSet<>());
            }
            m.get(x[1]).add(x[0]);
        }
        Queue<Integer> q= new LinkedList<>();
        for(int x: m.keySet()){
            if(m.get(x).size()==1){
                q.add(x);
                break;
            }
        }
        int[] ans = new int[m.size()];
        int i=0;
        while(!q.isEmpty()){
            int v= q.poll();
            ans[i++]= v;
            for(int y: m.get(v)){
                
                m.get(y).remove(v);
                
                if(m.get(y).size()<=1){
                    q.add(y);
                }
            }
            
        }
        return ans;
        
    }
}
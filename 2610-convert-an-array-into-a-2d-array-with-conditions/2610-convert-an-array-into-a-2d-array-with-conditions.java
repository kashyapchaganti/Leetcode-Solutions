class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int x: nums){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        for(int key: m.keySet()){
            int size = m.get(key);
            for(int i=0;i<size;i++){
                if(ans.size()<i+1){
                    ans.add(new ArrayList<>());
                }
                ans.get(i).add(key);
            }
        }
        return ans;
            
    }
}
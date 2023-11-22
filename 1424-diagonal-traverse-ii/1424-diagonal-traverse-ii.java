class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        int n=0;
        for(int i=nums.size()-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                int sum= i+j;
                if(!m.containsKey(sum)){
                    m.put(sum,new ArrayList<>());
                }
                m.get(sum).add(nums.get(i).get(j));
                n++;
            }
        }
        int[] ans = new int[n];
        int i=0, curr=0;
        
        while (m.containsKey(curr)) {
            for (int num : m.get(curr)) {
                ans[i] = num;
                i++;
            }
            
            curr++;
        }
        return ans;
    }
}
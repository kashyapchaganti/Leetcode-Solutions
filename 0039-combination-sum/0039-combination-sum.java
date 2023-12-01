class Solution {
    int[] candidates;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res= new ArrayList<>();
        this.candidates= candidates;
        check(0, target, new ArrayList<>());
        return res;
    }
    public void check(int i, int target, List<Integer> x){
        if(target==0){
            res.add(new ArrayList<>(x));
            return ;
        }
        if(target<0 || i>= candidates.length) return;
        
        x.add(candidates[i]);
        check(i,target-candidates[i],x);
        x.remove(x.size()-1);
        check(i+1, target,x);
        
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> x = new ArrayList<>();
            List<Integer> prev = res.get(res.size()-1);
            x.add(0,1);
            for(int j=1;j<i;j++){
                x.add(prev.get(j-1)+prev.get(j));
            }
            x.add(1);
            res.add(new ArrayList<>(x));
        }
        return res;
    }
}
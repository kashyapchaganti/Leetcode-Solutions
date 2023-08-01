class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>arr = new ArrayList<>();
        check(arr,new ArrayList<>(), 0,k, n);
        
        return arr;
        
    }
    public void check(List<List<Integer>> arr, List<Integer> x, int i, int k, int n){
        if(k==0){
            arr.add(new ArrayList<>(x));
            return ;
        }
        for(int j=i;j<n;j++){
              x.add(j+1);
                check(arr,x,j+1,k-1,n);
                x.remove(x.size()-1);
        }
    }
}
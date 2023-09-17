class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long max=0;
        for(int i=1;i<=n;i++){
            long sum=0;
            for(int j=1;j<=100;j++){
                
                if((i*j*j)<=n){
                    int idx=i*j*j;
                    sum+=nums.get(idx-1);
                }else if(i*j*j>n){
                    break;
                }
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
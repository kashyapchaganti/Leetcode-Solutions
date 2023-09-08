class Solution {
    public long minCost(int[] nums, int x) {
        int n =nums.length;
        int[] prev = new int [n];
        long s=0;
        for(int i=0;i<n;i++){
            prev[i]=nums[i];
            s+=nums[i];
        }
        long min= s;
        for(int i=1;i<n;i++){
            long s1=0;
            for(int j=0;j<n;j++){
                if(prev[j]>nums[(j+i)%n]){
                    s-=prev[j];
                    prev[j]=nums[(j+i)%n];
                    s+=prev[j];
                    s1+=prev[j];
                }else{
                    s1+=prev[j];
                }
            }
            s1+=(long)(i)*(long)(x);
            min= Math.min(min,s1);
        }
        return min;
    }
}
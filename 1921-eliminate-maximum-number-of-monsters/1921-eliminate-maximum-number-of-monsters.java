class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[][]  nums = new double[n][3];
        for(int i=0;i<n;i++){
            nums[i][0]=dist[i];
            nums[i][1]=speed[i];
            nums[i][2]= (double)dist[i]/speed[i];
        }
        Arrays.sort(nums,(a,b)-> Double.compare(a[2],b[2]));
        
        int ans=0;
        
        
        for(int i=0;i<n;i++){
            if(nums[i][2]>ans){
                ans++;
            }else{
                return ans;
            }
        }
        return ans;
        
    }
}
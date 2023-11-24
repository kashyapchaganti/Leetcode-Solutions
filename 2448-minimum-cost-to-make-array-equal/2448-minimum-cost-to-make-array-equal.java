class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n =nums.length;
        // first find the cost to make all elements equal to some number 
        // then you can use prefix sums to make them all equals to anything else by just adding or removing 
        
        int[][] arr = new int[n][2];
        long totalFreq=0;
        for(int i=0;i<n;i++){
            arr[i][0]= nums[i];arr[i][1]= cost[i];
            totalFreq+=arr[i][1];
        }
        Arrays.sort(arr, (a,b)-> a[0]-b[0]);
        int median =0; long curFreq=0;
        for(int i=0;i<n;i++){
            curFreq+=arr[i][1];
            if(curFreq>=((totalFreq+1)/2)){
                median = i;
                break;
            }
        }
        // System.out.println(median);
        // for(int[] x: arr){
        // System.out.println(Arrays.toString(x));
        // }
        long ans=0;
        for(int i=0;i<n;i++){
            ans+= Math.abs(arr[i][0]-arr[median][0])*1L*arr[i][1];
        }
        return ans;
        
        
        
    }
}
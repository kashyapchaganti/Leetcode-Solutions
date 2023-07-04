class Solution {
    
    public int maximumRequests(int n, int[][] requests) {
        int[] nums = new int[n];
        return check(0,nums, requests,n,0);
    }
    public int check(int i, int[] nums, int[][] requests, int n, int c){
        if(i==requests.length){
            
            // System.out.println(x);
            for(int x: nums){
                if(x!=0) return 0; 
            }
            return c;
        }
        int max= 0;
        int s= requests[i][0], e= requests[i][1];
        nums[s]--;
        nums[e]++;
        
        int a = check(i+1,nums,requests,n,c+1);
        nums[s]++;
        nums[e]--;
        
        int b = check(i+1,nums,requests,n,c);
        max= Math.max(a,b);
        return max;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int s=0,start=0,max=0;
        int ts =0; 
        for(int y: nums) ts+=y;
        if(ts<x) return -1;
        // System.out.println(ts);
        if(ts==x) return n;
        for(int i=0;i<n;i++){
            s+=nums[i];
            while(s>ts-x && start<i){
                s-=nums[start++];
            }
            if(s==ts-x) max= Math.max(max, i-start+1);
        }
        return max==0? -1: n-max;
    }

    

}
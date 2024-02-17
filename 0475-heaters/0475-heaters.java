class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length; 
        int max = 0;
        Arrays.sort(heaters);
        for(int i=0;i<n;i++){
            max = Math.max(max, getNearestLowerBoundOrUpperBoundDiff(houses[i],heaters));
        }
        return max;
    }
    public int getNearestLowerBoundOrUpperBoundDiff(int val, int[] nums){
        int s= 0, e= nums.length-1;
        int lb=-1,ub=-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[m]<=val){
                lb=nums[m];
                s=m+1;
            }else{
                e=m-1;
            }
        }
        s=0; e= nums.length-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[m]>=val){
                ub=nums[m];
                e=m-1;
            }else{
                
                s=m+1;
            }
        }
        int ans = (int)(1e9);
        if(lb!=-1){
            ans = Math.abs(lb-val);
        }
        if(ub!=-1){
            ans = Math.min(ans,Math.abs(ub-val));
        }
        return ans;
        
    }
}

/*

1     4
1 2 3 4


*/
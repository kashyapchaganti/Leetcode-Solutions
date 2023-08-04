class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] max= new int[n];
        int[] min= new int[n];
        // Arrays.fill(min, (int)(1e9));
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            max[i]= Math.max(nums[i],max[i-1]);
            
        }
        min[n-1]= nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            min[i]= Math.min(min[i+1],nums[i]);
        }
        long s=0;
        // System.out.println(Arrays.toString(max));
        // System.out.println(Arrays.toString(min));
        for(int i=1;i<n-1;i++){
            if(nums[i]>max[i-1] && nums[i]<min[i+1]){
                s+=2;
            }else if(nums[i]>nums[i-1] &&nums[i]<nums[i+1] ){
                s+=1;
            }
        }
        return (int)(s);
    }
}
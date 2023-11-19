class Solution {
    public int reductionOperations(int[] nums) {
        
        int c=0;
        int ans=0;
        Arrays.sort(nums);
        int min = nums[0];
        
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]!=min){
                if(nums[i]==nums[i-1]){
                    c++;
                }else{
                    c++;
                    ans+=(c);
                    
                }
            }else{break;}
        }
        
        return ans;
        
    }
}

/*

1  2 2  3 3 3  4 4 4 4 5 5 5 5 5
1 2 3 4 5 
1 2 3 9 (5+9)

1 2 12 (5+5 + 4 + 5+ 4 + 3 + 5+ 4+ 3 + 2)

1 14 

15


*/
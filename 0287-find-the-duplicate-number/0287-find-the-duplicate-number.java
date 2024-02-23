class Solution {
    public int findDuplicate(int[] nums) {
        // idea is brilliant check description
        int a = nums[0], b= nums[0];
        a= nums[a];b=nums[nums[b]];
        while(a!=b){
            a= nums[a];b=nums[nums[b]];
        }
        a= nums[0];
        while(a!=b){
            a= nums[a];
            b= nums[b];
        }
        return a;
    }
}

/*

1 3 4 2 2 

1 -> 3 - > 2  -> 4 -> 2 - > 4


*/
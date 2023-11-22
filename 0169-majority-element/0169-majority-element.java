class Solution {
    public int majorityElement(int[] nums) {
        // moores voting algo 
        int n = nums.length;
        int ele=0, cnt=0;
        for(int x: nums){
            if(cnt==0){
                cnt++;
                ele=x;
            }else if(x==ele){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ele;
    }
}
class Solution {
    public int maxArea(int[] height) {
        int left =0; 
        int right =height.length-1;
        int max = 0;
        while(left<right){
            int cur_max = Math.abs(left-right)* Math.min(height[right],height[left]);
            max = Math.max(cur_max,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        
        return max;
    }
}
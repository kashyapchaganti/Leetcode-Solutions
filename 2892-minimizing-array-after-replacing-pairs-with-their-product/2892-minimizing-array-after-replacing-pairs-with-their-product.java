class Solution {
    public int minArrayLength(int[] nums, int k) {
        Stack<Long> st =new Stack<>();
        for(int i=0;i<nums.length;i++){
            long next = (long)(nums[i]);
            
            if(!st.isEmpty() && st.peek() * next<=k){
                
                while(!st.isEmpty() && st.peek() * next<=k){
                next*=st.pop();   
                }
                st.push(next);
                
            }
            else if(st.isEmpty() || st.peek()*next>k){
                st.push(next);
            }
        }
        return st.size();
    }
}


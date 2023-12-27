class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        Stack<Integer> st = new Stack();
        int cost=0;
        for(int i=0;i<n;i++){
            int min= Integer.MAX_VALUE;
            if(!st.isEmpty() && colors.charAt(st.peek())==colors.charAt(i)){
                min= Math.min(neededTime[i],min);
                if(min>neededTime[st.peek()]){
                    cost+=neededTime[st.peek()];
                    st.pop();
                    st.push(i);
                    continue;
                }else{
                    cost+=min;
                    continue;
                }
            }
            st.push(i);
        }
        return cost;
    }
}
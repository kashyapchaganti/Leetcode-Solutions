class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        
        int cost=0;
        int prev=-1,min= (int)(1e9);
        for(int i=0;i<n;i++){
            int cur = colors.charAt(i)-'a';
            if(prev==cur){
                if(min>neededTime[i]){
                    cost+=neededTime[i];    
                }else{
                    cost+=min;
                    min=neededTime[i];   
                }
                
            }else{
                prev=cur;
                min=neededTime[i];
            }
        }
        return cost;
    }
}
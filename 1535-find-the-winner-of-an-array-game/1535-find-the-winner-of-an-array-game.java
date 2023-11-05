class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        Stack<Integer> st = new Stack();
        
        int max=0;
        int ans=0,c=0;
        
        for(int x: arr){
            if(!st.isEmpty() ){
                if(st.peek()>x){
                    c++;    
                }else{
                    if(max<c){
                        max= c;
                        ans=st.peek();
                        if(max>=k)return ans;
                        
                    }
                    c=1;
                    st.pop();
                    st.push(x);
                }
                
            }else{
                st.push(x);
                
            }
        }
        return st.peek();
    }
}
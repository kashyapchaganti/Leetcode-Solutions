class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for(String x: tokens){
            if(x.equals("+") || x.equals("/") || x.equals("*") || x.equals("-")){
               
                int a = st.pop();
                int b =st.pop();
                if(x.equals("+")){
                    a=a+b;
                    st.push(a);
                }else if(x.equals("/")){
                    a= b/a;
                    st.push(a);
                }else if(x.equals("*") ){
                    a= a*b;
                    st.push(a);
                }else{
                    a=b-a;
                    st.push(a);
                }
            }else{
                st.push(Integer.parseInt(x));
            }
        }
        return st.peek();
    }
}
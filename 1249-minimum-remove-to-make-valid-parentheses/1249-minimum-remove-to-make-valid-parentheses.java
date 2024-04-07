class Solution {
    public String minRemoveToMakeValid(String s) {
        int n =s.length();
        Stack<Integer> st = new Stack();
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ;i< n;i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    set.add(i);
                }    
            }else if(ch=='('){
                st.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==i){
                st.pop();
                continue;
            }else if(set.contains(i)){
                continue;
            }
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
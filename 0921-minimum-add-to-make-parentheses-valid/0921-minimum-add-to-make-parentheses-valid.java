class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack();
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ch==')'){
                st.pop();
            }else if(ch=='('){
                st.push('(');
            }else if(ch==')') c++;
        }
        return c+st.size();
    }
}
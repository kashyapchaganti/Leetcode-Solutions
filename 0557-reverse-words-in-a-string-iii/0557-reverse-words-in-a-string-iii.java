class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String x: s.split(" ")){
            sb.append(rev(x));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public String rev(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
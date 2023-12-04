class Solution {
    public String largestGoodInteger(String s) {
        int n=s.length();
        int c=-1;
        for(int i=0;i<n-2;i++){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2)){
                int v = Integer.parseInt(s.substring(i,i+3));
                c= Math.max(c, v);
            }
        }
        if(c==0){
            return "000";
        }else if(c==-1) return "";
        return c+"";
    }
}
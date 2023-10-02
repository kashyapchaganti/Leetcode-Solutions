class Solution {
    public boolean winnerOfGame(String colors) {
        int n =colors.length();
        int a=0,b =0;
        for(int i=1;i<n-1;i++){
            if(colors.charAt(i)=='A'){
                if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                    a++;
                }
            }else{
                if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                    b++;
                }
            }
        }
        return a-b>=1;
        
    }
}
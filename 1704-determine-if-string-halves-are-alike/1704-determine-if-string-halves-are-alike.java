class Solution {
    public boolean halvesAreAlike(String st) {
        String vowels= "aeiouAEIOU";
        int l=0, r=st.length()-1;
        int mid = l+(r-l)/2;
        int c1=0,c2=0;
        for(int i=l;i<=r;i++){
            char ch = st.charAt(i);
            if(i<=mid){
                if(vowels.indexOf(ch)!=-1){
                    c1++;
                }    
            }else{
                if(vowels.indexOf(ch)!=-1){
                    c2++;
                }    
            }
        }
        return c1==c2? true:false;
        
    }
}
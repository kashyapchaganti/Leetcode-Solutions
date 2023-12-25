class Solution {
    public int minOperations(String s) {
        int n =s.length();
        int min= Integer.MAX_VALUE;
        int prev=s.charAt(0)-'0';
        int c=0;
        for(int i=1;i<n;i++){
            int cur= s.charAt(i)-'0';
            if(prev==0){
                if(cur==1){
                    prev=1;
                    continue;
                }else{
                    prev=1;
                    c++;
                }
            }else{
                 if(cur==0){
                    prev=0;
                    continue;
                }else{
                    prev=0;
                    c++;
                }
            }
        }
        min= c;
        c=0;
        prev=s.charAt(0)-'0';
        
        if(prev==0){
            prev=1;
        }else{
            prev=0;
        }
        c++;
        // System.out.println(prev);
         for(int i=1;i<n;i++){
            int cur= s.charAt(i)-'0';
            if(prev==0){
                if(cur==1){
                    prev=1;
                    continue;
                }else{
                    prev=1;
                    c++;
                }
            }else{
                 if(cur==0){
                    prev=0;
                    continue;
                }else{
                    prev=0;
                    c++;
                }
            }
        }
        min= Math.min(c,min);
        return min;
        
            
    }
}

// 10101000
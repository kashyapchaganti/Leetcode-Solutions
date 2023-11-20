class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p=0;
        int m=0;
        int g=0;
        int n = garbage.length;
        int[][] count = new int[n][3];
        int[] last = new int[3];
        for(int i=0;i<garbage.length;i++){
            String x = garbage[i];
            int a=0,b=0,c=0;
            for(int j=0;j<x.length();j++){
                if(x.charAt(j)=='P'){
                    a++;
                    p++;
                }else if(x.charAt(j)=='M'){
                    b++; 
                    m++;
                }else if(x.charAt(j)=='G'){
                    c++; 
                    g++;
                }
            }
            if(a!=0){
                last[0]=i;
            }
            if(b!=0){
                last[1]=i;
            }
            if(c!=0){
                last[2]=i;
            }
            count[i]=new int[]{a,b,c};
        }
            
            long ans=0;
            if(p!=0){
                ans+=check(0,count,last,travel);
            }
            if(m!=0){
                ans+=check(1,count,last,travel);
            }
            if(g!=0){
                ans+=check(2,count,last,travel);
            }
            return (int)(ans);
        
        
    }
    public int check(int k,int[][] count,int[] last,int[] travel){
        int s=0;
        for(int i=0;i<count.length;i++){
            s+=count[i][k];
            if(i==last[k]){
                break;
            }else{
                s+=travel[i];
            }
        }
        return s;
    }
}
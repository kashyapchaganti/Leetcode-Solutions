class Solution {
    int finalAns,n;
    int[] py,pn;
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int s= 0 , e= arr.length-1;
        n=arr.length;
        int ans = e+1;
        finalAns=e+1;
        py = new int[n];
        pn = new int[n];
        py[0]= arr[0]=='Y'?1:0;
        pn[0]= arr[0]=='N'?1:0;
        for(int i=1;i<n;i++){
            if(arr[i]=='Y'){
                py[i]=py[i-1]+1;
                pn[i]=pn[i-1];
            }else{
                pn[i]=pn[i-1]+1;
                py[i]=py[i-1];
            }
        }
        // returns the min penalty if possible 
        
        while(s<=e){
            int m = s+(e-s)/2;
            if(check(m,arr)){
                ans= m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return finalAns;
        
        
    }
    public boolean check(int m, char[] arr){
        int c=n;
        boolean f=false;
        if(py[n-1]==m){
            finalAns=0;
            return true;
        }
        for(int i=0;i<n;i++){
            int a =i+1;
            int cy1= py[n-1]-py[i];
            // int cy2= py[i];
            // int cn1= pn[n-1]-pn[i];
            int cn2=pn[i];
            if(cy1+cn2<=m){
                finalAns=a; 
                f=true;
            }
            // if(cy2+cn1<=m){
            //     finalAns=a; 
            //     f=true;
            // }
            if(f){
                break;
            }
            
        }
        if(finalAns==2){
            System.out.println(m +" "+f);
        }
        return f;
    }
}

// // 3 y 1 n  
// class Solution {
//     //https://www.youtube.com/watch?v=3PoCVTHf0u4
//     public int bestClosingTime(String c) {
//         int[] pSum_Y = new int[c.length()];
//         int[] pSum_N = new int[c.length()];
//         int n=c.length();
//         pSum_Y[0]=c.charAt(0)=='Y'?1:0;
//         pSum_N[0]=c.charAt(0)=='N'?1:0;
//         for(int i=1;i<n;i++){
//             pSum_Y[i]=pSum_Y[i-1]+(c.charAt(i)=='Y'?1:0);
//             pSum_N[i]=pSum_N[i-1]+(c.charAt(i)=='N'?1:0);
//         }
//         //System.out.println(Arrays.toString(pSum_Y));
//         //System.out.println(Arrays.toString(pSum_N));
//         int ans=0,min=(int)(1e9);
//         for(int i=0;i<=n;i++){
            
            
            
//             int before_penalty = (i>0)?pSum_N[i-1]:0;    
            
//             int after_penalty = (i<n)?(pSum_Y[n-1]-((i>0)?pSum_Y[i-1]:0)):0;
            
//             int m = before_penalty+after_penalty;
//             if(i==1){
//            System.out.println(m);               
//             }
//             if(m<min){
//                 min=m;
//                 ans=i;
//             }
//         }
//         // System.out.println(min);
//         return ans;
//     }
// }
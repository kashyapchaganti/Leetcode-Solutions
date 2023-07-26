class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int s=1, e = 10000000,ans=-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(check(m,dist,hour)){
                ans= m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;
    }
    public boolean check(int m, int[] dist, double h){
        double s=0;
        for(int i=0;i<dist.length-1;i++){
            if(dist[i]%m==0){
                s+=dist[i]/m;
            }else{
                s+=(double)(dist[i]/m)+1;
                
            }
        }
        s+=((double)dist[dist.length-1]/(double)m);
        return s<=h;
    }
}